package com.social.graphqlsdl.resolver.post;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.social.graphqlsdl.service.PostService;
import com.social.graphqlsdl.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PostService postService;

    public UUID createPost(Post post) {

        return postService.createPost(post);

    }
}
