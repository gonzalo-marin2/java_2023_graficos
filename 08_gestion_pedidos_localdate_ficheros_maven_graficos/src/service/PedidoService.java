package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Pedido;


public class PedidoService {
	String dir="c:\\temp\\pedidosPOO.txt";
	Path path;
	//en el constructor comprobamos si el fichero existe, sino, lo creamos
	public PedidoService() {
		File file=new File(dir);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		path=Path.of(dir);//variable para todos los métodos, así no hay que crearla siempre
	}
	
	private Stream<Pedido> getPedidos(){
		try{
			return Files.lines(path) //Stream<String>
					.map(s->new Pedido(s.split("[,-]")[0],
										LocalDate.parse(s.split(",")[1]),
										Double.parseDouble(s.split(",")[2]))); //Stream<Pedido>
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty(); //devuelve Steram vacío si hay excepción
		}
	}
		
	public void guardarPedido(String producto, LocalDate fechaPedido,double precio) {
		String linea=producto+","+fechaPedido+","+precio;
		try {
			Files.writeString(path, linea+System.lineSeparator(), StandardOpenOption.APPEND);//System.lineSeparator()mete un salto de línea
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Pedido pedidoMasReciente() {	
		/*try {
			return Files.lines(path)//devuelve un Stream<String>
			//necesitamos un Stream<Pedido>
			.map(s->new Pedido(s.split(",")[0],
									LocalDate.parse(s.split(",")[1]),
									Double.parseDouble(s.split(",")[2])))//devuelve Stream<Pedido>
			.max((a,b)->a.getFechaPedido().compareTo(b.getFechaPedido()))//Stream<Pedido>
			.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
		return getPedidos()
				.max((a,b)->a.getFechaPedido().compareTo(b.getFechaPedido()))//Stream<Pedido>
				.orElse(null);
				
	}
	
	public List<Pedido> pedidosPrecio(double precioMax) {
		/*try {
			return Files.lines(path)//devuelve un Stream<String>
			.map(s->new Pedido(s.split(",")[0],
								LocalDate.parse(s.split(",")[1]),
								Double.parseDouble(s.split(",")[2])))//Stream<Pedidos>
			.filter(p->p.getPrecio()<=precioMax)
			.toList();
		}
		catch (IOException e) {
			e.printStackTrace();
			return List.of();//retornar una lista vacía es mejor que null para evitar un NullPointerException
		}	*/
		return getPedidos()
				.filter(p->p.getPrecio()<=precioMax)
				.toList();	
	}
	
	public List<Pedido> anteriores(int meses){
		LocalDate referencia=LocalDate.now().minusMonths(meses);
		/*try {
			return Files.lines(path)//devuelve un Stream<String>
			.map(s->new Pedido(s.split(",")[0],
								LocalDate.parse(s.split(",")[1]),
								Double.parseDouble(s.split(",")[2])))//Stream<Pedidos>
			.filter(p->p.getFechaPedido().isBefore(referencia))//Filtramos por la fecha de referencia
			//tb podría ser así:.filter(p->p.getFechaPedido().isBefore(LocalDate.now().minusMonths(meses)))
			.toList();
			}
		catch(IOException ex) {
			ex.printStackTrace();
			return List.of();//retornar una lista vacía es mejor que null para evitar un NullPointerException
		}*/
		return getPedidos()
				.filter(p->p.getFechaPedido().isBefore(referencia))//Filtramos por la fecha de referencia
				.toList();
	}
	
	public List<Pedido> todos(){
		return getPedidos()//Stream<Pedido>
			.toList();//el stream anterior lo metemos en una lista
	}
	
	public void eliminarPedido(Pedido p) {
		//recuperar todos los pedidos menos el que quieres eliminar
		//transformar a objeto Stream
		//generar una lista
		//volcar la lista en el fichero
		List<String> pedidos=getPedidos()//Stream<Pedido>
		.filter(ped->!(ped.getProducto().equals(p.getProducto())&&
					ped.getFechaPedido().equals(p.getFechaPedido())&&
					ped.getPrecio()==p.getPrecio()))//Stream<Pedido> sin el pedido a eliminar
		.map(ped->ped.getProducto()+","+ped.getFechaPedido()+","+ped.getPrecio())//Stream<String> para poder escribirlo
		.collect(Collectors.toList());//generamos la lista
			try {
				Files.write(Path.of(dir), pedidos);//escribimos la nueva lista sin el pedido
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
	}
		
		//fecha actual
		//LocalDate referencia=LocalDate.now();
		//fecha del pedido
		//LocalDate fechaPedido=fechaHoy.minusMonths(meses);
		//De una vez
		//LocalDate referencia=LocalDate.now().minusMonths(meses);
		
}
