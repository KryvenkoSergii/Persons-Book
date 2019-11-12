package home.kryvenkosergii.javacoreproject1;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class 'AbstractFileBasedPersonService' hereditary from class 'PersonService'.
 * This class is a pattern for classes, which are saving database to file and loading database from file.
 * Include List of persons
 * @author 
 */
public abstract class AbstractFileBasedPersonService implements PersonService {

	/**
	 * Collection persons
	 */
	private List<Person> persons = new ArrayList<>();
	
	protected void cleal() {
		persons.clear();
	}

	@Override
	public int getCount() {
		return persons.size();
	}

	@Override
	public Person getPerson(int idx) {
		return idx >= 0 && idx < persons.size() ? persons.get(idx) : null;
	}

	@Override
	public void removePerson(int idx) {
		if (idx < 0 || idx >= persons.size()) {
			return;
		}
		persons.remove(idx);
	}

	@Override
	public void addPerson(Person person) {
		persons.add(person);
		
	}

	/**
	 * abstract method 'load', which receive string value 'fileName'
	 * @param fileName
	 */
	public abstract void load(String fileName);

	/**
	 * abstract method 'save', which receive string value 'fileName'
	 * @param fileName
	 */
	public abstract void save(String fileName);
}
