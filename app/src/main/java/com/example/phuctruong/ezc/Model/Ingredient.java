package com.example.phuctruong.ezc.Model;

/**
 * Created by Phuc Truong on 10/16/2015.
 */
public class Ingredient {
    private String Name;
    private String Picture;
    private String Price;
    private String Unit;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Ingredient(String name, String picture, String price, String unit) {
        Name = name;
        Picture = picture;
        Price = price;
        Unit = unit;
    }

    public Ingredient() {
        Name = "";
        Picture = "";
        Price = "";
        Unit = "";
    }
}
