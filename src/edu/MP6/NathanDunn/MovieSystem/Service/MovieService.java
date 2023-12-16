package edu.MP6.NathanDunn.MovieSystem.Service;

import edu.MP6.NathanDunn.MovieSystem.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getMovies();

    void saveNewMove(Movie theMovie);

    Movie getMovie(int movId);

    Movie getMovieName(String movieName);
}
