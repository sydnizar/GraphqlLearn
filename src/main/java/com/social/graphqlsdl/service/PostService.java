package com.social.graphqlsdl.service;

import com.social.graphqlsdl.vo.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPostByAuthorId(UUID authorId);

    UUID createPost(Post post);

    Integer getPostCount(UUID id);
}
