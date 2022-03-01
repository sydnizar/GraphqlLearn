package com.social.graphqlsdl.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private String title;
    private String description;
    private String category;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
}
