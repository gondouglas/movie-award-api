package gondouglas.movieaward.application;

import java.util.List;

import org.springframework.stereotype.Service;

import gondouglas.movieaward.application.dto.AwardDTO;
import gondouglas.movieaward.application.dto.AwardIntervalDTO;
import gondouglas.movieaward.application.dto.MovieDTO;
import gondouglas.movieaward.domain.service.AwardService;

@Service
public class AwardApplication {

	private final AwardService awardService;

	private final MovieApplication movieApplication;

	public AwardApplication(AwardService awardService, MovieApplication movieApplication) {
		this.awardService = awardService;
		this.movieApplication = movieApplication;
	}
	

	public AwardIntervalDTO searchInvervalAward() {
		List<MovieDTO> winners = movieApplication.listAllWinners();

		AwardIntervalDTO dto = new AwardIntervalDTO();

		List<AwardDTO> awardGreaterDTO = awardService.findProducerGreaterIntervalWin(winners);
		List<AwardDTO> awardLesserDTO = awardService.findProducerLesserIntervalWin(winners);

		dto.setMax(awardGreaterDTO);
		dto.setMin(awardLesserDTO);

		return dto;
	}

}
