package com.simpletalk.enterprise;

import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleTalkController {

    @Autowired
    private IPostService postService;

    // Handles root or (/) endpoint and returns start page
    @RequestMapping("/")
    public String index(Model model) {
        Post post = new Post();
        post.setUserID(1);
        post.setPostID("10");
        post.setUserName("TestUser0");
        post.setMessage("\"I love Lord of the Rings!\"");
        post.setLikes(2);
        model.addAttribute(post);
        return "startPage";
    }

    @RequestMapping("/savePost")
    public String savePost(Post post) {
        try {
            postService.save(post);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "startPage";
        }
        return "startPage";
    }

    @GetMapping("/post")
    public ResponseEntity fetchAllPosts() {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Fetch a post with the given id.
     *
     * Given the parameter id, find a post that corresponds to this unique id.
     *
     * Returns one of the following status codes:
     * 200: post found
     * 400: post not found
     *
     * @param id a unique identifier for this post
     */
    @GetMapping("/post/{id}")
    public ResponseEntity fetchPostsById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/post", consumes="application/json", produces="application/json")
    public Post createPost(@RequestBody Post post){
        return post;
    }

    @DeleteMapping("/post/{id}/")
    public ResponseEntity deletePost(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
