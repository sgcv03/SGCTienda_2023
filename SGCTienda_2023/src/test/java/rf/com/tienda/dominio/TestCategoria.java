package rf.com.tienda.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rf.com.tienda.exception.DomainException;


public class TestCategoria {
	private static final String NOMBRE_VALIDO="Deportes";
	private static final String NOMBRE_ERROR="1234565878127878798738172817238782179827871873289719827381783798178237198732897128931987289739812739872837198273987128937189278317987329817983";
	private static final String NOMBRE_ERROR2="MAL";
	private static final String DESC_VALIDA = "Esto es una descripcion de la categoria valida";
	private static final String DESC_ERROR = "ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200ValorConLongitudMayora200";


	private static Categoria categoria;
	
	@BeforeAll
	static void inicio() {
		categoria=new Categoria();
		
	}
	
	
	@Test
	void setCat_nombreTest() throws DomainException {
		//Caso prueba 1: Valor válido
		categoria.setCat_nombre(NOMBRE_VALIDO);
		assertEquals(NOMBRE_VALIDO, categoria.getCat_nombre());
		
		//Caso prueba 2: Valor mayor de 50 caracteres
		Assertions.assertThrows(DomainException.class,()-> {
			categoria.setCat_nombre(NOMBRE_ERROR);
		});
		
		//Caso prueba 3: Valor con longitud menor a 5
		Assertions.assertThrows(DomainException.class,()-> {
			categoria.setCat_nombre(NOMBRE_ERROR2);
		});
	}
	
	@Test
	void setCat_descripcionTest() throws DomainException {
		//Caso prueba 1: Valor válido
		categoria.setCat_descripcion(DESC_VALIDA);
		assertEquals(DESC_VALIDA, categoria.getCat_descripcion());
		
		//Caso prueba 2: Valor con longitud mayor a 200
		Assertions.assertThrows(DomainException.class,()-> {
			categoria.setCat_descripcion(DESC_ERROR);
		});
		
	}

}
