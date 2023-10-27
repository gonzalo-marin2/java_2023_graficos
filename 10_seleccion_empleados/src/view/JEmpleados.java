package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.JComboEmpleadosModel;
import view.adapters.TablaEmpleadosModel;
import javax.swing.DefaultComboBoxModel;

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
		scrollPane.setBounds(23, 123, 382, 75);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		//tbEmpleados
		
		JLabel lblNewLabel = new JLabel("Seleccione Departamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(137, 11, 165, 30);
		contentPane.add(lblNewLabel);
		
		JButton btEmpleados = new JButton("VER EMPLEADOS");
		btEmpleados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbEmpleados.setModel(new TablaEmpleadosModel());//aplicamos a la tabla el modelo de tabla
			}
		});
		btEmpleados.setBounds(23, 220, 165, 30);
		contentPane.add(btEmpleados);
		
		JButton btSalir = new JButton("SALIR");
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JEmpleados.this.dispose();
			}
		});
		btSalir.setBounds(316, 220, 89, 30);
		contentPane.add(btSalir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 52, 175, 35);
		contentPane.add(scrollPane_1);
		
		JComboBox cbDepartamento = new JComboBox();
		cbDepartamento.setModel(new JComboEmpleadosModel());
		cbDepartamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbDepartamento.getSelectedIndex()==0) {
					tbEmpleados.setModel(new TablaEmpleadosModel());
				}else {
					tbEmpleados.setModel(new TablaEmpleadosModel(cbDepartamento.getSelectedItem().toString()));
				}
				
			}
		});
			
		scrollPane_1.setViewportView(cbDepartamento);
		
		JLabel lblNewLabel_1 = new JLabel("EMPLEADOS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(23, 89, 74, 30);
		contentPane.add(lblNewLabel_1);
	}
}
