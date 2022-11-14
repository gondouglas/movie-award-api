package gondouglas.movieaward.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gondouglas.movieaward.application.dto.MovieDTO;
import gondouglas.movieaward.application.mapper.MovieToMovieDTOMapper;
import gondouglas.movieaward.domain.entities.Movie;
import gondouglas.movieaward.domain.service.MovieService;
import gondouglas.movieaward.service.ImportService;

@Service
public class MovieApplication {
	
	private final MovieService movieService;

	public MovieApplication(MovieService movieService) {
		this.movieService = movieService;
	}

	public List<MovieDTO> listAll() {
		return movieService.listAll().stream().map(MovieToMovieDTOMapper::toDTO).collect(Collectors.toList());
	}

	public List<MovieDTO> listAllWinners() {
		return movieService.listAllWinners().stream().map(MovieToMovieDTOMapper::toDTO).collect(Collectors.toList());
	}

	public MovieDTO save(MovieDTO dto) {
		Movie entity = MovieToMovieDTOMapper.toEntity(dto);
		Movie saved = movieService.save(entity);
		return MovieToMovieDTOMapper.toDTO(saved);
	}

	public List<MovieDTO> saveList(List<MovieDTO> list) {
		List<MovieDTO> saved = new ArrayList<>();
		for (MovieDTO movieDTO : list) {
			saved.add(save(movieDTO));
		}

		return saved;
	}

	public void deleteById(Long id) {
		movieService.deleteById(id);
	}

	public void executeImportation(ImportService<MovieDTO> importService) {
		List<MovieDTO> data = importService.getData();
		saveList(data);
	}
}
