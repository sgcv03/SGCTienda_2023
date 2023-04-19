package rf.com.tienda.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.interfaces.daos.ICategoria;
import rf.com.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicio implements ICategoria{

	@Autowired
	private CategoriaRepository repositorioCategoria;
	
	@Override
	public List<Categoria> listarCategorias() {
		return repositorioCategoria.findAll();
	}
	
	@Override
	public Categoria buscarCategoria(Integer id_categoria) {
		return repositorioCategoria.findById(id_categoria).get();
	}

	@Override
	public Categoria insertarCategoria(Categoria categoria) {
		return repositorioCategoria.save(categoria);
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria, Integer id_categoria){
		Categoria auxiliar = repositorioCategoria.findById(id_categoria).get();
		try {
			auxiliar.setCat_nombre(categoria.getCat_nombre());
			auxiliar.setCat_descripcion(categoria.getCat_descripcion());
		} catch (DomainException e) {
			e.printStackTrace();
		}

		return repositorioCategoria.save(auxiliar);
	}
	

	@Override
	public void eliminarCategoria(Integer id) {
		repositorioCategoria.deleteById(id);
		
	}
	
}
