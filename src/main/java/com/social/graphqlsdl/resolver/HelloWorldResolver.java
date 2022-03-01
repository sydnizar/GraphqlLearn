package com.social.graphqlsdl.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.social.graphqlsdl.vo.Message;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class HelloWorldResolver implements GraphQLQueryResolver {
    //method name same as the query
    public String helloWorld() {
        return  "Hello world qraphql";
    }

    //method name can be appended with "get"
    public String getEmployee() {
        return "from Employee";
    }

    public String getGreetingMessage(String firstName, String lastName) {
        return String.format("Hello %s-%s",firstName,lastName);
    }

    public Message getMessage() {

        return  Message.builder().id(UUID.randomUUID()).text("graphql with object type").build();

    }

    public List<Integer> getRollDice() {

        return Arrays.asList(2,5,3,7);
    }
}
