package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JReciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JReciente frame = new JReciente();
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
	public JReciente() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Pedido más reciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProducto.setBounds(28, 40, 120, 30);
		contentPane.add(lblProducto);
		
		JLabel lblFecha = new JLabel("Fecha de Pedido:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(28, 80, 120, 30);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(28, 122, 120, 30);
		contentPane.add(lblPrecio);
		
		JButton btSalir = new JButton("SALIR");
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.setBounds(142, 208, 150, 30);
		contentPane.add(btSalir);
		
		JLabel lbProducto = new JLabel("producto");
		lbProducto.setBounds(270, 50, 120, 30);
		contentPane.add(lbProducto);
		
		JLabel lbFecha = new JLabel("fecha");
		lbFecha.setBounds(270, 80, 120, 30);
		contentPane.add(lbFecha);
		
		JLabel lbPrecio = new JLabel("precio");
		lbPrecio.setBounds(270, 120, 120, 30);
		contentPane.add(lbPrecio);
	}

}
