package gondouglas.movieaward.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gondouglas.movieaward.adapter.DomainCsvAdapter;
import gondouglas.movieaward.adapter.OpenCsvAdapter;
import gondouglas.movieaward.application.MovieApplication;
import gondouglas.movieaward.application.mapper.CsvRowToMovieDTOMapper;

@Service
public class StartupService {

	private final MovieApplication movieApplication;

	@Autowired
	public StartupService(MovieApplication movieApplication) {
		this.movieApplication = movieApplication;
	}

	
	public void execute() {
		OpenCsvAdapter csvService = new OpenCsvAdapter();
		String pathFile = "movielist.csv";

		this.movieApplication.executeImportation(new DomainCsvAdapter<>(csvService, pathFile, new CsvRowToMovieDTOMapper()));
	}
}
