package com.company;

import com.company.Forms.SignupForm;
import com.company.Models.Cart;
import com.company.Models.Customer;
import com.company.Models.Product;
import com.company.Models.Session;
import com.company.Repositories.CustomerRepository;
import com.company.Repositories.ProductRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    private Session session;
    boolean running = true;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;


    public Menu() {
        var idGenerator = new IdGenerator();
        customerRepository = new CustomerRepository(idGenerator);
        productRepository = new ProductRepository(idGenerator);
    }

    public void startMenu() throws IOException, ClassNotFoundException {

        System.out.println("###########################");
        System.out.println("Welcome to our Webshop!");
        System.out.println("1: Login.");
        System.out.println("2: Sign up as new customer.");
        System.out.println("3: Leave.");
        System.out.println("###########################");

        String choice = scan.nextLine();

        switch (choice) {
            case "1":
                loginMenu();
                running = false;
                break;
            case "2":
                try {
                    var customer = addCustomer();
                    session = new Session(customer);
                } catch (IOException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
                webshopMenu();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again!");
                startMenu();
                break;
        }
    }

    public void loginMenu() {
        System.out.println("What is your login id? ");
        String loginId = scan.nextLine();
        try {
            var customer = customerRepository.get(loginId);
            session = new Session(customer);
            webshopMenu();
            System.out.println("Login successful!");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void webshopMenu() throws IOException, ClassNotFoundException {
        System.out.println("Welcome " + session.getCustomer().getId() + "\nPlease choose operation:");
        System.out.println();
        String number = "0";
        do {
            System.out.println("1: View all our products");
            System.out.println("2: Browse by category");
            if (this.session.getCart().getProducts().size() > 0) {
                System.out.println("3: Edit your cart");
                System.out.println("4: Checkout");
                System.out.println("5: View your cart");
            }
            System.out.println("0: Exit");

            try {
                number = scan.nextLine();
            } catch (InputMismatchException e) {
                startMenu();
            }
            switch (number) {
                case "1": {
                    listAllProducts(productRepository.all());
                    break;
                }
                case "2": {
                    var categories = productRepository.allCategories();
                    for (int i = 0; i < categories.size(); i++) {
                        System.out.println(i + " - " + categories.get(i));
                    }
                    System.out.println("Type category number:");
                    String selection = scan.nextLine();
                    var i = Integer.parseInt(selection);
                    listAllProducts(productRepository.byCategory(categories.get(i)));
                    break;
                }
                case "3": {
                    var products = session.getCart().getProducts();

                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(i + " - " + products.get(i).getName());
                    }
                    System.out.println("Type the number to delete:");
                    String id = scan.nextLine();
                    if (id != "") {
                        var i = Integer.parseInt(id);
                        products.remove(i);
                    }
                    break;
                }
                case "5": {
                    for (var product : session.getCart().getProducts()) {
                        System.out.println(product.getName());
                    }
                    System.out.println("Total: " + session.getCart().getTotal());

                    break;
                }
                case "0":
                    running = false;
                    break;
                default:
            }
        } while (running);
    }
    public void listAllProducts(List<Product> products) throws IOException, ClassNotFoundException {

        products.sort(Comparator.comparing(Product::getPrice));
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + " - " + products.get(i).getName()+ " || Category: " + products.get(i).getCategory() + " || Price: " + products.get(i).getPrice());
        }
        System.out.println();
        System.out.println("Enter number to add to cart");
        var line = scan.nextLine();
        var index = Integer.parseInt(line);
        var product = products.get(index);
        session.getCart().getProducts().add(product);
        System.out.println("New total: " + session.getCart().getTotal());
    }

    public Customer addCustomer() throws IOException, NoSuchFieldException {
        var customer = SignupForm.Read();
        customerRepository.add(customer);
        System.out.println("Registration complete!\nYour Log-in id is: " + customer.getId());

        return customer;
    }
}




