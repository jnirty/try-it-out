package com.example.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hsqldb.Types;
import org.objectweb.asm.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.example.domain.Movie;

public class MovieDAO implements IMovieDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	private class MovieRowMapper implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setId(resultSet.getLong("id"));
			movie.setStars(resultSet.getString("stars"));
			movie.setTitle(resultSet.getString("title"));
			return movie;
		}

	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Movie getMovie(final long id) {
		return getJdbcTemplate().queryForObject("select * from MOVIE", new MovieRowMapper());
	}

	@Override
	public String getStars(String title) {
		return getJdbcTemplate().queryForObject("select stars from MOVIE where title = ?", new String[] { title }, String.class);
	}

	@Override
	public List<Movie> getMovies(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		return getJdbcTemplate().query("select * from MOVIE", new RowMapperResultSetExtractor<Movie>(new MovieRowMapper(), 10));
	}

	@Override
	public void insertMovie(Movie movie) {
		getJdbcTemplate().update("insert into MOVIE() values (stars,title)", 
				new Object[] { movie.getStars(), movie.getTitle() }, 
				new int[] { Types.VARCHAR, Types.VARCHAR });

	}

	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMovie(long id) {
		getJdbcTemplate().update("delete from MOVIE where id = ?", new Object[]{id});
	}

	@Override
	public void deleteAllMovies() {
		getJdbcTemplate().update("delete from MOVIE");
	}

}
