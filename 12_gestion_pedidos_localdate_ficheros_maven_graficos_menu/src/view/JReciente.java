package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.PedidoService;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JReciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


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
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp=JOptionPane.showConfirmDialog(JReciente.this, "¿Desea salir?","Cerrar sesión",JOptionPane.YES_NO_OPTION);//usamos this para cerrar la ventana
				if(resp==JOptionPane.YES_OPTION) {
					JReciente.this.dispose();
				}
			}
		});
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.setBounds(142, 208, 150, 30);
		contentPane.add(btSalir);
		
		JLabel lbProducto = new JLabel();
		lbProducto.setBounds(270, 41, 120, 30);
		contentPane.add(lbProducto);
		
		JLabel lbFecha = new JLabel();
		lbFecha.setBounds(270, 80, 120, 30);
		contentPane.add(lbFecha);
		
		JLabel lbPrecio = new JLabel();
		lbPrecio.setBounds(270, 120, 120, 30);
		contentPane.add(lbPrecio);

		//cargar pedido más reciente al cargarse la propia ventana
		var service=new PedidoService();
		var pedido=service.pedidoMasReciente();
		lbProducto.setText(pedido.getProducto());
		lbFecha.setText(pedido.getFechaPedido().toString());
		lbPrecio.setText(pedido.getPrecio()+"");
	}

}
