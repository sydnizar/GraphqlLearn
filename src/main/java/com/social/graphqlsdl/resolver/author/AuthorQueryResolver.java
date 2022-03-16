package com.social.graphqlsdl.resolver.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.social.graphqlsdl.service.AuthorService;
import com.social.graphqlsdl.vo.Author;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver{

    @Autowired
    private AuthorService authorService;

    public List<Author> getAuthors() {

        return authorService.getAllAuthors();

//        return Collections.singletonList(Author.builder()
//                        .id(UUID.randomUUID())
//                        .name("author name")
//                        .email("author email")
//                        .build());
    }
}
