package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {
		private String nombre;
		private String email;
		private double salario;
		private String departamento;
}
