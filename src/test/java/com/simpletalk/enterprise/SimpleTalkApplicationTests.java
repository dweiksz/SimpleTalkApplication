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
import static org.mockito.Mockito.verify;

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
    void fetchPostByID_returnsLOTRPostForID10() throws Exception {
        givenPostDataAreAvailable();
        whenPost10AddedIsILoveLOTR();
        whenSearchPostWithID10();
        thenReturnOneLOTRPostForID10();
    }


    private void givenPostDataAreAvailable() throws Exception{
        Mockito.when(postDAO.save(post)).thenReturn(post);
        postService = new PostServiceStub(postDAO);
    }

    private void whenPost10AddedIsILoveLOTR() {
        Post LOTR = new Post();
        LOTR.setPostID(10);
        LOTR.setMessage("I love Lord of the Rings!");
        try {
            Mockito.when(postDAO.fetchByID(10)).thenReturn((LOTR));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void whenSearchPostWithID10() {
        try {
            post = postService.fetchById(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void thenReturnOneLOTRPostForID10() {
        String message = post.getMessage();
        assertEquals("I love Lord of the Rings!", message);
    }

    @Test
    void savePost_validateReturnPostWithUserID() throws Exception  {
        givenPostDataAreAvailable();
        whenUserCreatesANewPostAndSaves();
        thenCrateNewPostRecordAndReturnIt();
    }

    private void whenUserCreatesANewPostAndSaves() {

        post.setUserID(100);
    }

    private void thenCrateNewPostRecordAndReturnIt() throws Exception  {
        Post createPost = postService.save(post);
        assertEquals(post, createPost);
    }
}
