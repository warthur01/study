package com.gamerent;

public class Client {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final String email;

    public Client(String name, String email) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return   name + " (" + email + ")";
    }
}
