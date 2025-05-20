
package com.contacts;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
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

    public List<Contact> findByNumber(String number) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getNumber().equals(number)) {
                result.add(c);
            }
        }
        return result;
    }


    public List<Contact> findByEmail(String email) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Contact> findByName(String name) {
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

    public void saveToJson(String saveJson) {
        String defaultPath = "D:\\IdeaProjects\\study";
        String filename ="contacts.txt";
        try (Writer writer = new FileWriter(defaultPath + filename)) {
            Gson gson = new Gson();
            gson.toJson(contacts, writer);
            System.out.println("Contacts saved as JSON in: " + defaultPath + filename);
        } catch (IOException e) {
            System.out.println("Error saving to JSON: " + e.getMessage());
        }
    }

    public void loadFromJson(String loadJson) {
        String defaultPath = "D:\\IdeaProjects\\study";
        String filename ="contacts.txt";
        try (Reader reader = new FileReader(defaultPath + filename)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Contact>>() {
            }.getType();
            List<Contact> loadedContacts = gson.fromJson(reader, listType);
            contacts.clear();
            contacts.addAll(loadedContacts);
            System.out.println("Contacts loaded from JSON.");
        } catch (IOException e) {
            System.out.println("Error loading from JSON: " + e.getMessage());
        }
    }
}