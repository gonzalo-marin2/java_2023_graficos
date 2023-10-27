package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaEmpleadosModel;
import java.awt.Font;

public class JEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEmpleados frame = new JEmpleados();
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
	public JEmpleados() {
		setTitle("Tabla de empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 64, 382, 98);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		
		JLabel lblNewLabel = new JLabel("Tabla de empleados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(152, 23, 128, 30);
		contentPane.add(lblNewLabel);
		
		JButton btEmpleados = new JButton("Ver empleados");
		btEmpleados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbEmpleados.setModel(new TablaEmpleadosModel());//aplicamos a la tabla el modelo de tabla
			}
		});
		btEmpleados.setBounds(152, 180, 128, 30);
		contentPane.add(btEmpleados);
		
		JButton btSalir = new JButton("SALIR");
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JEmpleados.this.dispose();
			}
		});
		btSalir.setBounds(316, 227, 89, 23);
		contentPane.add(btSalir);
	}
}
