package com.simpletalk.enterprise;

import com.simpletalk.enterprise.dao.IPostDAO;
import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.service.IPostService;
import com.simpletalk.enterprise.service.PostServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleTalkApplicationTests {

    @Autowired
    private IPostService postService;
    private Post post = new Post();

    @MockBean
    private IPostDAO postDAO;

    @Test
    void contextLoads() {
    }
    @Test
    void fetchPostByID_returnsLOTRpostforID10(){
        givenPostDataAreAvailable(); 
        whenSearchPostWithID10();
        thenReturnOneLOTRPostForID10();
    }

    private void givenPostDataAreAvailable() {
        Mockito.when(postDAO.save(post)).thenReturn(post);
        postService = new PostServiceStub(postDAO);
    }

    private void whenSearchPostWithID10() {
        post = postService.fetchById(10);
    }

    private void thenReturnOneLOTRPostForID10() {
        String message = post.getMessage();
        assertEquals("I love Lord of the Rings!", message);

    }

    /**
     * Validate that the DTO properties can be set and retrieved.
     */
    @Test
    void savePost_ValidateReturnPostWithUserID() {
        givenPostDataAreAvailable();
        whenUserCreatesANewPostAndSaves();
        thenCreateNewPostAndReturnIt();
    }

    private void whenUserCreatesANewPostAndSaves() {
        post.setUserID(100);
    }
    private void thenCreateNewPostAndReturnIt() {
        Post createPost = postService.save(post);
        assertEquals(post, createPost);
    }



}
