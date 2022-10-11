package com.simpletalk.enterprise.dao;
import com.simpletalk.enterprise.dto.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PostDAOStub implements IPostDAO {
    Map<Integer, Post> allPosts = new HashMap<>();

    @Override
    public Post save(Post post) throws Exception {
      Integer postID = Integer.parseInt(post.getPostID());
      allPosts.put(postID, post);
      return post;
    }
    @Override
    public List<Post> fetchAll() {
      List<Post> returnPosts = new ArrayList(allPosts.values());
      return returnPosts;
    }

    @Override
    public Post fetch(int id) {
      return allPosts.get(id);
    }

    @Override
    public Post delete(int id) {
      return allPosts.remove(id);
    }
}
