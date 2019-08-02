package com.pranavkapoorr.mygraphql.resolvers;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pranavkapoorr.mygraphql.models.Contact;
import com.pranavkapoorr.mygraphql.ContactRepository;

@Component
public class AllContactsFetcher implements DataFetcher<List<Contact>>{

    @Autowired
    private ContactRepository repository;

    @Override
    public 	List<Contact> get(DataFetchingEnvironment environment) throws Exception {
        return (List<Contact>) repository.getContacts();
    }

}