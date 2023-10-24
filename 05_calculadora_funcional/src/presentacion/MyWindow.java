package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		JButton sumar=new JButton("SUMAR");
		sumar.setBounds(75, 150, 150, 40);
		this.add(sumar);
		
		JButton multiplicar=new JButton("MULTIPLICAR");
		multiplicar.setBounds(300, 150, 150, 40);
		this.add(multiplicar);
		
		JLabel resultado=new JLabel();
		resultado.setBounds(175, 250, 150, 40);
		this.add(resultado);
		
		//ActionListener l=a->jt1.getText();
	}

}
