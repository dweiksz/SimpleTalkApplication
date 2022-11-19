package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.PostRequest;
import com.simpletalk.enterprise.dto.PostResponse;
import com.simpletalk.enterprise.exceptions.PostNotFoundException;
import com.simpletalk.enterprise.exceptions.ThreadNotFoundException;
import com.simpletalk.enterprise.mapper.PostMapper;
import com.simpletalk.enterprise.model.Post;
import com.simpletalk.enterprise.model.User;
import com.simpletalk.enterprise.model.Thread;
import com.simpletalk.enterprise.repository.PostRepository;
import com.simpletalk.enterprise.repository.ThreadRepository;
import com.simpletalk.enterprise.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final ThreadRepository threadRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        Thread thread = threadRepository.findByName(postRequest.getThreadName())
                .orElseThrow(() -> new ThreadNotFoundException(postRequest.getThreadName()));
        postRepository.save(postMapper.map(postRequest, thread));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByThread(Long threadId) {
        Thread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new ThreadNotFoundException(threadId.toString()));
        List<Post> posts = postRepository.findAllByThread(thread);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
