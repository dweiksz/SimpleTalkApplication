package com.simpletalk.enterprise.dao;

import com.simpletalk.enterprise.dto.Post;

import java.util.List;

public interface IPostDAO {
    Post save(Post post) throws Exception;

    List<Post> fetchAll();

    Post fetchByID(int id) ;

    void delete(int id) throws Exception;
}
