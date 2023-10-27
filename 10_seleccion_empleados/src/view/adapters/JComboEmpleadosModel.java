package view.adapters;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Empleado;
import service.EmpleadosService;

public class JComboEmpleadosModel extends DefaultComboBoxModel<String> {
	List<String> departamentos;
	
	public JComboEmpleadosModel() {
		//para agregar la opción con una lista inmutable:
		//departamentos=new ArrayList<>(EmpleadosService().departamentos());
		//departamentos.add(0, "-Todos-");
		departamentos=new EmpleadosService().departamentos();
		departamentos.add(0, "-Todos-");//agregamos la opción "todos" al combobox, en la primera posición
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return departamentos.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return departamentos.get(index);
	}
	
	
}
