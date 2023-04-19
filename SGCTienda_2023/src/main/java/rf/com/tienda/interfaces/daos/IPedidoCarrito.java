package rf.com.tienda.interfaces.daos;

import java.util.List;

import rf.com.tienda.dominio.PedidoCarrito;

public interface IPedidoCarrito {
	public abstract List<PedidoCarrito> listarPedido();
	public abstract PedidoCarrito buascarPedido(int id_pedido);
	public abstract PedidoCarrito insertarPedido(PedidoCarrito pedido);
	public abstract PedidoCarrito actualizarPedido(PedidoCarrito pedido, int id_pedido);
	public abstract void eliminarPedido(int id_pedido);
}
