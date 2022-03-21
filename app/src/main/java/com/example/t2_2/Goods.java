package com.example.t2_2;

import java.io.Serializable;

public class Goods implements Serializable {

    private int img;
    private String name;
    private double price;
    private String forn;

    public Goods(int img, String name, double price, String forn) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.forn = forn;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getForn() {
        return forn;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setForn(String forn) {
        this.forn = forn;
    }

    public Goods() {
    }
}
