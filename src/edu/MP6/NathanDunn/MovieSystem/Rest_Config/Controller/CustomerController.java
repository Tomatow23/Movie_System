package edu.MP6.NathanDunn.MovieSystem.Rest_Config.Controller;

import edu.MP6.NathanDunn.MovieSystem.DAO.MovieDAO;
import edu.MP6.NathanDunn.MovieSystem.Service.CheckoutService;
import edu.MP6.NathanDunn.MovieSystem.Service.CustomerService;
import edu.MP6.NathanDunn.MovieSystem.Service.MovieService;
import edu.MP6.NathanDunn.MovieSystem.entity.Checkout;
import edu.MP6.NathanDunn.MovieSystem.entity.Customer;
import edu.MP6.NathanDunn.MovieSystem.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieAPI")
public class CustomerController {
    @Autowired
    private MovieService movieServices;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CheckoutService checkoutService;

    @RequestMapping("/movies/{movieName}")
    public Movie getMovie(@PathVariable String movieName){
        return movieServices.getMovieName(movieName);
    }
    @RequestMapping("/customer/{customerId}")
    public List<Checkout> customer_History(@PathVariable int customerId){
        return customerService.getCustomer(customerId).getCheckouts();
    }
}
