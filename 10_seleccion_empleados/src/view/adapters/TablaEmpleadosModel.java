package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Empleado;
import service.EmpleadosService;

public class TablaEmpleadosModel extends AbstractTableModel {
	List<Empleado> empleados;
	final int COLS=3;//DECLARAMOS UNA CONSTANTE PARA DEFINIR EL NÚMERO DE COLUMNAS
	public TablaEmpleadosModel() {
		empleados=new EmpleadosService().empleados();//para mostrar todos los empleados
	}
	
	public TablaEmpleadosModel(String dep) {
		empleados=new EmpleadosService().empleadosPorDepartamento(dep);//para mostrar los empleados por departamento
	}
	@Override
	public int getRowCount() {
		return empleados.size();//tantas filas como empleados haya
	}
	@Override
	public int getColumnCount() {
		return COLS;
	}
	@Override
	public String getColumnName(int column) {
		/*PARA JAVA 17 Y SS
		return switch(column) {
		case 0->"Nombre";
		case 1->"Email";
		case 2->"Salario";
		default->"Indeterminada";
		};*/
		
		switch(column) {
		case 0:
			return "Nombre";
		case 1:
			return "Email";
		case 2:
			return "Salario";
		default:
			return "Indeterminada";
		}
	}
	@Override
	public Object getValueAt(int row, int column) {//según el número de la fila, sacamos los diferentes valores
		switch(column) {
			case 0:
				return empleados.get(row).getNombre();
			case 1:
				return empleados.get(row).getEmail();
			case 2:
				return empleados.get(row).getSalario();
			default:
				return null;
		}
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {//la interrogación de class<?> significa que acepta cualquier tipo de dato
		switch(columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return Double.class;
			default:
				return null;
		}
		
	}
	
	
}
