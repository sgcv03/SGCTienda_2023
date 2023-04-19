package rf.com.tienda.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.Validator;

public class TestUsuario {
	

	private static Usuario usuario;
	
	@BeforeAll
	static void inicio() {
		usuario=new Usuario();
		
	}
	
	@Test
	void testUserNombre() throws DomainException{
		//Caso 1: Nombre de usuario correcto
		usuario.setUser_nombre("UsuarioCorrecto");
		assertEquals("UsuarioCorrecto", usuario.getUser_nombre());
		
		//Caso 2: Nombre de usuario con menos de 5 letras
		Assertions.assertThrows(DomainException.class,()-> {
			usuario.setUser_nombre("MAL");
		});
		
		//Caso 3: Nombre de usuario con mas de 100 letras
		Assertions.assertThrows(DomainException.class,()-> {
			usuario.setUser_nombre("ERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERRORERROR");
		});
	}
	

	

}
