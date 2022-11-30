package com.simpletalk.enterprise.mapper;


import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.simpletalk.enterprise.dto.PostRequest;
import com.simpletalk.enterprise.dto.PostResponse;
import com.simpletalk.enterprise.model.Post;
import com.simpletalk.enterprise.model.Thread;
import com.simpletalk.enterprise.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper {


    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "thread", source = "thread")
    //@Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, Thread thread);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "threadName", source = "thread.name")
    //@Mapping(target = "userName", source = "user.username")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    public abstract PostResponse mapToDto(Post post);

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }

}