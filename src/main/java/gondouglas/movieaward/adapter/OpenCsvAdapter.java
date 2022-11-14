package gondouglas.movieaward.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import gondouglas.movieaward.service.CsvService;

public class OpenCsvAdapter implements CsvService {

	@Override
	public CsvFile readFile(String path) throws IOException {
		CsvFile csvFile = new CsvFile();

		List<CsvRow> list = new ArrayList<>();

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(path);
		Reader inputStreamReader = new InputStreamReader(is);

        CSVReader csvReader = new CSVReaderBuilder(inputStreamReader).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();

        List<String[]> rows = csvReader.readAll();
		int i = 0;

        for (String[] row : rows) {
			if (i == 0) {
				for (String header : row) {
					csvFile.getHeaders().add(header);
				}
			} else {
				CsvRow csvRow = new CsvRow();
	
				extractCells(row, csvRow);

				int cellSize = csvRow.getCells().size();
				int headerSize = csvFile.getHeaders().size();

				if (cellSize < headerSize) {
					for (int j = cellSize; j < headerSize; j++) {
						addCell(csvRow, null);
					}
				}
	
				list.add(csvRow);
			}
			i++;
		}

		csvFile.setRows(list);

		return csvFile;
	}

	private void extractCells(String[] row, CsvRow csvRow) {
		for (String cell : row) {
			addCell(csvRow, cell);
		}
	}

	private void addCell(CsvRow csvRow, String cell) {
		CsvCell csvCell = new CsvCell();

		csvCell.setValue(cell);
		csvRow.getCells().add(csvCell);
	}
}
