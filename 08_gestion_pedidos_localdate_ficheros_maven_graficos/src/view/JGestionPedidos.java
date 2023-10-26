package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JGestionPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JGestionPedidos frame = new JGestionPedidos();
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
	public JGestionPedidos() {
		setTitle("GESTIÓN DE PEDIDOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btNuevoPedido = new JButton("NUEVO PEDIDO");
		btNuevoPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		btNuevoPedido.setBounds(25, 20, 150, 30);
		contentPane.add(btNuevoPedido);
		
		JButton btPedidoReciente = new JButton("PEDIDO RECIENTE");
		btPedidoReciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btPedidoReciente.setBounds(25, 65, 150, 30);
		contentPane.add(btPedidoReciente);
		
		JButton btMostrarTodos = new JButton("TODOS");
		btMostrarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btMostrarTodos.setBounds(25, 105, 150, 30);
		contentPane.add(btMostrarTodos);
		
		JButton btSalir = new JButton("SALIR");
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp=JOptionPane.showConfirmDialog(JGestionPedidos.this, "¿Desea salir?","Cerrar sesión",JOptionPane.YES_NO_OPTION);//usamos this para cerrar la ventana
				if(resp==JOptionPane.YES_OPTION) {
					JGestionPedidos.this.dispose();
					}
				}
			}
		);
		btSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btSalir.setBounds(25, 208, 150, 30);
		contentPane.add(btSalir);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(255, 105, 160, 133);
		contentPane.add(textArea);
	}
}
