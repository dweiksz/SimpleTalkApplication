package com.simpletalk.enterprise.dto;

import lombok.Data;

public @Data
class Post {
    private int postID;
    private String userID;
    private String userName;
    private String message;
}
