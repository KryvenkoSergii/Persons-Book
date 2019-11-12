package home.kryvenkosergii.javacoreproject1;

/**
 * The class 'Person' for creating object Person with first name and last
 * name includes constructor, which receive Strings 'firstName' and 'lastName',
 * getters 'getFirstName' and 'getLastName'
 * 
 * @author
 *
 */
public class Person {
	private final String firstName;
	private final String lastName;

	public Person(String firstName, String lastName) {
		if (firstName.length()<15 && firstName.length()>=2) {
			this.firstName = firstName;
		} else {
			this.firstName = "wrong first name";
		}
		if (lastName.length()<15 && lastName.length()>=2) {
			this.lastName = lastName;
		} else {
			this.lastName = "wrong last name";
		}
	}

	/**
	 * The method 'getFirstName' which return first name person
	 * 
	 * @return String 'firstName'
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * The method 'getLastName' which return last name person
	 * 
	 * @return String 'lastName'
	 */
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}