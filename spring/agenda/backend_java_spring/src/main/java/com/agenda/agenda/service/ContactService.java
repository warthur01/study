package com.agenda.agenda.service;

import com.agenda.agenda.dao.ContactDao;
import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.validation.InvalidEmailException;
import com.agenda.agenda.validation.InvalidNumberException;
import com.agenda.agenda.validation.Validator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    private final ContactDao contactDao;

    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void create(Contact contact) throws InvalidEmailException, InvalidNumberException {
        Validator.emailValidator(contact.getEmail());
        Validator.phoneValidator(contact.getNumber());
        contactDao.createContact(contact);
    }

    public List<Contact> listAll() {
        return contactDao.findAllContacts();
    }

    public Contact findById(Long id) {
        return contactDao.findContactById(id);
    }

    public void delete(Long id) {
        contactDao.deleteContact(id);
    }

    public void update(Contact contact) throws InvalidEmailException, InvalidNumberException {
        Validator.emailValidator(contact.getEmail());
        Validator.phoneValidator(contact.getNumber());
        contactDao.updateContact(contact);
    }
}
