package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.Post;

public interface IPostService {
    /**
     * Fetch a postr with a given ID.
     * @param id is a unique identifier for a post.
     * @return the matching post, or null if no matches are found.
     */
    Post fetchById(int id);

    void save(Post post);
}
