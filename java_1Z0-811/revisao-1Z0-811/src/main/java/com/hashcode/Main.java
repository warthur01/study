package com.hashcode;

public class Main {
    public static void main(String[] args) {
User user1 = new  User("arthur", "santos");
User user2 = new User("arthur", "santos");
        System.out.println(user1);
        System.out.println(user1.hashCode());
        System.out.println(user2);
        System.out.println(user2.hashCode());
        System.out.println(user1.equals(user2));
    }
}
