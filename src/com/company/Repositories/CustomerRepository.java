package com.company.Repositories;

import com.company.Models.Customer;
import com.company.IdGenerator;

public class CustomerRepository extends RepositoryBase<Customer> {

    public CustomerRepository(IdGenerator idGenerator) {
        super("Database/Customers/", idGenerator);
    }
}
