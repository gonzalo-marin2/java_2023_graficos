package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*Aplicación de pedidos

Un pedido se caracteriza por: producto,fechaPedido,precio

1.- Alta pedido
2.- Pedido más reciente
3.- Pedidos por precio inferior
4.- Pedidos anteriores=>se solicita una cantidad de meses, y el programa nos muestra los pedidos anteriores a ese número de meses
5.- Salir*/

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pedido {
	private String producto;
	private LocalDate fechaPedido;
	private double precio;
}
	

