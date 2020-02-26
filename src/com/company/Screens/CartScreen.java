package com.company.Screens;

import com.company.Models.Session;

public class CartScreen {
    private Session session;
    private ProductScreen productScreen;

    public CartScreen(Session session, ProductScreen productScreen) {
        this.session = session;
        this.productScreen = productScreen;
    }

    public void removeProduct() {
        var cart = session.getCart();
        System.out.println("#######################################################");
        System.out.println("Enter the product you like to remove from your cart:");
        System.out.println("#######################################################");
        var product = productScreen.select(cart.getProducts());
        cart.getProducts().remove(product);
    }

    public void show() {
        var cart = session.getCart();
        productScreen.list(cart.getProducts());
        System.out.println("Total: " + cart.getTotal());
    }
}
