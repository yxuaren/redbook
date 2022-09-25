package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        //change payload to entity ,so that dao can save data to database
        Post post = new Post();
        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        //already passed request body info to entity*/

        //convert DTO to Entity
        //Post post = mapToEntity(postDto);

        //call Dao save method to save entity info to MySQL database
        //save() would return data stored in database
        Post savePost = postRepository.save(post);

        //transfer data returned by save() to what controller/frontend needed, and return to controller
        PostDto postResponse = new PostDto();
        postResponse.setId(savePost.getId());
        postResponse.setTitle(savePost.getTitle());
        postResponse.setDescription(savePost.getDescription());
        postResponse.setContent(savePost.getContent());

        //PostDto postResponse = mapToDTO(savePost);

        return postResponse;
    }

}
