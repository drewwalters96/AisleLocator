package com.example.myfirstapp.Models;
import java.util.List;

/**
 * Created by Adam on 10/15/2016.
 */

public class Aisle {

    private String category;
    private int aisleNumber;
    private List<Product> products;

    public String getCategory()
    {
        return category;
    }

    public int getAisleNumber()
    {
        return aisleNumber;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setCategory( String value )
    {
        this.category = value;
    }

    public void setAisleNumber( int value )
    {
        this.aisleNumber = value;
    }

    public void setProducts( List<Product> value )
    {
        this.products = value;
    }

}