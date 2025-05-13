package com.contacts;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private final List<Contacts> contacts;

    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contacts c) {
        contacts.add(c);
    }

    public void removeContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    public List<Contacts> searchContact(String name) {
        List<Contacts> found = new ArrayList<>();
        for (Contacts c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                found.add(c);
            }
        }
        return found;
        // TODO: Implementar futuramente
        /*
        métodos para exportação e importação de arquivos de agenda
         */
    }

    public void listContacts() {
        for (Contacts c : contacts) {
            System.out.println(c);
        }
    }
}