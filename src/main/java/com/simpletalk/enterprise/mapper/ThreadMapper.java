package com.simpletalk.enterprise.mapper;

import com.simpletalk.enterprise.dto.ThreadDTO;
import com.simpletalk.enterprise.model.Post;
import com.simpletalk.enterprise.model.Thread;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThreadMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(thread.getPosts()))")
    ThreadDTO mapThreadToDto(Thread thread);

    default Integer mapPosts(List<Post> numberOfPosts) {

        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Thread mapDtoToThread(ThreadDTO threadDTO);
}
