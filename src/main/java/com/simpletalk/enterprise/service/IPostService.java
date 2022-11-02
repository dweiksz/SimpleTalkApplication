package com.simpletalk.enterprise.service;
import com.simpletalk.enterprise.dto.Thread;
import com.simpletalk.enterprise.dto.User;
import com.simpletalk.enterprise.dto.Post;
import java.io.IOException;

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
    Thread threadFetchById(int id) ;

    /**
     * Save a new Thread
     *
     * @param thread the entry to save.
     * @return
     */
    Thread threadSave(Thread thread) throws Exception;

    /**
     * Return all threads.
     * @return a collection of all posts.
     */
    List<Thread> threadFetchAll() throws Exception;

    void threadDelete(int id) throws  Exception;
}