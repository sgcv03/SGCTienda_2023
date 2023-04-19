package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.interfaces.daos.ICategoria;
import rf.com.tienda.repository.CategoriaRepository;
import rf.com.tienda.services.CategoriaServicio;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

	@Autowired
	private ICategoria categoriaService;

	@GetMapping
	public List<Categoria> listarCategorias() {
		return categoriaService.listarCategorias();
	}
	
	@GetMapping("/{id}")
	public Categoria buscarCategoria(@PathVariable("id") Integer id) {
		return categoriaService.buscarCategoria(id);
	}

	@PostMapping
	public Categoria insertarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.insertarCategoria(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria actualizaCategoria(@PathVariable("id") Integer id, @RequestBody Categoria categoria){
		return categoriaService.actualizarCategoria(categoria, id);
	}
	
	@DeleteMapping("/{id}")
	public void eliminaCategoria(@PathVariable("id") Integer id )	{
		categoriaService.eliminarCategoria(id);
	}

}
