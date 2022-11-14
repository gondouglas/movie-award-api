package gondouglas.movieaward.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gondouglas.movieaward.application.dto.MovieDTO;
import gondouglas.movieaward.application.mapper.CsvRowToMovieDTOMapper;
import gondouglas.movieaward.exceptions.BusinessRuntimeException;
import gondouglas.movieaward.service.CsvService;
import gondouglas.movieaward.service.CsvService.CsvFile;
import gondouglas.movieaward.service.CsvService.CsvRow;
import gondouglas.movieaward.service.ImportService;

public class MovieCsvAdapter implements ImportService<MovieDTO> {

	private final CsvService csvService;

	private final String pathFile;
	
	public MovieCsvAdapter(CsvService csvService, String pathFile) {
		this.csvService = csvService;
		this.pathFile = pathFile;
	}

	public List<MovieDTO> getData() {
		try {
			List<MovieDTO> list = new ArrayList<>();

			CsvFile csvFile = csvService.readFile(pathFile);

			for (CsvRow csvRow : csvFile.getRows()) {
				MovieDTO dto = CsvRowToMovieDTOMapper.toDTO(csvRow);
				list.add(dto);
			}
	
			return list;
		} catch (IOException e) {
			throw new BusinessRuntimeException(e);
		}
	}
}
