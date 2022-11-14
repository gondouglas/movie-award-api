package gondouglas.movieaward.application.mapper;

import gondouglas.movieaward.application.dto.MovieDTO;
import gondouglas.movieaward.application.enumeration.YesNoEnum;
import gondouglas.movieaward.service.CsvService.CsvRow;

public class CsvRowToMovieDTOMapper {

	private CsvRowToMovieDTOMapper(){}

	public static MovieDTO toDTO(CsvRow csvRow) {
		MovieDTO dto = new MovieDTO();
		dto.setYear(Integer.parseInt(csvRow.getCells().get(0).getValue()));
		dto.setTitle(csvRow.getCells().get(1).getValue());
		dto.setStudio(csvRow.getCells().get(2).getValue());
		dto.setProducers(csvRow.getCells().get(3).getValue());
		dto.setWinner(YesNoEnum.YES.options().contains(csvRow.getCells().get(4).getValue()));
		return dto;
	}

}
