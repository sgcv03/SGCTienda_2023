package rf.com.tienda.interfaces.daos;

import java.util.List;

import rf.com.tienda.dominio.Categoria;

public interface ICategoria {
	
	public abstract List<Categoria> listarCategorias();
	public abstract Categoria buscarCategoria(Integer id);
	public abstract Categoria insertarCategoria(Categoria categoria);
	public abstract Categoria actualizarCategoria(Categoria categoria, Integer id);
	public abstract void eliminarCategoria(Integer id);
}
