package presentacion;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyWindow extends JFrame {
	//constructor sin parámetros que va a dar título a la ventana, le va a dar posición y le va a hacer visible
	public MyWindow() {
		//título
		super("Primera ventana");//llamamos al constructor de la clase JFrame
		//comportamiento del botón de cierre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//cierra la ventana y detiene la aplicación
		//tamaño y posición
		this.setBounds(10, 10, 500, 300);
		//llamar a un método que carga controles en ventana
		initComponents();
		
		
		//hacemos visible
		this.setVisible(true);
		
	}
	
	private void initComponents() {
		//hay que anular el gestor de organización
		this.setLayout(null);
		JButton jb1=new JButton("Pulsar aquí");
		JLabel jl1=new JLabel();
		jb1.setBounds(100, 50, 150, 40);
		jl1.setBounds(120, 120, 300, 30);
		//añadir control al contenedor para que se vea
		this.add(jb1);
		this.add(jl1);
		
		//***eventos***
		//implementación de la interfaz funcional
		ActionListener l=a->jl1.setText("Se ha pulsado el botón");
		//asociamos objeto manejador al origen del evento
		jb1.addActionListener(l);
		//en un paso:jb1.addActionListener(a->jl1.setText("Se ha pulsado el botón"));
		
	}
	
	
}
