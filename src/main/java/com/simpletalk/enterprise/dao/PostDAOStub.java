package com.simpletalk.enterprise.dao;

import com.simpletalk.enterprise.dto.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostDAOStub implements IPostDAO {
    Map<Integer, Post> allPosts = new HashMap<>();

    @Override
    public Post save(Post post) throws Exception{
        Integer postID = (post.getPostID());
        allPosts.put(postID, post);
        return post;
    }

    @Override
    public List<Post> fetchAll() {
        List<Post> returnPosts = new ArrayList<>(allPosts.values());
        return returnPosts;
    }

    @Override
    public Post fetchByID(int id) {
        return allPosts.get(id);
    }

    @Override
    public void delete(int id) {
        allPosts.remove(id);
    }
}

