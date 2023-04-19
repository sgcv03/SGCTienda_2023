package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.PedidoCarrito;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.interfaces.daos.IPedidoCarrito;
import rf.com.tienda.repository.PedidoCarritoRepository;

@Service
public class PedidoCarritoServicio implements IPedidoCarrito{

	@Autowired
	private PedidoCarritoRepository pedidoCarritoRepository;
	
	@Override
	public List<PedidoCarrito> listarPedido() {
		return pedidoCarritoRepository.findAll();
	}

	@Override
	public PedidoCarrito buascarPedido(int id_pedido) {
		return pedidoCarritoRepository.findById(id_pedido).get();
	}

	@Override
	public PedidoCarrito insertarPedido(PedidoCarrito pedido) {
		return pedidoCarritoRepository.save(pedido);
	}

	@Override
	public PedidoCarrito actualizarPedido(PedidoCarrito pedido, int id_pedido) {
		PedidoCarrito pedidoCarritoAux = pedidoCarritoRepository.findById(id_pedido).get();
		try {
			pedidoCarritoAux.setId_usuario(pedido.getId_usuario());
			pedidoCarritoAux.setId_producto(pedido.getId_producto());
			pedidoCarritoAux.setCar_cantidad(pedido.getCar_cantidad());
			pedidoCarritoAux.setCar_precio(pedido.getCar_precio());
			pedidoCarritoAux.setCar_envio(pedido.getCar_envio());
			pedidoCarritoAux.setCar_pago(pedido.getCar_pago());
			pedidoCarritoAux.setCar_tarjeta(pedido.getCar_tarjeta());
			pedidoCarritoAux.setCar_fecCadud(pedido.getCar_fecCadud());
			pedidoCarritoAux.setCar_ccv(pedido.getCar_ccv());
			pedidoCarritoAux.setCar_nombre(pedido.getCar_nombre());
			pedidoCarritoAux.setCar_stat(pedido.getCar_stat());
			pedidoCarritoAux.setCar_fecCambio(pedido.getCar_fecCambio());
		} catch (DomainException e) {
			e.printStackTrace();
		}
		
		return pedidoCarritoRepository.save(pedidoCarritoAux);
	}

	@Override
	public void eliminarPedido(int id_pedido) {
		pedidoCarritoRepository.deleteById(id_pedido);
		
	}

	
}
