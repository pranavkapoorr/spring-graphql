package com.pranavkapoorr.mygraphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.pranavkapoorr.mygraphql.service.GraphQLProvider;

import graphql.ExecutionResult;

@SpringBootApplication
public class SpringGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlApplication.class, args);
	}
}

@RestController
class controller {
	@Autowired
	GraphQLProvider service;
	
	@PostMapping("/mygraphql")
    public ResponseEntity<Object> graphQLEndpoint(@RequestBody String query) {
        ExecutionResult execute = service.graphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}