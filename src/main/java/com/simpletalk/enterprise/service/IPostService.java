package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.Post;

import java.util.List;

public interface IPostService {
    /**
     * Fetch a post with a given ID.
     * @param id is a unique identifier for a post.
     * @return the matching post, or null if no matches are found.
     */
    Post fetchById(int id) throws Exception;

    /**
     * Save a new Journal Entry
     *
     * @param post the entry to save.
     * @return
     */
    Post save(Post post) throws Exception;

    /**
     * Return all posts.
     * @return a collection of all posts.
     */
    List<Post> fetchAll();
}
