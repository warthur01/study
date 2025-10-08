package com.poo;

public class Car {
       private String model;
       private int year;
       private String brand;

    public Car() {
    }

    public Car(String model, int year, String brand) {
        this.model = model;
        this.year = year;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
