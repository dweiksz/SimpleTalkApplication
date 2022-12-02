package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.model.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private PostRepo postRepo;

    @PostMapping("/savePost")
    public String savePost(Post post) {
        postRepo.save(post);
        return "The post has been saved. Exit this page.";
    }

    @GetMapping("/profileData")
    public List<Post> getUserPosts() {
        return postRepo.findAll();
    }
}
