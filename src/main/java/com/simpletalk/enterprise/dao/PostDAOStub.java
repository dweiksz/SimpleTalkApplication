package com.simpletalk.enterprise.dao;

import com.simpletalk.enterprise.dto.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 *     public class that implements methods from the IPostDAO interface
 * </p>
 */
@Repository
public class PostDAOStub implements IPostDAO {
    List<Post> allPosts = new ArrayList<Post>();

    /**
     * @param post
     * @return
     */
    @Override
    public Post save(Post post) {
        allPosts.add(post);
        return post;
    }

    /**
     * @return
     */
    @Override
    public List<Post> fetchAll() {
        return allPosts;
    }
}

