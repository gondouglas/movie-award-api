package gondouglas.movieaward.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gondouglas.movieaward.application.MovieApplication;
import gondouglas.movieaward.application.dto.MovieDTO;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	private final MovieApplication movieApplication;

	@Autowired
	public MovieController(MovieApplication movieApplication) {
		this.movieApplication = movieApplication;
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>> listAll() {
		List<MovieDTO> list = movieApplication.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
