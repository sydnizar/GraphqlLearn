package com.social.graphqlsdl.resolver.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.social.graphqlsdl.service.AuthorService;
import com.social.graphqlsdl.service.PostService;
import com.social.graphqlsdl.vo.Author;
import com.social.graphqlsdl.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
//Resolver for Author field inside Post
public class PostFieldResolver implements GraphQLResolver<Post> {

    @Autowired
    private PostService postService;

    @Autowired
    private AuthorService authorService;

    public Author getAuthor(Post post) {

        return authorService.getAuthorById(post.getAuthorId());
//        return (Author.builder()
//                .id(UUID.randomUUID())
//                .name("author name")
//                .email("author email")
//                .build());
    }
}
