package com.simpletalk.enterprise;

import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class SimpleTalkController {
    Logger logger = Logger.getLogger(SimpleTalkController.class.getName());

    @Autowired
    private IPostService postService;

    /**
     * Handle the / endpoint
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        return "startPage";
    }

    @RequestMapping("/explore")
    public String explore() { return "explorePage"; }

    @RequestMapping("/makePost")
    public String makePost() {
        return "makePost";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "userProfile";
    }

    @RequestMapping("/signup")
    public String signup() { return "userSignup"; }

    @RequestMapping("/login")
    public String login() { return "userLogin"; }

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

    /**
     * Fetch all posts.
     *
     * Returns one of the following status codes:
     * 200: posts found.
     * 400: posts not found.
     */
    @GetMapping("/post")
    @ResponseBody
    public List<Post> fetchAllPosts() {
        try {
            return postService.fetchAll();
        } catch (Exception e) {
            logger.log(Level.WARNING, "No Posts were fetched!");
            throw new RuntimeException(e);
        }
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
    public ResponseEntity fetchPostsById(@PathVariable("id") Integer id) {
        Post foundPost = postService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundPost, headers, HttpStatus.OK);
    }

    /**
     * Create a new post object, given the data provided.
     *
     * Returns one of the following status codes:
     * 201: successfully created a new post.
     * 409: unable to create a post, because it already exists.
     *
     * @param post a JSON representation of a post object.
     * @return the newly created post object.
     */
    @PostMapping(value="/post", consumes="application/json", produces="application/json")
    public Post createPost(@RequestBody Post post){
        Post newPost = null;
        try{
            newPost = postService.save(post);
        } catch (Exception e){
            logger.log(Level.WARNING, "Your post was not created.");
        }
        return newPost;
    }

    /**
     * Delete a post with the given id.
     *
     * Given the parameter id, delete the post that corresponds to this unique id.
     *
     * Returns one of the following status codes:
     * 200: post deleted.
     * 404: post not found.
     *
     * @param id a unique identifier for this post.
     */
    @DeleteMapping("/post/{id}/")
    public ResponseEntity deletePost(@PathVariable("id") Integer id) {
        try {
            postService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
