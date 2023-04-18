package rf.com.tienda.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {
	
	public DomainException() {
		
	}
	

	public DomainException(String mensaje) {
		super(mensaje);
	}
	
	

}
