import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opencsv.CSVReader;

public class CSVUtil {
	private Map<Integer,Person> personMap;
	private List<Interaction> interactions;

	public CSVUtil() {
		personMap = new TreeMap<>();
		interactions =  new ArrayList<>();
	}

	public void loadWatchers(String fileName) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(fileName));

		List<String[]> myRows = reader.readAll();
		String[] headerRow = myRows.remove(0); // remove header row

		for (String[] row : myRows) {
			addWatcher(new BirdWatcher(row));
		}
}
}