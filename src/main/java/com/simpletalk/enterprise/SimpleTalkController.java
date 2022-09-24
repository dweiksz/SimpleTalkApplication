package com.simpletalk.enterprise;

import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleTalkController {

    @Autowired
    private IPostService postService;

    // Handles root or (/) endpoint and returns start page
    @RequestMapping("/")
    public String index(Model model) {
        Post post = new Post();
        post.setPostID(0);
        post.setUserID("0");
        post.setUserName("TestUser0");
        post.setMessage("This is a test post.");
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
}
