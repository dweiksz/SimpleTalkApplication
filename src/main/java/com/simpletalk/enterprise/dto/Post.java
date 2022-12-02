package com.simpletalk.enterprise.dto;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postID;

    @Column
    private String postUser;

    @Column
    private String postBody;

    @Column
    private String color1;

    @Column
    private String color2;

    public long getID() {
        return postID;
    }

    public void setID(long postID) {
        this.postID = (int) postID;
    }

    public Integer getPostID() {

        return 1;
    }
}
