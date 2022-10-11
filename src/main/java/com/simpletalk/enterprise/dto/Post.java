package com.simpletalk.enterprise.dto;

import lombok.Data;

public @Data
class Post {
    private int userID;
    private int postID;
    private String userName;
    private String message;
    private int likes;
}
