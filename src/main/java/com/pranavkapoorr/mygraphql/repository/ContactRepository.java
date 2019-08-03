package com.pranavkapoorr.mygraphql.repository;

import com.pranavkapoorr.mygraphql.models.Contact;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ContactRepository {

    private Map<String, Contact> contacts;

    public ContactRepository() {
       this.contacts = new HashMap<>();
       contacts.put("1",new Contact("1","Pranav","London"));
       contacts.put("2",new Contact("2","Albert","Italy"));
       contacts.put("3",new Contact("3","Paul","Ireland"));
       contacts.put("4",new Contact("4","Trump","US"));
       contacts.put("5",new Contact("5","Modi","India"));
    }

    public List<Contact> getContacts() {
        return contacts.values().stream().collect(Collectors.toList());
    }
    
    public Map<String,Contact> getContactsDb(){
    	return contacts;
    }
  
   
}