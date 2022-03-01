package com.social.graphqlsdl.service.Impl;

import com.social.graphqlsdl.repository.AuthorRepository;
import com.social.graphqlsdl.service.AuthorService;
import com.social.graphqlsdl.vo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        List<com.social.graphqlsdl.model.Author> authorList = authorRepository.findAll();

        return authorList.stream().map(author -> {
            return Author.builder().
                    id(author.getId())
                    .email(author.getEmail())
                    .name(author.getName())
                    .build();
        }).collect(Collectors.toList());


    }

    @Override
    public Author getAuthorById(UUID authorId) {

        com.social.graphqlsdl.model.Author author = authorRepository.findById(authorId).get();
        return Author.builder().id(author.getId()).name(author.getName()).email(author.getEmail()).build();
    }

    @Override
    public UUID createAuthor(Author author) {

        com.social.graphqlsdl.model.Author authorEntity = com.social.graphqlsdl.model.Author.builder().email(author.getEmail()).name(author.getName()).build();

        com.social.graphqlsdl.model.Author authorEntity1 = authorRepository.saveAndFlush(authorEntity);

        return authorEntity1.getId();
    }
}
