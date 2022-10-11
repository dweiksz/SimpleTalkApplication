package com.simpletalk.enterprise.dao;

import com.simpletalk.enterprise.dto.Post;

import java.util.List;

public interface IPostDAO {
    Post save(Post post);

    List<Post> fetchAll();
}
