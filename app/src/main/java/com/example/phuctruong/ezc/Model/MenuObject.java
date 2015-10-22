package com.example.phuctruong.ezc.Model;

/**
 * Created by Phuc Truong on 10/16/2015.
 */
public class MenuObject {

    private String Name, Price;
    private int QtyAttendance,QtyRecipe;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getQtyAttendance() {
        return QtyAttendance;
    }

    public void setQtyAttendance(int qtyAttendance) {
        QtyAttendance = qtyAttendance;
    }

    public int getQtyRecipe() {
        return QtyRecipe;
    }

    public void setQtyRecipe(int qtyRecipe) {
        QtyRecipe = qtyRecipe;
    }


    public MenuObject(String name, String price, int qtyAttendance, int qtyRecipe) {
        Name = name;
        Price = price;
        QtyAttendance = qtyAttendance;
        QtyRecipe = qtyRecipe;
    }


}
