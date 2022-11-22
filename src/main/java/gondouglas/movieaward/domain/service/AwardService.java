package gondouglas.movieaward.domain.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gondouglas.movieaward.application.dto.AwardDTO;
import gondouglas.movieaward.application.dto.MovieDTO;

@Service
public class AwardService {

	public List<AwardDTO> findProducerGreaterIntervalWin(List<MovieDTO> winners) {
		List<AwardDTO> list = generateIntervals(winners);

		int interval = list.stream().sorted((o1,o2) -> o2.getInterval().compareTo(o1.getInterval())).map(x -> x.getInterval()).findFirst().orElse(0);

		return list.stream().filter(x -> x.getInterval().equals(interval)).collect(Collectors.toList());
	}

	public List<AwardDTO> findProducerLesserIntervalWin(List<MovieDTO> winners) {
		List<AwardDTO> list = generateIntervals(winners);

		int interval = list.stream().sorted((o1,o2) -> o1.getInterval().compareTo(o2.getInterval())).map(x -> x.getInterval()).findFirst().orElse(0);

		return list.stream().filter(x -> x.getInterval().equals(interval)).collect(Collectors.toList());
	}


	private List<AwardDTO> generateIntervals(List<MovieDTO> winners) {
		List<AwardDTO> list = new ArrayList<>();

		List<MovieDTO> separateProducers = separateProducers(winners).stream().sorted((o1, o2) -> o1.getYear().compareTo(o2.getYear())).collect(Collectors.toList());

		separateProducers.stream().collect(Collectors.groupingBy(x -> x.getProducers(), LinkedHashMap::new, Collectors.toList()))
		.forEach((producer, movies) -> {
			AwardDTO dto = new AwardDTO();
			dto.setProducer(producer);

			for (MovieDTO movie : movies) {
				if (dto.getPreviousWin() == null) {
					dto.setPreviousWin(movie.getYear());
				} else {
					if (dto.getFollowingWin() != null) {
						dto.setPreviousWin(dto.getFollowingWin());
					}
					dto.setFollowingWin(movie.getYear());
	
					list.add(dto);
					
					dto = new AwardDTO();
					dto.setProducer(producer);
					dto.setPreviousWin(movie.getYear());
				}
			}
		});

		return list;
	}

	private List<MovieDTO> separateProducers(List<MovieDTO> movies) {
		List<MovieDTO> list = new ArrayList<>();

		for (MovieDTO movie : movies) {
			String[] producers = movie.getProducers().replace(" and ", ", ").split(",");

			for (String producer : producers) {
				MovieDTO dto = new MovieDTO();
				dto.setProducers(producer.trim());
				dto.setStudio(movie.getStudio());
				dto.setTitle(movie.getStudio());
				dto.setWinner(movie.getWinner());
				dto.setYear(movie.getYear());
				list.add(dto);
			}
		}

		return list;
	}
}
