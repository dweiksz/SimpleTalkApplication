package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.Post;
import org.springframework.stereotype.Component;

@Component
public class PostServiceStub implements IPostService {
    @Override
    public Post fetchById(int id) {
        Post post = new Post();
        post.setPostID("10");
        post.setMessage("I love Lord of the Rings!");
        return post;
    }

    @Override
    public void save(Post post) {

    }
}
