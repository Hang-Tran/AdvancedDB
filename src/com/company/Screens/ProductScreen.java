package com.company.Screens;

import com.company.Models.Product;
import com.company.Models.Session;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductScreen {
    private final Scanner scanner;
    private Session session;

    public ProductScreen(Scanner scanner, Session session) {

        this.scanner = scanner;
        this.session = session;
    }

    public void list(List<Product> products) {
        products.sort(Comparator.comparing(Product::getPrice));
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + " - " + products.get(i).getName() + " || Category: " + products.get(i).getCategory() + " || Price: " + products.get(i).getPrice());
        }
    }

    public Product select(List<Product> products) {
        System.out.println();
        list(products);
        var line = scanner.nextLine();
        var index = Integer.parseInt(line);
        return products.get(index);
    }

    public void selectAndAddToCart(List<Product> products) {
        System.out.println("#############################################");
        System.out.println("Please make a selection to add to your cart:");
        System.out.println("#############################################");


        var product = select(products);

        session.getCart().getProducts().add(product);
        System.out.println("New total: " + session.getCart().getTotal());
    }
}
