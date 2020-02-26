package com.company.Screens;

import com.company.Models.Customer;
import com.company.Repositories.CustomerRepository;

import java.io.IOException;
import java.util.Scanner;

public class LoginScreen {

    private Scanner scanner;
    private CustomerRepository customerRepository;

    public LoginScreen(Scanner scanner, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
    }

    public Customer login() throws IOException, ClassNotFoundException {
        System.out.println("What is your login id? ");
        var customerId = scanner.nextLine();

        var customer = customerRepository.get(customerId);

        System.out.println("Login successful!");
        return customer;
    }
}
