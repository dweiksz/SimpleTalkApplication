package com.simpletalk.enterprise.dao;

import com.simpletalk.enterprise.dto.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     public class that implements methods from the IPostDAO interface
 * </p>
 */
@Repository
public class PostDAOStub implements IPostDAO {
    Map<Integer, Post> allPosts = new HashMap<>();

    /**
     * @param post
     * @return
     */
    @Override
    public Post save(Post post) throws Exception{
        Integer postID = (post.getPostID());
        allPosts.put(postID, post);
        return post;
    }

    /**
     * @return
     */
    @Override
    public List<Post> fetchAll() {
        List<Post> returnPosts = new ArrayList<>(allPosts.values());
        return returnPosts;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Post fetch(int id) {
        return allPosts.get(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Post delete(int id) {
        return allPosts.remove(id);
    }
}

