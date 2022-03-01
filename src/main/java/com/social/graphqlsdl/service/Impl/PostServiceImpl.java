package com.social.graphqlsdl.service.Impl;

import com.social.graphqlsdl.model.Author;
import com.social.graphqlsdl.repository.AuthorRepository;
import com.social.graphqlsdl.repository.PostRepository;
import com.social.graphqlsdl.service.PostService;
import com.social.graphqlsdl.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Post> getAllPostByAuthorId(UUID authorId) {
        List<com.social.graphqlsdl.model.Post> postList = postRepository.findAllByAuthor_Id(authorId);
        return postList.stream().map(post -> {
            return Post.builder().category(post.getCategory()).id(post.getId()).authorId(authorId).title(post.getTitle()).description(post.getDescription()).build();
        }).collect(Collectors.toList());
    }

    @Override
    public UUID createPost(Post post) {

        Optional<Author> author = authorRepository.findById(post.getAuthorId());

        return postRepository.saveAndFlush(com.social.graphqlsdl.model.Post.builder()
                .category(post.getCategory()).author(author.get()).description(post.getDescription()).title(post.getTitle()).build()).getId();
    }
}
