package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtNumero1;
	private JTextField jtNumero2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {//habrá que cambiar el main en los próximos proyectos, hay que tenerlo en cuenta
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 50, 89, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 80, 89, 20);
		contentPane.add(lblNewLabel_1);
		
		jtNumero1 = new JTextField();
		jtNumero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtNumero1.setBounds(200, 50, 86, 20);
		contentPane.add(jtNumero1);
		jtNumero1.setColumns(10);
		
		jtNumero2 = new JTextField();
		jtNumero2.setText("");
		jtNumero2.setBounds(200, 82, 86, 20);
		contentPane.add(jtNumero2);
		jtNumero2.setColumns(10);
		
		JLabel jlResultado = new JLabel("");
		JButton jbSumar = new JButton("SUMAR");
		jbSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlResultado.setText(Integer.parseInt(jtNumero1.getText())+Integer.parseInt(jtNumero2.getText())+"");
			}
		});
		jbSumar.setBounds(40, 145, 89, 23);
		contentPane.add(jbSumar);
		
		JButton jbMultiplicar = new JButton("MULTIPLICAR");
		jbMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlResultado.setText(Integer.parseInt(jtNumero1.getText())*Integer.parseInt(jtNumero2.getText())+"");
			}
		});
		jbMultiplicar.setBounds(170, 145, 105, 23);
		contentPane.add(jbMultiplicar);
		
		JButton jbSalir = new JButton("SALIR");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp=JOptionPane.showConfirmDialog(JCalculadora.this, "¿Desea salir?","Alerta",JOptionPane.YES_NO_OPTION);//usamos this para cerrar la ventana
				if(resp==JOptionPane.YES_OPTION) {
					JCalculadora.this.dispose();
					}
				}
		});
		jbSalir.setBounds(312, 145, 89, 23);
		contentPane.add(jbSalir);
		
		
		jlResultado.setBounds(196, 207, 60, 25);
		contentPane.add(jlResultado);
	}
}
