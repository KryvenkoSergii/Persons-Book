package home.kryvenkosergii.javacoreproject1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * The class AddressBook for creating a table of persons, add some persons, loading table values from file 'csv' and saving table to file
 * @author Serg
 *
 */
public class AddressBook {

	private static final AbstractFileBasedPersonService PERSON_SERVICE;
	private static final PersonTableModel TABLE_MODEL;
	private static JTable mainTable;

	static {
		PERSON_SERVICE = new CSVFileBasedPersonServiceImpl(); // new DummyPersonService();
		TABLE_MODEL = new PersonTableModel(PERSON_SERVICE);
		mainTable = new JTable(TABLE_MODEL);
	}

	public static void main(String args[]) {
		// creating table of person
		JFrame mainWindow = new JFrame("Address book");
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// add buttons
		JButton btnAdd = new JButton("+");
		JButton btnRemove = new JButton("-");
		JButton btnSave = new JButton("Save");
		JButton btnLoad = new JButton("Load");

		JPanel btnPanel = new JPanel(new BorderLayout());

		// add action
		btnAdd.addActionListener(AddressBook::add);
		btnRemove.addActionListener(AddressBook::remove);
		btnSave.addActionListener(AddressBook::save);
		btnLoad.addActionListener(AddressBook::load);

		// position of buttons
		btnPanel.add(btnAdd, BorderLayout.EAST);
		btnPanel.add(btnSave, BorderLayout.CENTER);
		btnPanel.add(btnRemove, BorderLayout.WEST);
		btnPanel.add(btnLoad, BorderLayout.SOUTH);
		mainWindow.getContentPane().setLayout(new BorderLayout());
		mainWindow.getContentPane().add(btnPanel, BorderLayout.SOUTH);
		mainWindow.getContentPane().add(new JScrollPane(mainTable), BorderLayout.CENTER);

		mainWindow.pack();
		mainWindow.setVisible(true);
	}

	/**
	 * The method 'save' for action saving to file
	 * @param event
	 */
	private static void save(ActionEvent event) {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			PERSON_SERVICE.save(jfc.getSelectedFile().getAbsolutePath());
		}
	}

	/**
	 * The method 'load' for loading values to table 
	 * @param event
	 */
	private static void load(ActionEvent event) {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				PERSON_SERVICE.load(jfc.getSelectedFile().getAbsolutePath());
				mainTable.invalidate();
				mainTable.revalidate();
				mainTable.repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * The method 'add' for action add a person to table
	 * @param event
	 */
	private static void add(ActionEvent event) {
		String firstName = JOptionPane.showInputDialog("Enter first name");
		String lastName = JOptionPane.showInputDialog("Enter last name");

		PERSON_SERVICE.addPerson(new Person(firstName, lastName));
		mainTable.invalidate();
		mainTable.revalidate();
		mainTable.repaint();
	}

	/**
	 * The method 'add' for action remove a person from table
	 * @param event
	 */
	private static void remove(ActionEvent event) {
		PERSON_SERVICE.removePerson(mainTable.getSelectedRow());
		mainTable.invalidate();
		mainTable.revalidate();
		mainTable.repaint();
	}
}
