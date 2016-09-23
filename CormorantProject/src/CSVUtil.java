import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

public class CSVUtil {
	//CSVReader reader=new CSVReader(new FileReader("text.csv"));
	InputStream inputStream=getClass().getClassLoader().getResourceAsStream("text.csv");
	BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
}
