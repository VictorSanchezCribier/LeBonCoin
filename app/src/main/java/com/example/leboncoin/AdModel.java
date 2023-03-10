package com.example.leboncoin;

import java.io.Serializable;

public class AdModel implements Serializable {
    private String title;
    private String address;
    private int image;

    private String prix;
    // Constructor
    public AdModel(String title, String address, int image, String prix) {
        this.title = title;
        this.address = address;
        this.image = image;
        this.prix = prix;
    }
    // Getter and Setter
    public String getPrix(){
        return prix;
    }
    public void setPrix(String prix){
        this.prix = prix;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

