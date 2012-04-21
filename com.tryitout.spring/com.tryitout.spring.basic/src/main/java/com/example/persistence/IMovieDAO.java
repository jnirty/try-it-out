package com.example.persistence;

import java.util.List;

import com.example.domain.Movie;

public interface IMovieDAO {
	Movie getMovie(long id);

	String getStars(String title);
	List<Movie> getMovies(String sql);
	List<Movie> getAllMovies();	
	void insertMovie(Movie movie);
	void updateMovie(Movie movie);
	void deleteMovie(long id);
	void deleteAllMovies();

}
