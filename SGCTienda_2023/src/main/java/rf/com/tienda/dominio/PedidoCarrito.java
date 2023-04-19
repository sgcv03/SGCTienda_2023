package rf.com.tienda.dominio;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.Validator;

@Entity
@Table(name = "pedido_carrito")
public class PedidoCarrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	@Column(nullable = false)
	private int id_usuario;
	@Column(nullable = false)
	private String id_producto;
	@Column(nullable = false)
	private int car_cantidad;
	private double car_precio;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "dir_nombre", column = @Column(name = "envio_nombre")),
		@AttributeOverride(name = "dir_direccion", column = @Column(name = "envio_direccion")),
		@AttributeOverride(name = "dir_poblacion", column = @Column(name = "envio_poblacion")),
		@AttributeOverride(name = "dir_cPostal", column = @Column(name = "envio_cPostal")),
		@AttributeOverride(name = "dir_provincia", column = @Column(name = "envio_provincia")),
		@AttributeOverride(name = "dir_pais", column = @Column(name = "envio_pais")),
		@AttributeOverride(name = "dir_correoE", column = @Column(name = "envio_correoE"))
	})
	private Direccion car_envio;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "dir_nombre", column = @Column(name = "pago_nombre")),
		@AttributeOverride(name = "dir_direccion", column = @Column(name = "pago_direccion")),
		@AttributeOverride(name = "dir_poblacion", column = @Column(name = "pago_poblacion")),
		@AttributeOverride(name = "dir_cPostal", column = @Column(name = "pago_cPostal")),
		@AttributeOverride(name = "dir_provincia", column = @Column(name = "pago_provincia")),
		@AttributeOverride(name = "dir_pais", column = @Column(name = "pago_pais")),
		@AttributeOverride(name = "dir_correoE", column = @Column(name = "pago_correoE"))
	})
	private Direccion car_pago;
	@Column(columnDefinition = "VARCHAR(16)")
	private String car_tarjeta;
	private LocalDate car_fecCadud;
	private int car_ccv;
	private String car_nombre;
	private int car_stat;
	private List<String> car_fecCambio;
	
	public PedidoCarrito() {
		
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) throws DomainException {
		if (id_pedido>0) {
			this.id_pedido = id_pedido;
		}else {
			throw new DomainException("ID pedido no puede ser negativo o igual a 0");
		}
		
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) throws DomainException {
		if(id_usuario > 0) {
			this.id_usuario = id_usuario;
		}else {
			throw new DomainException("ID usuario no puede ser negativo o igual a 0");
		}
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) throws DomainException {
		if(Validator.cumpleLongitud(id_producto, 5, 5) && Validator.isAlfanumeric(id_producto)) {
			this.id_producto = id_producto;
		}else {
			throw new DomainException("ID producto no válido");
		}
	}

	public int getCar_cantidad() {
		return car_cantidad;
	}

	public void setCar_cantidad(int car_cantidad) throws DomainException {
		if(car_cantidad > 0) {
			this.car_cantidad = car_cantidad;
		}else {
			throw new DomainException("La cantidad debe ser mayor que 0 y debe haber existencias del producto");
		}
	}

	public double getCar_precio() {
		return car_precio;
	}

	public void setCar_precio(double car_precio) {
		this.car_precio = car_precio;
	}

	public Direccion getCar_envio() {
		return car_envio;
	}

	public void setCar_envio(Direccion car_envio) {
		this.car_envio = car_envio;
	}

	public Direccion getCar_pago() {
		return car_pago;
	}

	public void setCar_pago(Direccion car_pago) {
		this.car_pago = car_pago;
	}

	public String getCar_tarjeta() {
		return car_tarjeta;
	}

	public void setCar_tarjeta(String car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}

	public LocalDate getCar_fecCadud() {
		return car_fecCadud;
	}

	public void setCar_fecCadud(LocalDate car_fecCadud) throws DomainException {
		if (Validator.userFechaActual(car_fecCadud)) {
			this.car_fecCadud = car_fecCadud;
		}else {
			throw new DomainException("La fecha no puede ser mayor a la actual");
		}
	}

	public int getCar_ccv() {
		return car_ccv;
	}

	public void setCar_ccv(int car_ccv) {
		this.car_ccv = car_ccv;
	}

	public String getCar_nombre() {
		return car_nombre;
	}

	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}

	public int getCar_stat() {
		return car_stat;
	}

	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}

	public List<String> getCar_fecCambio() {
		return car_fecCambio;
	}

	public void setCar_fecCambio(List<String> car_fecCambio) {
		this.car_fecCambio = car_fecCambio;
	}
	
}
