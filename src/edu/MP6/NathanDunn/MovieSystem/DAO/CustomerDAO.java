package edu.MP6.NathanDunn.MovieSystem.DAO;


import edu.MP6.NathanDunn.MovieSystem.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
