package com.social.graphqlsdl.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.social.graphqlsdl.service.AuthorService;
import com.social.graphqlsdl.vo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private AuthorService authorService;

    public UUID createAuthor(Author author) {

            return authorService.createAuthor(author);

    }
}
