package com.agenda.agenda.dao;

import com.agenda.agenda.entity.Contact;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContactDaoImp implements ContactDao {

    private final EntityManager entityManager;

    @Autowired
    public ContactDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createContact(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public Contact findContactById(Long id) {
        return entityManager.find(Contact.class, id);
    }

    @Override
    public List<Contact> findAllContacts() {
        return this.entityManager.createQuery("FROM Contact", Contact.class).getResultList();

    }

    @Override
    @Transactional
    public void updateContact(Contact contact) {
        entityManager.merge(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Long id) {
        Contact contact = entityManager.find(Contact.class, id);
        if (contact != null) {
            entityManager.remove(contact);
        }
    }
}
