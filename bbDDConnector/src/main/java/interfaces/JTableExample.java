package interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
	public static void main(String[] args) {
		// Crear el frame
		JFrame frame = new JFrame("Ejemplo de JTable");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(507, 595);

		// Crear el modelo de la tabla (DefaultTableModel)
		DefaultTableModel tableModel = new DefaultTableModel();

		// Definir las columnas de la tabla
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Apellidos");
		tableModel.addColumn("DNI");

		// Crear el JTable con el modelo
		JTable table = new JTable(tableModel);

		// Crear un JScrollPane y añadir el JTable
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Crear un panel para añadir nuevos datos
		JPanel panel = new JPanel();
		JTextField nameField = new JTextField(10);
		JTextField surnameField = new JTextField(10);
		JTextField dniField = new JTextField(10);

		// Botón para añadir un nuevo registro
		JButton addButton = new JButton("Añadir");
		panel.add(new JLabel("Nombre:"));
		panel.add(nameField);
		panel.add(new JLabel("Apellidos:"));
		panel.add(surnameField);
		panel.add(new JLabel("DNI:"));
		panel.add(dniField);
		panel.add(addButton);

		// Añadir el panel al frame
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		// Acción del botón para añadir datos a la tabla
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = nameField.getText();
				String apellidos = surnameField.getText();
				String dni = dniField.getText();

				// Añadir una nueva fila al modelo de la tabla
				tableModel.addRow(new Object[] { nombre, apellidos, dni });

				// Limpiar los campos de texto
				nameField.setText("");
				surnameField.setText("");
				dniField.setText("");
			}
		});

		// Mostrar el frame
		frame.setVisible(true);
	}
}
