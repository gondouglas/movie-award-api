package gondouglas.movieaward.application.mapper;

import gondouglas.movieaward.application.dto.DomainDTO;
import gondouglas.movieaward.service.CsvService.CsvRow;

public interface CsvRowToDomainDTOMapper<D extends DomainDTO> {
	
	D toDTO(CsvRow csvRow);

}
