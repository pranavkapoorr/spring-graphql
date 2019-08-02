package com.pranavkapoorr.mygraphql.resolvers;

import com.pranavkapoorr.mygraphql.ContactRepository;
import com.pranavkapoorr.mygraphql.models.Contact;
import graphql.schema.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactByIdFetcher implements DataFetcher<Contact> {

    @Autowired
    ContactRepository repository;
    
	@Override
	public Contact get(DataFetchingEnvironment environment) throws Exception {
	        return repository.getContactsDb().get(environment.getArgument("id"));
	    }

}