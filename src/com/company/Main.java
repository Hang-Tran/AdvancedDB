package com.company;

import com.company.Models.Product;
import com.company.Models.Session;
import com.company.Repositories.CustomerRepository;
import com.company.Repositories.ProductRepository;
import com.company.Screens.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException {
        /*var productRepository = new ProductRepository(new IdGenerator());
        var product = new Product();
        product.setName("LG 75Um7110Plb 75 Ultra HD 4k TV");
        product.setCategory("TV");
        product.setPrice(9990);
        product.setStock(15);
        productRepository.add(product);*/

        var scanner = new Scanner(System.in);
        var idGenerator = new IdGenerator();
        var session = new Session();
        var customerRepository = new CustomerRepository(idGenerator);
        var productRepository = new ProductRepository(idGenerator);
        var loginScreen = new LoginScreen(scanner, customerRepository);
        var signupScreen = new SignupScreen(scanner, customerRepository);
        var productScreen = new ProductScreen(scanner, session);
        var categoryScreen = new CategoryScreen(scanner);
        var cartScreen = new CartScreen(session, productScreen);
        var welcomeScreen = new WelcomeScreen(scanner, session, productRepository, cartScreen, productScreen, categoryScreen);
        var startScreen = new StartScreen(scanner, session, loginScreen, signupScreen, welcomeScreen);
        startScreen.select();
    }
}
