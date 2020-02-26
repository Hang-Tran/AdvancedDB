package com.company.Screens;

import com.company.Models.Customer;
import com.company.Models.Session;

import java.io.IOException;
import java.util.Scanner;

public class StartScreen {
    private Scanner scanner;
    private Session session;
    private LoginScreen loginScreen;
    private SignupScreen signupScreen;
    private WelcomeScreen welcomeScreen;

    public StartScreen(Scanner scanner, Session session, LoginScreen loginScreen, SignupScreen signupScreen, WelcomeScreen welcomeScreen) {
        this.scanner = scanner;
        this.session = session;
        this.loginScreen = loginScreen;
        this.signupScreen = signupScreen;
        this.welcomeScreen = welcomeScreen;
    }

    public void select() throws IOException, ClassNotFoundException, NoSuchFieldException {
        System.out.println("#############################");
        System.out.println("Welcome to our Webshop!");
        System.out.println("1: Login");
        System.out.println("2: Sign up as new customer");
        System.out.println("3: Exit");
        System.out.println("#############################");

        var selection = scanner.nextLine();

        handleSelection(selection);
    }

    private void handleSelection(String selection) throws IOException, ClassNotFoundException, NoSuchFieldException {
        switch (selection) {
            case "1":
                login();
                break;
            case "2":
                signup();
                break;
            case "3":
                exit();
                break;
            default:
                select();
        }
    }

    private void exit() {
        System.out.println("Goodbye ;-)!");
    }

    private void signup() throws NoSuchFieldException, IOException, ClassNotFoundException {
        var customer = signupScreen.signup();
        setCustomer(customer);
    }

    private void login() throws IOException, ClassNotFoundException {
        var customer = loginScreen.login();
        setCustomer(customer);
    }

    private void setCustomer(Customer customer) throws IOException, ClassNotFoundException {
        session.setCustomer(customer);
        welcomeScreen.select();
    }
}
