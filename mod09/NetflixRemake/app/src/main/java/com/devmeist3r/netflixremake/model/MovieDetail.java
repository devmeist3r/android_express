package com.devmeist3r.netflixremake.model;

import java.util.List;

/**
 * Created by Lucas Inocencio on 30/03/2021
 * https://github.com/devmeist3r
 **/
public class MovieDetail {

  private final Movie movie;
  private final List<Movie> moviesSimilar;

  public MovieDetail(Movie movie, List<Movie> moviesSimilar) {
    this.movie = movie;
    this.moviesSimilar = moviesSimilar;
  }

  public Movie getMovie() {
    return movie;
  }

  public List<Movie> getMoviesSimilar() {
    return moviesSimilar;
  }
  
}
