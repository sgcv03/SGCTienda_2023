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

import rf.com.tienda.dominio.Producto;
import rf.com.tienda.interfaces.daos.IProducto;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {
	
	@Autowired
	private IProducto productoService;
	
	@GetMapping
	public List<Producto> listarProductos(){
		return productoService.listarProductos();
	}
	
	@GetMapping("/{id}")
	public Producto buscarProducto(@PathVariable("id") String id_producto) {
		return productoService.buscarProducto(id_producto);
	}
	
	@PostMapping
	public Producto insertarProducto(@RequestBody Producto producto) {
		return productoService.insertarProducto(producto);
	}
	
	@PutMapping("/{id}")
	public Producto actualizarProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
		return productoService.actualizarProducto(producto, id);
	}
	
	@DeleteMapping("/{id}")
	public void borrarProducto(@PathVariable("id") String id) {
		productoService.eliminarProducto(id);
	}
	
}
