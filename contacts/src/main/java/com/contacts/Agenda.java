package com.contacts;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private final List<Contact> contacts;

    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void removeContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    public void removeContactById(int id) {
        contacts.removeIf(c -> c.getId() == id);
    }

    public Contact getContactById(int id) {
        for (Contact c : contacts) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Contact> searchContact(String name) {
        List<Contact> found = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                found.add(c);
            }
        }
        return found;

    }

    public void listContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}