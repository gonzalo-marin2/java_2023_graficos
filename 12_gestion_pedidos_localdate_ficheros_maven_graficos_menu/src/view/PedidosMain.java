package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Pedido;
import service.PedidoService;

/*Aplicación de pedidos

Un pedido se caracteriza por: producto,fechaPedido,precio

1.- Alta pedido
2.- Pedido más reciente
3.- Pedidos por precio inferior
4.- Pedidos anteriores=>se solicita una cantidad de meses, y el programa nos muestra los pedidos anteriores a ese número de meses
5.- Salir*/

public class PedidosMain {
	
	static PedidoService pedidosService=new PedidoService();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			mostrarMenu();
			try {
				opcion=Integer.parseInt(sc.nextLine());//lee la opción elegida
				switch(opcion) { //evaluamos
				case 1:
					grabarPedido();
					break;
				case 2:
					buscarPedidoReciente();
					break;
				case 3:
					mostrarPedidos();
					break;
				case 4:
					mostrarPedidosAnteriores();
					break;
				case 5:
					System.out.println("---Adios---");
			}
		}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Debes elegir opción correcta");
			opcion=0; //para que vuelva a generar el bucle
		}
	}while(opcion!=5);
		
	}
	
	static void mostrarMenu(){
		System.out.println("1.- Agregar un nuevo pedido.");
		System.out.println("2.- Mostrar el pedido más reciente.");
		System.out.println("3.- Mostrar el pedido más barato.");
		System.out.println("4.- Mostrar pedidos anteriores.");
		System.out.println("5.- Salir.");
	}
	
	static void grabarPedido()  {
		Scanner sc=new Scanner(System.in);
		//para el parseado de fechas
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha;
		String producto;
		double precio;
		System.out.println("Introduce producto");
		producto=sc.nextLine();
		System.out.println("Introduce fecha (dia/mes/año)");	
		try {
			fecha=LocalDate.parse(sc.nextLine(),format);
			System.out.println("Introduce precio");
			precio=Double.parseDouble(sc.nextLine());		
			pedidosService.guardarPedido(producto, fecha, precio);
		}
		catch(DateTimeParseException ex) {
			ex.printStackTrace();
			System.out.println("La fecha no es válida y el pedido no se guardará");
		}
	}
	
	static void buscarPedidoReciente() {
		Pedido pedido=pedidosService.pedidoMasReciente();
		System.out.println("Producto: "+pedido.getProducto());
		System.out.println("Fecha: "+pedido.getFechaPedido());
		System.out.println("Precio: "+pedido.getPrecio());
	}
	static void mostrarPedidos() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce precio máximo");
		double precioMax=Double.parseDouble(sc.nextLine());
		List<Pedido> pedidos=pedidosService.pedidosPrecio(precioMax);
		for(Pedido p:pedidos) {
			System.out.println("Producto: "+p.getProducto());
			System.out.println("Fecha: "+p.getFechaPedido());
			System.out.println("Precio: "+p.getPrecio());
			//System.out.println("Pedidos "+p);//llama al toString() de pedidos
		}
	}
	
	static void mostrarPedidosAnteriores() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce meses");
		Integer meses=Integer.parseInt(sc.nextLine());
		List<Pedido> pedidos=pedidosService.anteriores(meses);
		for(Pedido p:pedidos) {
			System.out.println("Producto: "+p.getProducto());
			System.out.println("Fecha: "+p.getFechaPedido());
			System.out.println("Precio: "+p.getPrecio());
		}
	}
	
	

}
