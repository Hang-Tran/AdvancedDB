package com.company.Repositories;

import com.company.IdGenerator;
import com.company.Models.Product;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository extends RepositoryBase<Product> {
    public ProductRepository(IdGenerator idGenerator) {
        super("Database/Products/", idGenerator);
    }

    public List<Product> all() throws IOException, ClassNotFoundException {
        var dir = new File(this.path);
        var files = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".ser"));

        var result = new ArrayList<Product>();
        for (var file: files) {
            var name = file.getName();
            result.add(this.get(name.substring(0, name.length() - 4)));
        }

        return result;
    }

    public List<String> allCategories() throws IOException, ClassNotFoundException {
        var products = all();
        return products.stream()
                .map(product -> product.getCategory())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Product> byCategory(String category) throws IOException, ClassNotFoundException {
        var products = all();
        return products.stream()
                .filter(product -> category.equals(product.getCategory()))
                .collect(Collectors.toList());
    }
}
