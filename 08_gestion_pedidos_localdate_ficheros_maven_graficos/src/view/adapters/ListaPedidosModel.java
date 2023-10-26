package view.adapters;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Pedido;
import service.PedidoService;

public class ListaPedidosModel extends DefaultListModel<Pedido> {
	List<Pedido> pedidos;
	
	public ListaPedidosModel() {
		pedidos=new PedidoService().todos();
	}

	@Override
	public int getSize() {
		return pedidos.size();
		
	}

	@Override
	public Pedido getElementAt(int index) {
		return pedidos.get(index);
	}
	 

}
