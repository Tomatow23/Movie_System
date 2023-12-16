package edu.MP6.NathanDunn.MovieSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     int id;
    @Column(name = "movie_name")
    String movie_name;
    @Column(name = "age_level")
    String age_level;

    public Movie(String movie_name, String age_level) {
        this.movie_name = movie_name;
        this.age_level = age_level;
    }
    public Movie(){

    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getAge_level() {
        return age_level;
    }

    public void setAge_level(String age_level) {
        this.age_level = age_level;
    }

    public int getId() {
        return id;
    }




    @Override
    public String toString() {
        return "Movie Name:" + movie_name +
                "\n Age Requirement: " + age_level;
    }
}
