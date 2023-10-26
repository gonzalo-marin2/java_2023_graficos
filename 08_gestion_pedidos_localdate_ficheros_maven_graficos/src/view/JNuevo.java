package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtProducto;
	private JTextField jtFechaPedido;
	private JTextField jtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JNuevo frame = new JNuevo();
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
	public JNuevo() {
		setTitle("Guardar nuevo pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProducto.setBounds(40, 30, 120, 30);
		contentPane.add(lblProducto);
		
		JLabel lblFecha = new JLabel("Fecha de Pedido:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(40, 70, 120, 30);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(40, 112, 120, 30);
		contentPane.add(lblPrecio);
		
		jtProducto = new JTextField();
		jtProducto.setBounds(210, 35, 120, 30);
		contentPane.add(jtProducto);
		jtProducto.setColumns(10);
		
		jtFechaPedido = new JTextField();
		jtFechaPedido.setText("YYYY-MM-DD");
		jtFechaPedido.setColumns(10);
		jtFechaPedido.setBounds(210, 71, 120, 30);
		contentPane.add(jtFechaPedido);
		
		jtPrecio = new JTextField();
		jtPrecio.setColumns(10);
		jtPrecio.setBounds(210, 112, 120, 30);
		contentPane.add(jtPrecio);
		
		JButton btGuardar = new JButton("GUARDAR");
		btGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btGuardar.setBounds(70, 190, 120, 30);
		contentPane.add(btGuardar);
		
		JButton btSalir = new JButton("SALIR");
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.setBounds(269, 190, 120, 30);
		contentPane.add(btSalir);
	}

}
