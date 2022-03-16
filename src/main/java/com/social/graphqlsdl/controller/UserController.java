package com.social.graphqlsdl.controller;

import com.social.graphqlsdl.vo.Author;
import com.social.graphqlsdl.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping(value = "users")
public class UserController {

    //QueryString
    @GetMapping(value = "/users")
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit", required = false, defaultValue = "50") int limit) {
        return "getUsers Page: "+page+" limit: "+limit;
    }

    //path variable
    @GetMapping(path = "/users/{userId}")
    public String testGetMapping(@PathVariable String userId) {
        return "get mapping called123"+userId;
    }

    @GetMapping(value = "/userObj", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Author> getAuthor() {
        return new ResponseEntity<Author>(Author.builder().id(UUID.randomUUID()).email("test_email").build(), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Author> testPostMapping(@RequestBody User user) {
        return new ResponseEntity<Author>(Author.builder().id(UUID.randomUUID()).email(user.getEmail()).name(user.getName()).build(), HttpStatus.OK);
    }

    @PutMapping
    public String testPutMapping() {
        return "put mapping called";

    }

    @DeleteMapping
    public String testDeleteMapping() {
        return "delete mapping called";
    }
}
