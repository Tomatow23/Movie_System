package edu.MP6.NathanDunn.MovieSystem.Service;

import edu.MP6.NathanDunn.MovieSystem.DAO.CheckoutDAO;
import edu.MP6.NathanDunn.MovieSystem.entity.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    private CheckoutDAO checkoutDAO;

    @Override
    @Transactional
    public List<Checkout> getCheckout() {
        return checkoutDAO.getCheckout();
    }

    @Override
    @Transactional
    public Checkout getACheckout(int id) {
        return checkoutDAO.getACheckout(id);
    }

    @Override
    @Transactional
    public void deleteCheckout(int id) {
        checkoutDAO.deleteCheckout(id);
    }

    @Override
    @Transactional
    public void saveCheckout(Checkout checkout) {
        checkoutDAO.saveCheckout(checkout);
    }
}
