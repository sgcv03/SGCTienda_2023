package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.dominio.PedidoCarrito;
import rf.com.tienda.interfaces.daos.IPedidoCarrito;

@RestController
@RequestMapping(path = "/pedido_carrito")
public class PedidoCarritoController {
	
	@Autowired
	private IPedidoCarrito pedidoCarritoService;
	
	@GetMapping
	public List<PedidoCarrito> listarPedidos(){
		return pedidoCarritoService.listarPedido();
	}
	
	@GetMapping("/{id}")
	public PedidoCarrito buscarPedido(@PathVariable("id") Integer id) {
		return pedidoCarritoService.buascarPedido(id);
	}
	@PostMapping
	public PedidoCarrito insertarPedido(@RequestBody PedidoCarrito pedido) {
		return pedidoCarritoService.insertarPedido(pedido);
	}
	
	@PutMapping("/{id}")
	public PedidoCarrito actualizarPedido(@PathVariable("id") Integer id, @RequestBody PedidoCarrito pedido) {
		return pedidoCarritoService.actualizarPedido(pedido, id);
	}
	
	@DeleteMapping("/{id}")
	public void borrarPedido(@PathVariable("id") Integer id) {
		pedidoCarritoService.eliminarPedido(id);
	}
}
