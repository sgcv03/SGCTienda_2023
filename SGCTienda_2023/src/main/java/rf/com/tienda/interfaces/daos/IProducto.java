package rf.com.tienda.interfaces.daos;

import java.util.List;

import rf.com.tienda.dominio.Producto;

public interface IProducto {
	
	public abstract List<Producto> listarProductos();
	public abstract Producto buscarProducto(String id_producto);
	public abstract Producto insertarProducto(Producto producto);
	public abstract Producto actualizarProducto(Producto producto, String id_producto);
	public abstract void eliminarProducto(String id_producto);
	
}
