package com.simpletalk.enterprise;

import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.service.IPostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleTalkApplicationTests {

    @Autowired
    private IPostService postService;
    private Post post;

    @Test
    void contextLoads() {
    }
    @Test
    void fetchPostByID_returnsLOTRPostForID10(){
        givenPostDataAreAvailable();
        whenPost10AddedIsILoveLOTR();
        whenSearchPostWithID10();
        thenReturnOneLOTRPostForID10();
    }


    private void givenPostDataAreAvailable() {
    }

    private void whenPost10AddedIsILoveLOTR() {
        Post LOTR = new Post();
        LOTR.setPostID(10);
        LOTR.setMessage("I love Lord of the Rings!");
        Mockito.when(postDAO.fetch(10)).thenReturn(postDAO)
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

}
