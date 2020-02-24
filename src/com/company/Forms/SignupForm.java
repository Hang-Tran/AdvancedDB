package com.company.Forms;

import com.company.Models.Customer;
import java.util.Scanner;

public class SignupForm {
    public static Customer Read() throws NoSuchFieldException {
            Scanner scan = new Scanner(System.in);

            String name = "";
            String address = "";
            String mail = "";
            String tel = "";

            do {
                System.out.println("Your name:");
                name = scan.nextLine();
            } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("name"), name));

            do {
                System.out.println("Your address:");
                address = scan.nextLine();
            } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("address"), address));

            do {
                System.out.println("Your mail: ");
                mail = scan.nextLine();
            } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("mail"), mail));

            do {
                System.out.println("Your telephone number:");
                tel = scan.nextLine();
            } while (!Helpers.validateAndPrint(Customer.class.getDeclaredField("tel"), tel));

            var customer = new Customer(name, address, mail, tel);

            return customer;

    }
}
