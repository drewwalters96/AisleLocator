/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myfirstapp;

import com.example.myfirstapp.Models.*;

import org.json.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author drew
 */
public class Consumer {

    private static final String BASE_URL = "http://api.walmartlabs.com/v1/";
    private static final String KEY = "de5rwdxfc9f3jbeqyvtnv2za";

    public static ArrayList<Product> search(String search) {

        ArrayList<Product> products = new ArrayList<>();

        String uri = "search?apiKey=" + KEY + "&query=" + search;
        String requestUrl = BASE_URL + uri;

        try {
            URL url = new URL(requestUrl); // Express as URL object.

            // Create http request.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // GET is default.

            if (connection.getResponseCode() == 200) {
                 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                 String jsonResponse = "", line;
                 while ((line = in.readLine()) != null) {
                     jsonResponse += line;
                 }
                 in.close();

                 // Receive API response as JSONObject.
                 JSONObject jsonObject = new JSONObject(jsonResponse);

                 // Extract array of search items.
                 JSONArray items = jsonObject.getJSONArray("items");

                 // Convert items in array to products and add to products array list.
                 for (int i = 0; i < items.length(); i++) {
                    Product product = createProduct(items.getJSONObject(i));
                    products.add(product);
                 }
            }
            else {
                System.out.println("Error " + connection.getResponseCode() + " reported during the request.");
            }
        }
        catch (Exception ex) {
            System.out.println(ex); // Log error
        }

        return products;
    }

    private static Product createProduct(JSONObject jsonProduct) {

        // Create Product and set properties.
        Product product = new Product();
        try {
            product.setItemID(jsonProduct.getString("upc"));
            product.setName(jsonProduct.getString("name"));
            product.setPrice(jsonProduct.getDouble("salePrice"));
            product.setCategory(jsonProduct.getString("categoryPath"));

            if (jsonProduct.getString("stock").equals("Available")) {
                product.setInStock(true);
            } else {
                product.setInStock(false);
            }

            product.setLink(jsonProduct.getString("productUrl"));
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

        return product;
    }
}
