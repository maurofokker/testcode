package com.maurofokker.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauro on 9/21/17.
 */
public class Movie {
    private int movieId;
    private float rating;
    private List<Movie> similarMovies;

    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(ArrayList<Movie> similarMovies) {
        this.similarMovies = similarMovies;
    }
}
