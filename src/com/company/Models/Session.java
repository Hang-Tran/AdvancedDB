package com.company.Models;

public class Session {

    private Customer customer;
    private Cart cart = new Cart();

    public Session(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }
}
