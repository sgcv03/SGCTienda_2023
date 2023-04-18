package rf.com.tienda.interfaces.daos;

import java.util.List;

import rf.com.tienda.dominio.Usuario;

public interface IUsuario {
	
	public abstract List<Usuario> listarUsuarios();
	public abstract Usuario insertarUsuario(Usuario usuario);
	public abstract Usuario actualizarUsuario(Usuario usuario, Integer id);
	public abstract void eliminarUsuario(Integer id);
}
