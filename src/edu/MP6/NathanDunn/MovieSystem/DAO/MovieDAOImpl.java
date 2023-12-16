package edu.MP6.NathanDunn.MovieSystem.DAO;

import edu.MP6.NathanDunn.MovieSystem.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MovieDAOImpl implements MovieDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Movie> getMovies() {
        Session session = sessionFactory.getCurrentSession();
        Query<Movie> query = session.createQuery("from Movie", Movie.class);
        return query.getResultList();
    }

    @Override
    public void saveNewMovie(Movie theMovie) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theMovie);
    }

    @Override
    public Movie getMovie(int movId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Movie.class,movId);
    }

    @Override
    public Movie getMovieName(String movieName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Movie> query = session.createQuery("from Movie where movie_name = :movieName",Movie.class);
        query.setParameter("movieName",movieName);
        return query.getSingleResult();
    }
}
