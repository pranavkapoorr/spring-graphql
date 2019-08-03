package com.pranavkapoorr.mygraphql.service.fetchers;

import graphql.schema.*;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pranavkapoorr.mygraphql.models.Contact;

@Component
public class AllContactsFetcher implements DataFetcher<List<Contact>>{

    @Autowired
    private com.pranavkapoorr.mygraphql.repository.ContactRepository repository;

    @Override
    public 	List<Contact> get(DataFetchingEnvironment environment) throws Exception {
        return (List<Contact>) repository.getContacts();
    }

}