package com.social.graphqlsdl.repository;

import com.social.graphqlsdl.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    public List<Post> findAllByAuthor_Id(UUID id);
}
