package gondouglas.movieaward.application.mapper;

import gondouglas.movieaward.application.dto.MovieDTO;
import gondouglas.movieaward.domain.entities.Movie;

public class MovieToMovieDTOMapper {

	private MovieToMovieDTOMapper() {}
	
	public static MovieDTO toDTO(Movie e) {
		MovieDTO dto = new MovieDTO();
		dto.setId(e.getId());
		dto.setProducers(e.getProducers());
		dto.setStudio(e.getStudio());
		dto.setTitle(e.getTitle());
		dto.setWinner(e.getWinner());
		dto.setYear(e.getYear());
		return dto;
	}

	public static Movie toEntity(MovieDTO dto) {
		Movie e = new Movie();
		e.setId(dto.getId());
		e.setProducers(dto.getProducers());
		e.setStudio(dto.getStudio());
		e.setTitle(dto.getTitle());
		e.setWinner(dto.getWinner());
		e.setYear(dto.getYear());
		return e;
	}
}
