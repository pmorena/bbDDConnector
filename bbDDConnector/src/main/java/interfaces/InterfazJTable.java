package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.example.bbDDConnector.CRUD;

import modelo.Cliente.Cliente;

public class InterfazJTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreTf;
	private JTextField apeTf;
	private JTextField dniTf;
	private JTextField fechaTf;
	private JTable table;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazJTable frame = new InterfazJTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazJTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		CRUD conector = new CRUD();

		List<Cliente> clientes = conector.getClientes();

		contentPane.setVisible(true);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Nombre", "Apellidos", "Dni", "Fecha" }));

		DefaultTableModel tableModel = new DefaultTableModel();

		// Definir las columnas de la tabla
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Apellidos");
		tableModel.addColumn("DNI");
		tableModel.addColumn("Fecha");

		// Crear el JTable con el modelo
		JTable table_1 = new JTable(tableModel);

		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Crear un JScrollPane y añadir el JTable
				JScrollPane scrollPane = new JScrollPane(table_1);
				contentPane.add(scrollPane, BorderLayout.CENTER);

				for (Cliente c : clientes) {

					tableModel.addRow(new Object[] { c.getNombre(), c.getApellidos(), c.getDni(), c.getFecha() });

				}

				contentPane.setVisible(true);

			}
		});
		btnNewButton.setBounds(21, 25, 85, 21);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(148, 90, 45, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Apellidos: ");
		lblNewLabel_1.setBounds(148, 180, 57, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Dni: ");
		lblNewLabel_2.setBounds(335, 90, 45, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setBounds(335, 180, 45, 13);
		contentPane.add(lblNewLabel_3);

		nombreTf = new JTextField();
		nombreTf.setBounds(156, 139, 96, 19);
		contentPane.add(nombreTf);
		nombreTf.setColumns(10);

		apeTf = new JTextField();
		apeTf.setBounds(156, 222, 96, 19);
		contentPane.add(apeTf);
		apeTf.setColumns(10);

		dniTf = new JTextField();
		dniTf.setBounds(335, 139, 96, 19);
		contentPane.add(dniTf);
		dniTf.setColumns(10);

		fechaTf = new JTextField();
		fechaTf.setBounds(335, 222, 96, 19);
		contentPane.add(fechaTf);
		fechaTf.setColumns(10);

		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conector.insertCliente(nombreTf.getText(), apeTf.getText(), dniTf.getText(), fechaTf.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(198, 25, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conector.updateCLiente(nombreTf.getText(), apeTf.getText(), dniTf.getText(), fechaTf.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(374, 25, 85, 21);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conector.deleteFromClientes(dniTf.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(570, 25, 85, 21);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 314, 912, 396);
		contentPane.add(scrollPane);

		table_2 = new JTable();
		scrollPane.setViewportView(table_2);

	}
}
