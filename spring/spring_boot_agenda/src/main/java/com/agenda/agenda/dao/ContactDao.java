package com.agenda.agenda.dao;

import com.agenda.agenda.entity.Contact;
import java.util.List;

public interface ContactDao {

    void createContact(Contact contact);

    Contact findContactById(Long id);

    List<Contact> findAllContacts();

    void updateContact(Contact contact);

    void deleteContact(Long id);
}
