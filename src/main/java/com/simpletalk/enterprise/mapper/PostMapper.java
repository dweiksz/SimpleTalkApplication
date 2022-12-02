package com.simpletalk.enterprise.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.simpletalk.enterprise.dto.PostRequest;
import com.simpletalk.enterprise.dto.PostResponse;
import com.simpletalk.enterprise.model.Post;
import com.simpletalk.enterprise.model.Thread;
import com.simpletalk.enterprise.model.User;
import com.simpletalk.enterprise.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper (componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "thread", source = "thread")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, Thread thread, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "threadName", source = "thread.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    public abstract PostResponse mapToDto(Post post);

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }
}