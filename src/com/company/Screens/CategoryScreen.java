package com.company.Screens;

import java.util.List;
import java.util.Scanner;

public class CategoryScreen {
    private Scanner scanner;

    public CategoryScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public String select(List<String> categories) {
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + " - " + categories.get(i));
        }
        System.out.println("Type category number:");
        String selection = scanner.nextLine();
        var i = Integer.parseInt(selection);
        return categories.get(i);
    }
}
