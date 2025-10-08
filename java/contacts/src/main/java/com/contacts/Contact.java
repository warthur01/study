package com.contacts;

public class Contact {
    private String name;
    private String number;
    private String email;
    private int id;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String toCSV() {
        return   name + "," + number + "," + email;
    }
    public static Contact fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            return null;
        }
        Contact c = new Contact();
        c.setName(parts[0]);
        c.setNumber(parts[1]);
        c.setEmail(parts[2]);
        return c;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", id=" + id +
                '}';
    }
}

