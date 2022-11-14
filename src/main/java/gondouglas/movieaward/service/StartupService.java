package gondouglas.movieaward.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gondouglas.movieaward.adapter.MovieCsvAdapter;
import gondouglas.movieaward.adapter.OpenCsvAdapter;
import gondouglas.movieaward.application.MovieApplication;

@Service
public class StartupService {

	private final MovieApplication movieApplication;

	@Autowired
	public StartupService(MovieApplication movieApplication) {
		this.movieApplication = movieApplication;
	}

	
	public void execute() {
		this.movieApplication.executeImportation(new MovieCsvAdapter(new OpenCsvAdapter(), "movielist.csv"));
	}
}
