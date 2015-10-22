package com.example.phuctruong.ezc.Model;

/**
 * Created by Phuc Truong on 10/16/2015.
 */
public class Recipe{

    private String Name;
    private int PictureID;

    public Recipe(String name, int pictureID) {
        Name = name;
        PictureID =pictureID;
    }
    public Recipe() {
        Name = "";
        PictureID =0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPictureID() {
        return PictureID;
    }

    public void setPictureID(int PictureID) {
        PictureID = PictureID;
    }

}
