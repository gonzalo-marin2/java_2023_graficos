package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Pedido;
import service.PedidoService;
import view.adapters.ListaPedidosModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		btSalir.setBounds(38, 217, 150, 30);
		contentPane.add(btSalir);
		
		JLabel lblNewLabel = new JLabel("Pedidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(277, 21, 128, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 57, 144, 147);
		contentPane.add(scrollPane);
		JList<Pedido> lstPedidos=new JList<>();
		scrollPane.setColumnHeaderView(lstPedidos);
		lstPedidos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Pedido pedido=lstPedidos.getSelectedValue();
				JOptionPane.showMessageDialog(JGestionPedidos.this, "Pedido seleccionado: "+pedido.getProducto()+
						" - "+pedido.getFechaPedido()+" - "+pedido.getPrecio());
			}
		});
		
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pedidos");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuNuevo = new JMenuItem("Nuevo");
		menuNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						JNuevo jNuevo=new JNuevo();
						jNuevo.setVisible(true);
						JGestionPedidos.this.dispose();
			}
		});
		mnNewMenu.add(menuNuevo);
		
		JMenuItem menuReciente = new JMenuItem("Reciente");
		menuReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JReciente reciente=new JReciente();
				reciente.setVisible(true);//se podría escribir así: new JReciente().setVisible(true)
				JGestionPedidos.this.dispose();
			}
		});
		mnNewMenu.add(menuReciente);
		
		JMenuItem menuTodos = new JMenuItem("Mostrar Todos");
		menuTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciamos modelo de datos y se lo asignamos al JList
				ListaPedidosModel model=new ListaPedidosModel();
				lstPedidos.setModel(model);//establecemos el modelo de datos
			}
		});
		mnNewMenu.add(menuTodos);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
