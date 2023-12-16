package edu.MP6.NathanDunn.MovieSystem.Main_Controller;

import edu.MP6.NathanDunn.MovieSystem.Service.CheckoutService;
import edu.MP6.NathanDunn.MovieSystem.entity.*;
import edu.MP6.NathanDunn.MovieSystem.Service.CustomerService;
import edu.MP6.NathanDunn.MovieSystem.Service.MovieService;
import edu.MP6.NathanDunn.MovieSystem.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("MovieSystem")
public class Controller_Main {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/cust_list")
    public String cust_list(Model model){
        model.addAttribute("customers",customerService.getCustomers());
        return "list_customers";
    }
    @PostMapping("/addCustomer")
    public String addCustomers(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add_customer";
    }
    @PostMapping("/processCustomer")
    public String processCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/MovieSystem/cust_list";
    }
    @RequestMapping("/updateCustomer")
    public String updateCustomer(Model model, @RequestParam("customerId") int id){
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer",customer);
        return "add_customer";
    }
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(Model model, @RequestParam("customerId") int id){
        customerService.deleteCustomer(id);
        return "redirect:/MovieSystem/cust_list";
    }
    @RequestMapping("/addCheckout")
    public String addCheckout(Model model, @RequestParam("customerId") int id){
        Checkout checkout = new Checkout();
        Customer customer = customerService.getCustomer(id);
        customer.addCheckout(checkout);
        checkout.setCustomer(customer);
        customerService.saveCustomer(customer);
        model.addAttribute("checkout",checkout);
        model.addAttribute("customer",customerService.getCustomer(id));
        model.addAttribute("movies",movieService.getMovies());
        return "movieList";
    }
    @RequestMapping("/checkoutList")
    public String checkoutList(Model model,@RequestParam("customerId")int id){
        model.addAttribute("checkout",customerService.getCustomer(id).getCheckouts());
        model.addAttribute("customer",customerService.getCustomer(id));
        return "checkout";
    }
    @RequestMapping("/deleteCheckout")
    public String deleteCheckout(Model model, @RequestParam("checkoutId")int id,@RequestParam("customerId")int cust_id){
        Customer customer = customerService.getCustomer(cust_id);
        customer.deleteCheckout(checkoutService.getACheckout(id));
        checkoutService.deleteCheckout(id);
        model.addAttribute("customer",customer);
        return "redirect:/MovieSystem/checkoutList?customerId="+cust_id;
    }
    @RequestMapping("/addNewMovie")
    public String addNewMovie(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "new_movie";
    }
    @RequestMapping("/processNewMovie")
    public String processNewMovie(@ModelAttribute("movie") Movie theMovie){
        movieService.saveNewMove(theMovie);
        return "redirect:/MovieSystem/cust_list";

    }
    @RequestMapping("/addMovieToList")
    public String addMovieToList(RedirectAttributes redirectAttributes,Model model, @RequestParam("customerId") int cust_id, @RequestParam("checkoutId") int id, @RequestParam("movieId") int mov_id){
        Checkout checkout = checkoutService.getACheckout(id);
        checkout.setMovies(movieService.getMovie(mov_id));
        redirectAttributes.addFlashAttribute("customer",customerService.getCustomer(cust_id));
        checkoutService.saveCheckout(checkout);
        return "redirect:/MovieSystem/checkoutList?customerId="+cust_id;
    }
    @RequestMapping("/displayAllMovies")
    public String DisplayAllMovies(Model model){
        model.addAttribute("movies",movieService.getMovies());
        return "allMovies";
    }
}





























