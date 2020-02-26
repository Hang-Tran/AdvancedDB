package com.company.Screens;

import com.company.Models.Session;
import com.company.Repositories.ProductRepository;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeScreen {
    private Scanner scanner;
    private Session session;
    private ProductRepository productRepository;
    private CartScreen cartScreen;
    private ProductScreen productScreen;
    private CategoryScreen categoryScreen;

    public WelcomeScreen(Scanner scanner, Session session, ProductRepository productRepository, CartScreen cartScreen, ProductScreen productScreen, CategoryScreen categoryScreen) {
        this.scanner = scanner;
        this.session = session;
        this.productRepository = productRepository;
        this.cartScreen = cartScreen;
        this.productScreen = productScreen;
        this.categoryScreen = categoryScreen;
    }

    public void select() throws IOException, ClassNotFoundException {
        System.out.println("\nPlease choose operation:");
        System.out.println();
        System.out.println("1: View all our products");
        System.out.println("2: Browse by category");
        if (session.getCart().getProducts().size() > 0) {
            System.out.println("3: Edit your cart");
            System.out.println("4: Checkout");
            System.out.println("5: View your cart");
        }
        System.out.println("0: Exit");

        var selection = scanner.nextLine();

        handleSelection(selection);
    }

    private void handleSelection(String selection) throws IOException, ClassNotFoundException {
        switch(selection) {
            case "1":
                productScreen.selectAndAddToCart(productRepository.all());
                select();
                break;
            case "2":
                var category = categoryScreen.select(productRepository.allCategories());
                productScreen.selectAndAddToCart(productRepository.byCategory(category));
                select();
                break;
            case "3":
                cartScreen.removeProduct();
                select();
                break;
            case "4":
                cartScreen.show();
                System.out.println("\nThanks for shopping with us!\nYour products will now be sent to you!\n");

                break;
            case "5":
                cartScreen.show();
                select();
                break;
            case "0":
                exit();
                break;
            default:
                System.out.println("Invalid choice. Try again!");
                select();
        }
    }

    private void exit() {
        System.out.println("Goodbye ;-)!");
    }
}
