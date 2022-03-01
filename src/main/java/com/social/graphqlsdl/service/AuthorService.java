package com.social.graphqlsdl.service;

import com.social.graphqlsdl.vo.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(UUID authorId);

    UUID createAuthor(Author author);
}
