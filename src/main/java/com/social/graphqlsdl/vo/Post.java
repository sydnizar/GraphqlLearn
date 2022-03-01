package com.social.graphqlsdl.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {



    private UUID authorId;
    private String title;
    private String description;
    private String category;
    private UUID id;



}
