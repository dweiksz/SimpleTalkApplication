package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dao.IPostDAO;
import com.simpletalk.enterprise.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *     public class that implements methods from the IPostService interface and sends them to the DAO package
 * </p>
 */
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
        Post post = new Post();
        post.setMessage("I love Lord of the Rings!");
        post.setPostID(10);
        post.setUserID(100);
        return post;
    }
    /**
     * Save a new Post
     *
     * @param post to save.
     * @return
     */
    @Override
    public Post save(Post post) {
        return postDAO.save(post);
    }

    /**
     * Return all Posts
     * @return a collection of all posts.
     */
    @Override
    public List<Post> fetchAll() {
        return postDAO.fetchAll();
    }
}
