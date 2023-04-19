package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.interfaces.daos.IUsuario;
import rf.com.tienda.repository.UsuarioRepository;

@Service
public class UsuarioServicio implements IUsuario{
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario buscarUsuario(Integer id) {
		return usuarioRepositorio.findById(id).get();
	}
	
	@Override
	public Usuario insertarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario, Integer id) {
		Usuario usuarioAux = usuarioRepositorio.findById(id).get();
		try {
			usuarioAux.setUser_nombre(usuario.getUser_nombre());
			usuarioAux.setUser_email(usuario.getUser_email());
			usuarioAux.setUser_pass(usuario.getUser_pass());
			usuarioAux.setUser_tipo(usuario.getUser_tipo());
			usuarioAux.setUser_dni(usuario.getUser_dni());
			usuarioAux.setUser_fecAlta(usuario.getUser_fecAlta());
			usuarioAux.setUser_fecConfirmacion(usuario.getUser_fecConfirmacion());
		} catch (DomainException e) {
			e.printStackTrace();
		}
		return usuarioRepositorio.save(usuarioAux);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		usuarioRepositorio.deleteById(id);
	}
	
	
}
