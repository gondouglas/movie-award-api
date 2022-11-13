package gondouglas.movieaward.application;

import org.springframework.stereotype.Service;

import gondouglas.movieaward.application.dto.AwardIntervalDTO;

@Service
public class AwardApplication {
	

	public AwardIntervalDTO buscarIntervaloMovieaward() {
		AwardIntervalDTO dto = new AwardIntervalDTO();
		return dto;
	}

}
