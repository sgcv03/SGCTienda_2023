package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Producto;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.interfaces.daos.IProducto;
import rf.com.tienda.repository.ProductoRepository;

@Service
public class ProductoServicio implements IProducto{

	@Autowired
	private ProductoRepository repositorioProducto;
	
	@Override
	public List<Producto> listarProductos() {
		return repositorioProducto.findAll();
	}
	
	@Override
	public Producto buscarProducto(String id_producto) {
		return repositorioProducto.findById(id_producto).get();
	}

	@Override
	public Producto insertarProducto(Producto producto) {
		return repositorioProducto.save(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto, String id_producto) {
		Producto productoAuxiliar = repositorioProducto.findById(id_producto).get();
		
		try {
			productoAuxiliar.setPro_descripcion(producto.getPro_descripcion());
			productoAuxiliar.setPro_desLarga(producto.getPro_desLarga());
			productoAuxiliar.setPro_precio(producto.getPro_precio());
			productoAuxiliar.setPro_stock(producto.getPro_stock());
			productoAuxiliar.setPro_fecRepos(producto.getPro_fecRepos());
			productoAuxiliar.setPro_fecActi(producto.getPro_fecActi());
			productoAuxiliar.setPro_fecDesacti(producto.getPro_fecDesacti());
			productoAuxiliar.setPro_uniVenta(producto.getPro_uniVenta());
			productoAuxiliar.setPro_cantXUniVenta(producto.getPro_cantXUniVenta());
			productoAuxiliar.setPro_uniUltNivel(producto.getPro_uniUltNivel());
			productoAuxiliar.setId_pais(producto.getId_pais());
			productoAuxiliar.setPro_usoRecomendado(producto.getPro_usoRecomendado());
			productoAuxiliar.setId_categoria(producto.getId_categoria());
			productoAuxiliar.setPro_stkReservado(producto.getPro_stkReservado());
			productoAuxiliar.setPro_nStkAlto(producto.getPro_nStkAlto());
			productoAuxiliar.setPro_nStkBajo(producto.getPro_nStkBajo());
			productoAuxiliar.setPro_stat(producto.getPro_stat());
		} catch (DomainException e) {
			e.printStackTrace();
		}
		return repositorioProducto.save(productoAuxiliar);
	}

	@Override
	public void eliminarProducto(String id) {
		repositorioProducto.deleteById(id);
	}
	

}
