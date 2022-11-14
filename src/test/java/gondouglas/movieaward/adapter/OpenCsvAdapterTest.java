package gondouglas.movieaward.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import gondouglas.movieaward.service.CsvService.CsvFile;
import gondouglas.movieaward.service.CsvService.CsvRow;

public class OpenCsvAdapterTest {
	
	@Test
	public void testReadFile() throws IOException {
		OpenCsvAdapter openCsvAdapter = new OpenCsvAdapter();
		CsvFile csvFile = openCsvAdapter.readFile("movielist.csv");

		assertEquals(Boolean.FALSE, csvFile.getRows().isEmpty(), "A lista não deve ser vazia");
	}

	@Test
	public void testReadFileFirstRowWithFiveCells() throws IOException {
		OpenCsvAdapter openCsvAdapter = new OpenCsvAdapter();
		CsvFile csvFile = openCsvAdapter.readFile("movielist.csv");

		CsvRow csvRow = csvFile.getRows().get(0);

		assertEquals(5, csvRow.getCells().size(), "A quantidade de celulas deve ser 5");
	}

	@Test
	public void testReadFileHeaderWithFiveCells() throws IOException {
		OpenCsvAdapter openCsvAdapter = new OpenCsvAdapter();
		CsvFile csvFile = openCsvAdapter.readFile("movielist.csv");

		int headerSize = csvFile.getHeaders().size();

		assertEquals(5, headerSize, "A quantidade de headers deve ser 5");
	}

	@Test
	public void testReadFileAllRowWithSameSizeHeaders() throws IOException {
		OpenCsvAdapter openCsvAdapter = new OpenCsvAdapter();
		CsvFile csvFile = openCsvAdapter.readFile("movielist.csv");

		int headerSize = csvFile.getHeaders().size();

		for (CsvRow csvRow : csvFile.getRows()) {
			assertEquals(headerSize, csvRow.getCells().size(), "A quantidade de celulas deve ser sempre igual ao tamanho do header");
		}
	}
}
