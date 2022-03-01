package com.social.graphqlsdl.resolver;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.social.graphqlsdl.FileReaderUtil;
import com.social.graphqlsdl.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = TestApplication.class)
class AuthorQueryResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void testGetAuthorData() throws IOException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/author-query.grpahqls");
        assertEquals(FileReaderUtil.read("response/author-query.json"), graphQLResponse.getRawResponse().getBody());
    }

}