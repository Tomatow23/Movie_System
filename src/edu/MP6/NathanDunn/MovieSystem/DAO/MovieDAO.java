package edu.MP6.NathanDunn.MovieSystem.DAO;

import edu.MP6.NathanDunn.MovieSystem.entity.Movie;

import java.util.List;

public interface MovieDAO {
    public List<Movie> getMovies();

    void saveNewMovie(Movie theMovie);

    Movie getMovie(int movId);

    Movie getMovieName(String movieName);
}
