package com.example.androidjava.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String description;
    private String picUrl;

    public PopularDomain(String title, String description, String picUrl, int veview, double score,  double price) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.veview = veview;
        this.score = score;

        this.price = price;
    }

    private int veview;
    private double score;
    private int numberrinCart;
    private double price;

    @Override
    public String toString() {
        return "PopularDomain{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", veview=" + veview +
                ", score=" + score +
                ", numberrinCart=" + numberrinCart +
                '}';
    }






    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getVeview() {
        return veview;
    }

    public void setVeview(int veview) {
        this.veview = veview;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberrinCart() {
        return numberrinCart;
    }

    public void setNumberrinCart(int numberrinCart) {
        this.numberrinCart = numberrinCart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
