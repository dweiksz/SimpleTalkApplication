package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.Post;

import java.util.List;

public interface IPostService {
    /**
     * Fetch a post with a given ID.
     * @param id is a unique identifier for a post.
     * @return the matching post, or null if no matches are found.
     */
    Post fetchById(int id) ;

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
    List<Post> fetchAll() throws Exception;

    void delete(int id) throws  Exception;

    /**
     * Fetch a post with a given ID.
     * @param id is a unique identifier for a thread.
     * @return the matching thread, or null if no matches are found.
     */
    Thread threadfetchById(int id) ;

    /**
     * Save a new Thread
     *
     * @param thread the entry to save.
     * @return
     */
    Thread threadsave(Thread thread) throws Exception;

    /**
     * Return all threads.
     * @return a collection of all posts.
     */
    List<Thread> threadfetchAll() throws Exception;

    void threaddelete(int id) throws  Exception;
}
