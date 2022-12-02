package com.simpletalk.enterprise.model.repo;

import com.simpletalk.enterprise.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

}
