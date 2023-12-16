package edu.MP6.NathanDunn.MovieSystem.Service;

import edu.MP6.NathanDunn.MovieSystem.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
