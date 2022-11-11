package com.simpletalk.enterprise.repository;

import com.simpletalk.enterprise.model.Post;
import com.simpletalk.enterprise.model.User;
import com.simpletalk.enterprise.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByThread(Thread thread);

    List<Post> findByUser(User user);
}
