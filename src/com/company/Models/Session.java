package com.company.Models;

public class Session {

    private Customer customer;
    private Cart cart;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        cart = new Cart();
    }
    public Cart getCart() {
        return cart;
    }
}
