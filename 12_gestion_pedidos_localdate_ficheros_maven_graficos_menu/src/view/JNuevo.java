package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.PedidoService;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtProducto;
	private JTextField jtFechaPedido;
	private JTextField jtPrecio;

	/**
	 * Launch the application.
	 */


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
		
		//cambiarlos por label
		jtProducto = new JTextField();
		//para seleccionar el contenido de la caja cuando nos pongamos en ella 
		jtProducto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtProducto.selectAll();
			}
		});
		jtProducto.setBounds(210, 35, 120, 30);
		contentPane.add(jtProducto);
		jtProducto.setColumns(10);
		
		jtFechaPedido = new JTextField();
		jtFechaPedido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtFechaPedido.selectAll();
			}
		});
		jtFechaPedido.setText("YYYY-MM-DD");
		jtFechaPedido.setColumns(10);
		jtFechaPedido.setBounds(210, 71, 120, 30);
		contentPane.add(jtFechaPedido);
		
		jtPrecio = new JTextField();
		jtPrecio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtPrecio.selectAll();
			}
		});
		jtPrecio.setColumns(10);
		jtPrecio.setBounds(210, 112, 120, 30);
		contentPane.add(jtPrecio);
		
		JButton btGuardar = new JButton("GUARDAR");
		btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tb podría ser var service=new PedidoService();que java deduzca después qué tipo de dato es
				PedidoService service=new PedidoService();
				service.guardarPedido(jtProducto.getText(),
						LocalDate.parse(jtFechaPedido.getText()),
						Double.parseDouble(jtPrecio.getText()));
				
				//vamos a llevar el cursor al primer cuadro
				jtProducto.requestFocus();
			}
		});
		btGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btGuardar.setBounds(70, 190, 120, 30);
		contentPane.add(btGuardar);
		
		JButton btSalir = new JButton("SALIR");
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp=JOptionPane.showConfirmDialog(JNuevo.this, "¿Desea salir?","Cerrar sesión",JOptionPane.YES_NO_OPTION);//usamos this para cerrar la ventana
				if(resp==JOptionPane.YES_OPTION) {
					JNuevo.this.dispose();//valdría con esta instrucción
				}
			}
		});
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.setBounds(269, 190, 120, 30);
		contentPane.add(btSalir);
		
	}

}
