package com.social.graphqlsdl.resolver.author;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.social.graphqlsdl.repository.PostRepository;
import com.social.graphqlsdl.service.PostService;
import com.social.graphqlsdl.vo.Author;
import com.social.graphqlsdl.vo.Comment;
import com.social.graphqlsdl.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
//Resolver for Post field inside Author
public class AuthorFieldResolver implements GraphQLResolver<Author> {

    @Autowired
    private PostService postService;

    public List<Post> posts(Author author) {

        return postService.getAllPostByAuthorId(author.getId());


    }

    public Integer postCount(Author author) {
        return postService.getPostCount(author.getId());
    }

   public Comment getComments(Author author) {
        return Comment.builder().id(UUID.randomUUID()).text("Test Comment").build();
    }
}
