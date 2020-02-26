package com.company.Screens;

import com.company.IdGenerator;
import com.company.Models.Customer;
import com.company.Repositories.CustomerRepository;

import java.io.IOException;
import java.util.Scanner;

public class SignupScreen {
    private Scanner scanner;
    private CustomerRepository customerRepository;

    public SignupScreen(Scanner scanner, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
    }

    public Customer signup() throws NoSuchFieldException, IOException {
        String name = "";
        String address = "";
        String mail = "";
        String tel = "";

        do {
            System.out.println("Your name:");
            name = scanner.nextLine();
        } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("name"), name));

        do {
            System.out.println("Your address:");
            address = scanner.nextLine();
        } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("address"), address));

        do {
            System.out.println("Your mail: ");
            mail = scanner.nextLine();
        } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("mail"), mail));

        do {
            System.out.println("Your telephone number:");
            tel = scanner.nextLine();
        } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("tel"), tel));

        var customer = new Customer(name, address, mail, tel);

        customerRepository.add(customer);

        System.out.println("Registration complete!\nYour Log-in id is: " + customer.getId());
        return customer;

    }
}
