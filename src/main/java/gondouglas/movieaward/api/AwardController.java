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

	private final AwardApplication awardApplication;
	
	@Autowired
	public AwardController(AwardApplication awardApplication) {
		this.awardApplication = awardApplication;
	}

	@GetMapping
	public ResponseEntity<AwardIntervalDTO> searchInvervalAward() {
		AwardIntervalDTO dto = awardApplication.searchInvervalAward();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
