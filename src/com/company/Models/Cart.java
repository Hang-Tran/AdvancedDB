package com.company.Models;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }



    public double getTotal() {
        double result = 0;

        for (var product: products)  {
            result += product.getPrice();
        }

        return result;
    }
}
