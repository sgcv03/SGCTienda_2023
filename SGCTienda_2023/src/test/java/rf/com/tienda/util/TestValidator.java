package rf.com.tienda.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;


public class TestValidator {
	
	//*********************************************************
	@Test
	public void testAlfaNumericos() {
		assertTrue(Validator.isAlfanumeric("TextoAlfanumerico123"));
		assertFalse(Validator.isAlfanumeric("Texto con espacios"));
		assertFalse(Validator.isAlfanumeric("Texto#ConCaracteres!Especiales"));
	}
	
	
	//*********************************************************
	
	@Test
	public void testNumeroTelefono() {
		//Numero de telefono con 10 digitos
		assertTrue(Validator.cumplePhoneNumber("1234567890"));
		//Numero de telefono con 15 digitos
		assertTrue(Validator.cumplePhoneNumber("123456789012345"));
		//Numero de telefono con 20 digitos
		assertTrue(Validator.cumplePhoneNumber("12345678901234567890"));
		//Numero de telefono invalido con menos de 10 digitos
		assertFalse(Validator.cumplePhoneNumber("123456789"));
		//Numero de telefono invalido con mas de 20 digitos
		assertFalse(Validator.cumplePhoneNumber("123456789012345678901"));
		//Numero de telefono invalido con caracteres no numericos
		assertFalse(Validator.cumplePhoneNumber("1928s34"));
	}
	
	//*********************************************************
	@Test
	public void testEmailValido() {
		//Dirreciones de correo válidas
		assertTrue(Validator.isEmailValido("sergiogarcia@neoris.com"));
		assertTrue(Validator.isEmailValido("user@gmail.co.uk"));
		assertTrue(Validator.isEmailValido("user.name12@gmail.es"));
		assertTrue(Validator.isEmailValido("yo@localhost"));
		//Dirreciones de correo invalidos
		assertFalse(Validator.isEmailValido(".usuario@ejemplo.com"));
		assertFalse(Validator.isEmailValido(".@example"));
		assertFalse(Validator.isEmailValido("tusabe@"));
		assertFalse(Validator.isEmailValido("user@domain_.com"));
		assertFalse(Validator.isEmailValido("user@_domain.com"));
	}
	
	//*********************************************************

	@Test
	public void testDniValido() {
		//DNI correctos
		assertTrue(Validator.cumpleDNI("12.345.678-L"));
		assertTrue(Validator.cumpleDNI("12.111.111-K"));

		//DNI invalidos
		assertFalse(Validator.cumpleDNI("12345678-P"));
		assertFalse(Validator.cumpleDNI("12.111.111-Ñ"));
		assertFalse(Validator.cumpleDNI("12345678T"));
		assertFalse(Validator.cumpleDNI("123"));
		assertFalse(Validator.cumpleDNI("12345678-o"));		
		assertFalse(Validator.cumpleDNI("12.345.678"));
		assertFalse(Validator.cumpleDNI("12.345.678-"));

	}
	
	//*********************************************************
	
	@Test
	public void testCumpleRango() {
		//Valores correctos
		assertTrue(Validator.cumpleRango(10, 9,20));
		assertTrue(Validator.cumpleRango(0, -100,100));
		assertTrue(Validator.cumpleRango(3.14, 0,50));
		//Valores incorrecto
		assertFalse(Validator.cumpleRango(15, 1, 10));
		assertFalse(Validator.cumpleRango(-200, -100, 100));
		assertFalse(Validator.cumpleRango(5.5, -20, 5));

	}
	
	//*********************************************************

	@Test
	public void testCumpleLongitudMin() {
		//Valores correctos
		assertTrue(Validator.cumpleLongitudMin("Hola a todos", 5));
		assertTrue(Validator.cumpleLongitudMin("Hola a todos", 12));
		
		//Valores incorrectoa
		assertFalse(Validator.cumpleLongitudMin("Hola a todos", 30));
		assertFalse(Validator.cumpleLongitudMin("", 1));
		assertFalse(Validator.cumpleLongitudMin("       ", 10));

	}
	
	@Test
	public void testCumpleLongitudMax() {
		//Valores correctos
		assertTrue(Validator.cumpleLongitudMax("Ay", 5));
		assertTrue(Validator.cumpleLongitudMax("", 0));
		
		//Valores incorrectoa
		assertFalse(Validator.cumpleLongitudMax("Hola a todos", 5));
		assertFalse(Validator.cumpleLongitudMax("", -3));
		assertFalse(Validator.cumpleLongitudMax("        ", 4));

	}
	
	@Test
	public void testCumpleLongitud() {
		//Valores correctos
		assertTrue(Validator.cumpleLongitud("Hola a todos", 5, 30));
		assertTrue(Validator.cumpleLongitud("", 0, 0));
		
		//Valores incorrectos
		assertFalse(Validator.cumpleLongitud("Ay", 4, 15));
		assertFalse(Validator.cumpleLongitud("", -3, -1));
		assertFalse(Validator.cumpleLongitud("        ", 20, 50));
	}
	
	//*********************************************************

	@Test
	public void testValDateMin() {
		//Valor correctos
		assertTrue(Validator.valDateMin(LocalDate.parse("2022-04-11"), LocalDate.parse("2003-03-17")));
		
		//Valores incorrectos
		assertFalse(Validator.valDateMin(LocalDate.parse("2003-03-17"), LocalDate.parse("2022-04-11")));
	}
	
	@Test
	public void testValDateMax() {
		//Valor correctos
		assertTrue(Validator.valDateMax(LocalDate.parse("2022-04-11"), LocalDate.parse("2050-03-17")));

		//Valores incorrectos
		assertFalse(Validator.valDateMax(LocalDate.parse("2022-04-11"), LocalDate.parse("2003-03-17")));
	}
	

	@Test
	public void testFechaValida() {
		//Valor correctos
		assertTrue(Validator.esFechaValida("2022-04-11"));
		assertTrue(Validator.esFechaValida("2022-04-05"));

		//Valores incorrectos
		assertFalse(Validator.esFechaValida("01-01-2000"));
		assertFalse(Validator.esFechaValida("2022/03/15"));
		assertFalse(Validator.esFechaValida("2022-02-45"));
		assertFalse(Validator.esFechaValida("2022-13-45"));
		assertFalse(Validator.esFechaValida("20225-02-11"));

	}
	
	//*********************************************************

	@Test
	public void testPasswordValida() {
		//Valor correctos
		assertTrue(Validator.esPasswordValida("Passw0rd#"));

		//Valores incorrectos
		assertFalse(Validator.esPasswordValida("Passwrod!"));
		assertFalse(Validator.esPasswordValida("123456789!"));
		assertFalse(Validator.esPasswordValida("Contra12345"));
		assertFalse(Validator.esPasswordValida("PasswordPassword1234567"));

	}

}
