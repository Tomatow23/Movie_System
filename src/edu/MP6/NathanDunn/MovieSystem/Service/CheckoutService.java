package edu.MP6.NathanDunn.MovieSystem.Service;

import edu.MP6.NathanDunn.MovieSystem.entity.Checkout;

import java.util.List;

public interface CheckoutService {
    public List<Checkout> getCheckout();

    Checkout getACheckout(int id);

    void deleteCheckout(int id);

    void saveCheckout(Checkout checkout);
}
