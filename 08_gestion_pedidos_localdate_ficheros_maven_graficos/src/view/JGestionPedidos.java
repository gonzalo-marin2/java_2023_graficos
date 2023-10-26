package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidoService;
import view.adapters.ListaPedidosModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

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
		JList<Pedido> lstPedidos=new JList<>();
		lstPedidos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Pedido pedido=lstPedidos.getSelectedValue();
				JOptionPane.showMessageDialog(JGestionPedidos.this, "Pedido seleccionado: "+pedido.getProducto()+
						" - "+pedido.getFechaPedido()+" - "+pedido.getPrecio());
			}
		});
		setTitle("GESTIÓN DE PEDIDOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btNuevoPedido = new JButton("NUEVO PEDIDO");
		btNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JNuevo jNuevo=new JNuevo();
				jNuevo.setVisible(true);
				JGestionPedidos.this.dispose();
			}
		});
		btNuevoPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		btNuevoPedido.setBounds(25, 20, 150, 30);
		contentPane.add(btNuevoPedido);
		
		JButton btPedidoReciente = new JButton("PEDIDO RECIENTE");
		btPedidoReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JReciente reciente=new JReciente();
				reciente.setVisible(true);//se podría escribir así: new JReciente().setVisible(true)
				JGestionPedidos.this.dispose();
			}
		});
		btPedidoReciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btPedidoReciente.setBounds(25, 65, 150, 30);
		contentPane.add(btPedidoReciente);
		
		JButton btMostrarTodos = new JButton("MOSTRAR TODOS");
		btMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciamos modelo de datos y se lo asinamos al JList
				ListaPedidosModel model=new ListaPedidosModel();
				lstPedidos.setModel(model);//establecemos el modelo de datos
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("Pedidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(277, 21, 128, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 57, 144, 147);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(lstPedidos);
		
		JButton btnBorrar = new JButton("ELIMINAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedido=lstPedidos.getSelectedValue();
				PedidoService service=new PedidoService();
				service.eliminarPedido(pedido);
				//para actualizar la lista, volvemos a asignar el adaptador
				lstPedidos.setModel(new ListaPedidosModel());
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.setBounds(264, 215, 141, 35);
		contentPane.add(btnBorrar);
	}
}
