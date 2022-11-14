package gondouglas.movieaward.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gondouglas.movieaward.domain.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
}
