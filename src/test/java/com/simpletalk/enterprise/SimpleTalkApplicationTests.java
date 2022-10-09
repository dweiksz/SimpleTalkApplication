package com.simpletalk.enterprise;

import com.simpletalk.enterprise.dto.Post;
import com.simpletalk.enterprise.service.IPostService;
import org.junit.jupiter.api.Test;
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
    void fetchPostByID_returnsLOTRpostforID10(){
        givenPostDataAreAvailable(); 
        whenSearchPostWithID10();
        thenReturnOneLOTRPostForID10();
    }

    private void givenPostDataAreAvailable() {
    }

    private void whenSearchPostWithID10() {
        post = postService.fetchById(10);
    }

    private void thenReturnOneLOTRPostForID10() {
        String message = post.getMessage();
        assertEquals("I love Lord of the Rings!", message);
    }

}
