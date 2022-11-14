package gondouglas.movieaward.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gondouglas.movieaward.application.dto.DomainDTO;
import gondouglas.movieaward.application.mapper.CsvRowToDomainDTOMapper;
import gondouglas.movieaward.exceptions.BusinessRuntimeException;
import gondouglas.movieaward.service.CsvService;
import gondouglas.movieaward.service.CsvService.CsvFile;
import gondouglas.movieaward.service.CsvService.CsvRow;
import gondouglas.movieaward.service.ImportService;

public class DomainCsvAdapter<D extends DomainDTO, M extends CsvRowToDomainDTOMapper<D>> implements ImportService<D> {

	private final CsvService csvService;

	private final String pathFile;

	private final M m;
	
	public DomainCsvAdapter(CsvService csvService, String pathFile, M m) {
		this.csvService = csvService;
		this.pathFile = pathFile;
		this.m = m;
	}

	public List<D> getData() {
		try {
			List<D> list = new ArrayList<>();

			CsvFile csvFile = csvService.readFile(pathFile);

			for (CsvRow csvRow : csvFile.getRows()) {
				D dto = m.toDTO(csvRow);
				list.add(dto);
			}
	
			return list;
		} catch (IOException e) {
			throw new BusinessRuntimeException(e);
		}
	}
}
