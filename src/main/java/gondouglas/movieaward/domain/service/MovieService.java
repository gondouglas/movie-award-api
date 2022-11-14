package gondouglas.movieaward.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gondouglas.movieaward.domain.entities.Movie;
import gondouglas.movieaward.domain.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> listAll() {
		return movieRepository.findAll();
	}

	public Movie save(Movie movie) {
		return this.movieRepository.save(movie);
	}

	public void deleteById(Long id) {
		this.movieRepository.deleteById(id);
	}
}
