package edu.MP6.NathanDunn.MovieSystem.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import edu.MP6.NathanDunn.MovieSystem.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheckoutDAOImpl implements CheckoutDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Checkout> getCheckout() {
        Session session = sessionFactory.getCurrentSession();
        Query<Checkout> query = session.createQuery("From Checkout",Checkout.class);
        return query.getResultList();
    }

    @Override
    public Checkout getACheckout(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Checkout.class,id);
    }

    @Override
    public void deleteCheckout(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Checkout where id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public void saveCheckout(Checkout checkout) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(checkout);
    }
}
