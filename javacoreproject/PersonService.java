package home.kryvenkosergii.javacoreproject1;

/**
 * The interface 'PersonService'. 
 * Consist from constructor, which receive
 * integer value, method 'getCount', which return integer value, method
 * 'removePerson', which receive integer value and method 'addPerson', which
 * receive object Person type
 * 
 * @author
 */
public interface PersonService {

	/**
	 * The abstract constructor
	 * 
	 * @param idx
	 */
	public Person getPerson(int idx);

	/**
	 * The abstract method 'getCount' which return count of persons
	 * 
	 * @return integer value
	 */
	public int getCount();

	/**
	 * The abstract method 'removePerson', which receive integer value
	 * 
	 * @param idx
	 */
	public void removePerson(int idx);

	/**
	 * The abstract method 'addPerson', which receive object Person type
	 * 
	 * @param person
	 */
	public void addPerson(Person person);
}