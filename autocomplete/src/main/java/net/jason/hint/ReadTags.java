package net.jason.hint;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadTags {

	public static List<String> readAll(ServletContext context) throws IOException {
		
		InputStream is = context.getResourceAsStream("/WEB-INF/Tag.csv");
		
		List<String> tagsList = new ArrayList<>();
		
		try (CSVReader reader = new CSVReader(new InputStreamReader(is))) {
			String[] nextLine;
			try {
				while((nextLine = reader.readNext()) != null) {
					for(String e : nextLine) {
						tagsList.add(e.trim());
					}
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tagsList;
	}
}
