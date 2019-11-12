package home.kryvenkosergii.javacoreproject1;

import javax.swing.table.DefaultTableModel;

/**
 * The class 'PersonTableModel' hereditary from class 'DefaultTableModel' 
 * 
 * @author
 */
public class PersonTableModel extends DefaultTableModel {
	private static final long serialVersionUID = -3162102690443326831L;
	private static final String[] COLUMN_NAMES = { "Fist name", "Last name" };
	private final PersonService personService;

	/**
	 * The constructor, which receive value 'PersonService' type
	 * @param personService
	 */
	public PersonTableModel(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int idx) {
		return idx >= 0 && idx < COLUMN_NAMES.length ? COLUMN_NAMES[idx] : "";
	}

	@Override
	public int getRowCount() {
		return personService == null ? 0 : personService.getCount();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (row >= getRowCount() || row < 0) {
			return "";
		}
		Person person = personService.getPerson(row);
		String value = "";
		switch (column) {
		case 0:
			value = person.getFirstName();
			break;
		case 1:
			value = person.getLastName();
			break;
		}
		return value;
	}
}