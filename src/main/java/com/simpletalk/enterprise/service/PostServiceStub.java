package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostServiceStub implements IPostService {

    public PostServiceStub(IPostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public Post fetchById(int id) {
        Post newPost = postDAO.fetch(id);
        return newPost;
    }

    public void delete(int id) {
        postDAO.delete(id);
    }

    @Override
    public Post save(Post post) throws Exception{
        return postDAO.save(post);
    
    }

    @Override
    public List<Post> fetchAll(){
        return postDAO.fetchAll();
    }
}
