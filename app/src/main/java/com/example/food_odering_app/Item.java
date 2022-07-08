package com.example.food_odering_app;

public class Item {
    private String name;
    private int image;
    private  String description;
    private int price;

    public Item(String name, int image, String description,int price) {
        this.name = name;
        this.image = image;
        this.description  = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
