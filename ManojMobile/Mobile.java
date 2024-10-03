package com.ManojMobile;

public class Mobile {
    private String id;
    private String name;
    private String brand;
    private float price;

    public Mobile(String id, String name, String brand, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile ID=" + id + ", Name=" + name + ", Brand=" + brand + ", Price=" + price;
    }
}