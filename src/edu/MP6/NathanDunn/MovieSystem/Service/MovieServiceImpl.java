package edu.MP6.NathanDunn.MovieSystem.Service;

import edu.MP6.NathanDunn.MovieSystem.DAO.MovieDAO;
import edu.MP6.NathanDunn.MovieSystem.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDAO movieDAO;
    @Override
    @Transactional
    public List<Movie> getMovies() {
        return movieDAO.getMovies();
    }

    @Override
    @Transactional
    public void saveNewMove(Movie theMovie) {
         movieDAO.saveNewMovie(theMovie);
    }

    @Override
    @Transactional
    public Movie getMovie(int movId) {
        return movieDAO.getMovie(movId);
    }

    @Override
    @Transactional
    public Movie getMovieName(String movieName) {
        return movieDAO.getMovieName(movieName);
    }
}
