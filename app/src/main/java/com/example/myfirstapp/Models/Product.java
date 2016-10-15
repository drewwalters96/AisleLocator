package com.example.myfirstapp.Models;

/**
 * Created by Adam on 10/15/2016.
 */

public class Product {

    private String itemID;
    private String name;
    private double price;
    private Boolean inStock;
    private int numInStock;
    private String link;
    private String category;

    public String getItemID()
    {
        return this.itemID;
    }

    public String getName()
    {
        return  this.name;
    }

    public double getPrice() {
        return price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public String getLink() {
        return link;
    }

    public String getCategory() {
        return category;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }
}
