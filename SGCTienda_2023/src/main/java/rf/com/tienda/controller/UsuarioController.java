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

import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.interfaces.daos.IUsuario;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuario usuarioService;
	
	@GetMapping
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarUsuario(@PathVariable("id") Integer id) {
		return usuarioService.buscarUsuario(id);
	}
	
	@PostMapping
	public Usuario insertarProducto(@RequestBody Usuario usuario) {
		return usuarioService.insertarUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario actualizarProducto(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
		return usuarioService.actualizarUsuario(usuario, id);
	}
	
	@DeleteMapping("/{id}")
	public void borrarProducto(@PathVariable("id") Integer id) {
		usuarioService.eliminarUsuario(id);
	}
	
	
}
