package gondouglas.movieaward.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public interface CsvService {
	
	CsvFile readFile(String path) throws IOException;

	@Getter @Setter
	public class CsvFile {
		private List<String> headers = new ArrayList<>();
		private List<CsvRow> rows = new ArrayList<>();
	}

	@Getter @Setter
	public class CsvRow {
		private List<CsvCell> cells = new ArrayList<>();
	}

	@Getter @Setter
	public class CsvCell {
		private String value;
	}

}
