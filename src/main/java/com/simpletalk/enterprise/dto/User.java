package com.simpletalk.enterprise.dto;
import lombok.Data;

public @Data
class User {
    private int userID;
    private int postID;
    private String userName;
    private int numberOfPosts;
}
