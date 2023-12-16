package edu.MP6.NathanDunn.MovieSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
     Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movies_id")
    Movie movies;

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    public Movie getMovies() {
        return movies;
    }

    public Checkout() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Checkout History: \n" +
                "Customer: " + customer.name +
                "Movie: " + movies;
    }
}
