package com.example.phuctruong.ezc.Model;

/**
 * Created by Phuc Truong on 10/16/2015.
 */
public class Category {

    private int Image;
    private String Name;
    private int Icon;

    public Category(String name, int image, int icon) {
        Image = image;
        Name = name;
        Icon = icon;
    }

    public Category(int image, String name) {
        Image = image;
        Name = name;
    }

    public Category(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
