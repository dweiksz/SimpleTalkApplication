package com.simpletalk.enterprise.dto;
import lombok.Data;

public @Data
class Thread {
    private int postID;
    private int threadID;
    private String threadName;
    private String threadDescription;
    private int numberOfPosts;
}
