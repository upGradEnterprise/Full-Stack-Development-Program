package com.zeta.spring.ioc.bean;

import java.util.List;

public class Movies {
    List<Movie> movieList;

    public void setMovieList(List<Movie> movieList) { this.movieList = movieList; }
    public List<Movie> getMovieList() { return movieList; }
}