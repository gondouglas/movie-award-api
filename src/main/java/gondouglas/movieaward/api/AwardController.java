package gondouglas.movieaward.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gondouglas.movieaward.application.AwardApplication;
import gondouglas.movieaward.application.dto.AwardIntervalDTO;

@RestController
@RequestMapping("/api/awards")
public class AwardController {

	@Autowired
	private AwardApplication awardApplication;

	@GetMapping
	public ResponseEntity<AwardIntervalDTO> buscarIntervaloMovieawards() {
		AwardIntervalDTO dto = awardApplication.buscarIntervaloMovieaward();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
