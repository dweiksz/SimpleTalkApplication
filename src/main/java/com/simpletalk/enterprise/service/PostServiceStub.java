package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dao.IPostDAO;
import com.simpletalk.enterprise.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceStub implements IPostService {

    @Autowired
    private IPostDAO postDAO;

    public PostServiceStub(){

    }

    public PostServiceStub(IPostDAO postDAO){

        this.postDAO = postDAO;
    }

    @Override
    public Post fetchById(int id) {
        Post foundPost = postDAO.fetchByID(id);
        return foundPost;
    }

    @Override
    public Post save(Post post) throws Exception {
        return postDAO.save(post);
    }

    @Override
    public List<Post> fetchAll() throws Exception {
        return postDAO.fetchAll();
    }


    @Override
    public void delete(int id) throws  Exception{
        postDAO.delete(id);
    }
}
