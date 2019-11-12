package home.kryvenkosergii.javacoreproject1;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Public class 'CSVFileBasedPersonServiceImpl' hereditary from class
 * 'AbstractFileBasedPersonService' for action 'save' and 'load' in file CSV
 * format
 * 
 * @author 
 *
 */

public class CSVFileBasedPersonServiceImpl extends AbstractFileBasedPersonService {

	private final Charset charset;

	public CSVFileBasedPersonServiceImpl() {
		charset = Charset.forName("CP1251");
	}

	public CSVFileBasedPersonServiceImpl(Charset charset) {
		this.charset = charset;
	}

	/*
	 * Method 'load' for reading database from 'lines' array
	 * 
	 * @param filePath (string format)
	 */
	public void load(String filePath) {
		super.cleal();
		List<String> lines = FileUtil.load(filePath, charset);
		for (String line : lines) {
			if (line != null) {
				String firstName;
				if (line.length() > 0 && line.charAt(0) == '"') {
					int i = 1;
					boolean afterQuote = false;
					while (i < line.length()) {
						char c = line.charAt(i);
						if (c == '"') {
							afterQuote = !afterQuote;
						} else if (afterQuote) {
							break;
						}
						i++;
					}
//					System.out.println("line1 before substring " + line);
					firstName = line.substring(1, i - 1).replaceAll("\"\"", "\"");
//					System.out.println("line.substring(1, i - 1)" + line.substring(1, i - 1));
					line = line.substring(i + 1);
//					System.out.println("line1 after substring " + line);
//					System.out.println("firstName1 " + firstName);
				} else {
					int indexOfSeparator = line.indexOf(";");
//					System.out.println("line2 before substring " + line);
					firstName = line.substring(0, indexOfSeparator);
					line = line.substring(indexOfSeparator + 1);
//					System.out.println("line2 after substring " + line);
//					System.out.println("firstName2 " + firstName);
				}

				String lastName;
				if (line.length() > 0 && line.charAt(0) == '"') {
					int i = 1;
					boolean afterQuote = false;
					while (i < line.length()) {
						char c = line.charAt(i);
						if (c == '"') {
							afterQuote = !afterQuote;
						} else if (afterQuote) {
							break;
						}
						i++;
					}
//					System.out.println("line3 " + line);
					lastName = line.substring(1, i - 1).replaceAll("\"\"", "\"");
//					System.out.println("lastName3 " + lastName);
				} else {
					int indexOfSeparator = line.indexOf(";");
//					System.out.println("line4 " + line);
					lastName = line.substring(0, indexOfSeparator);
//					System.out.println("lastName4 " + lastName);
				}

				super.addPerson(new Person(firstName, lastName));
			}
		}
	}

	/**
	 * Method 'save' for saving database to file 'CSV' format
	 * 
	 * @param filePath (string format)
	 */
	public void save(String filePath) {
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < getCount(); i++) {
			Person person = getPerson(i);
			System.out.println("simple get name: " + person.getFirstName() + " " + person.getLastName());
			System.out.println("dificult with double '' get name: " + person.getFirstName().replaceAll("\"", "\"\"") + " " + person.getLastName().replaceAll("\"", "\"\""));
			lines.add("\"" + person.getFirstName().replaceAll("\"", "\"\"") + "\";\""
					+ person.getLastName().replaceAll("\"", "\"\"") + "\"");
		}
		FileUtil.save(filePath, charset, lines);
	}
}
