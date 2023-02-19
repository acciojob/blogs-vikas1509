package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();

        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        blog.getImageList().add(image);

        blogRepository2.save(blog); //cascade saved image too

        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int count=0;
        Image image = imageRepository2.findById(id).get();
       // Image image=imageRepository2.findById(id).get();

        if(image==null)return 0;


        String imageDimension[]=image.getDimensions().split("X");
        int imageLength=Integer.parseInt(imageDimension[0]),
                imageBreadth=Integer.parseInt(imageDimension[1]);

        String screenDimension[]=screenDimensions.split("X");
        int screenLength=Integer.parseInt(screenDimension[0]),
                screenBreadth=Integer.parseInt(screenDimension[1]);

        count=(screenLength/imageLength)*(screenBreadth/imageBreadth);
        return count;
    }
}