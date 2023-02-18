package com.driver.controller;

import com.driver.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;
    @GetMapping
    public ResponseEntity<Integer> getAllBlogs() {
        int countOfBlogs = 0;
        return new ResponseEntity<>(countOfBlogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBlog(@RequestParam Integer userId ,
                                     @RequestParam String title,
                                     @RequestParam String content) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{blogId}/add-image")
    public ResponseEntity<String> addImage(@PathVariable int blogId, @RequestParam String description, @RequestParam String dimensions) {

        return new ResponseEntity<>("Added image successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int blogId) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



