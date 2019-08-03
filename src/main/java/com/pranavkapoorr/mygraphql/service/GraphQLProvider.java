package com.pranavkapoorr.mygraphql.service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.pranavkapoorr.mygraphql.service.fetchers.*;
import javax.annotation.PostConstruct;
import java.io.*;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Service
public class GraphQLProvider {

    @Autowired
    private AllContactsFetcher allContactsFetcher;    
    @Autowired
    private ContactByIdFetcher contactByIdFetcher;
    @Value("classpath:contacts.graphql")
    Resource resource;
    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
    	File sdl = resource.getFile();
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(File sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("contact", contactByIdFetcher)
                        .dataFetcher("contacts", allContactsFetcher))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

}