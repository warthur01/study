package com.agenda.agenda.service;

import com.agenda.agenda.dao.ContactDao;
import com.agenda.agenda.entity.Contact;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    private final ContactDao contactDao;

    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<Contact> listAll() {
        return contactDao.findAllContacts();
    }

    public Contact findById(Long id) {
        return contactDao.findContactById(id);
    }

    public Contact create(Contact contact) {
        contactDao.createContact(contact);
        return contact;
    }

    public Contact update(Long id, Contact updated) {
        Contact existing = contactDao.findContactById(id);
        if (existing == null) {
            throw new RuntimeException("Contact not found!");
        }
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setNumber(updated.getNumber());
        contactDao.updateContact(existing);
        return existing;
    }

    public void delete(Long id) {
        contactDao.deleteContact(id);
    }
}
