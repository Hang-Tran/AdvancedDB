package com.company;

import com.company.Models.Product;
import com.company.Repositories.ProductRepository;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*var productRepository = new ProductRepository(new IdGenerator());
        var product = new Product();
        product.setName("LG 75Um7110Plb 75 Ultra HD 4k TV");
        product.setCategory("TV");
        product.setPrice(9990);
        product.setStock(15);
        productRepository.add(product);
        // var x = productRepository.all();*/
      var menu = new Menu();
      menu.startMenu();

       // ProductRepository pr = new ProductRepository();
        //RepositoryCustomer rc = new RepositoryCustomer();
        //Category.phoneList();
        //pr.addProduct();
       // rc.addCustomer();
    }
}
