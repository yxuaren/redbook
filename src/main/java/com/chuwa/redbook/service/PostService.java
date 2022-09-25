package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    /*List<PostDto> getAllPost();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);*/
}
