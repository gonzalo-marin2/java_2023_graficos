package presentacion;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyWindow extends JFrame {
	
	public MyWindow() {
		super("Calculadora");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(25, 25, 500, 300);
		initComponents();
		setVisible(true);	
	}
	
	public void initComponents() {
		this.setLayout(null);
		JLabel jl1=new JLabel("Número 1");
		jl1.setBounds(75, 5, 150, 150);
		this.add(jl1);
		
		JLabel jl2=new JLabel("Número 2");
		jl2.setBounds(75, 35, 150, 150);
		this.add(jl2);
		
		JTextField jt1=new JTextField();
		jt1.setBounds(250, 65, 100, 25);
		this.add(jt1);
		
		JTextField jt2=new JTextField();
		jt2.setBounds(250, 100, 100, 25);
		this.add(jt2);
		
		JButton jbSumar=new JButton("SUMAR");
		jbSumar.setBounds(75, 150, 100, 40);
		this.add(jbSumar);
		
		JButton jbMultiplicar=new JButton("MULTIPLICAR");
		jbMultiplicar.setBounds(200, 150, 125, 40);
		this.add(jbMultiplicar);
		
		JButton jbSalir=new JButton("SALIR");
		jbSalir.setBounds(350, 150, 100, 40);
		this.add(jbSalir);
		
		
		JLabel jlResultado=new JLabel();
		jlResultado.setBounds(225, 200, 150, 40);
		this.add(jlResultado);
		
		// EVENTOS
		//ejemplo de captura de excepciones
		jbSumar.addActionListener(a->{
			try {
				jlResultado.setText(Integer.parseInt(jt1.getText())+Integer.parseInt(jt2.getText())+"");
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Debe ser un valor numérico");
			}
		});
		
		jbMultiplicar.addActionListener(a->{
			try {
				jlResultado.setText(Integer.parseInt(jt1.getText())*Integer.parseInt(jt2.getText())+"");
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Debe ser un valor numérico");
			}
		});
		
		//CERRAR LA VENTANA CON EL BOTÓN SALIR
		//usamos this pq hace referencia a la ventana, ya que hay que cerrar el propio objeto ventana
		//jbSalir.addActionListener(a->this.dispose());
		//queremos que muestre un mensaje de confirmación, cambiamos el anterior método
		jbSalir.addActionListener(a->{
		int resp=JOptionPane.showConfirmDialog(this, "¿Desea salir?","Alerta",JOptionPane.YES_NO_OPTION);//usamos this para cerrar la ventana
		if(resp==JOptionPane.YES_OPTION) {
			this.dispose();
			}
		});
		
		//queremos que cuando pinchemos en la caja, se borren los números
		//tenemos que crear una clase anónima
		jt1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {	
			}
			@Override
			public void focusGained(FocusEvent e) {
				//si nos queremos referir a algo de nuestra ventana, sería:
				//MyWindow.this.loquesea
				jt1.setText("");//borramos caja de texto
			}
		});
		
		jt2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {		
			}
			@Override
			public void focusGained(FocusEvent e) {
				jt2.setText("");//borramos caja de texto
			}
		});
		
		
	}
}
