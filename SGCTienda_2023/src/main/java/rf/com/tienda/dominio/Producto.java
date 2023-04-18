package rf.com.tienda.dominio;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.web.jsf.FacesContextUtils;

import ch.qos.logback.core.joran.conditional.ElseAction;
import jakarta.persistence.*;
import rf.com.tienda.controller.CategoriaController;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.interfaces.daos.ICategoria;
import rf.com.tienda.services.CategoriaServicio;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	private String id_producto;
	@Column(nullable = false)
	private String pro_descripcion;
	@Column
	private String pro_desLarga;
	@Column(nullable = false, scale = 2)
	private double pro_precio;
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	private int pro_stock;
	@Column
	private LocalDate pro_fecRepos;
	@Column
	private LocalDate pro_fecActi;
	@Column
	private LocalDate pro_fecDesacti;
	@Column(nullable = false)
	private String pro_uniVenta;
	@Column(columnDefinition = "FLOAT DEFAULT 0", scale = 2)
	private double pro_cantXUniVenta;
	@Column
	private String pro_uniUltNivel;
	@Column
	private String pais;
	@Column
	private String pro_usoRecomendado;
	@Column(nullable = false)
	private int categoria;
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	private int pro_stkReservado;
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	private int pro_nStkAlto;
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	private int pro_nStkBajo;
	@Column
	private char pro_stat;
	
	public Producto() {

	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) throws DomainException {
		if (Validator.cumpleLongitud(id_producto, 5, 5) && Validator.isAlfanumeric(id_producto)) {
			this.id_producto = id_producto;
		}else {
			throw new DomainException("El codigo del producto no cumple con el rango o no es alfanumerico");
		}
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if (Validator.cumpleLongitud(pro_descripcion, 5, 100)) {
			this.pro_descripcion = pro_descripcion;
		}else {
			throw new DomainException("Longitud erronea (5 - 100)");
		}
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if (Validator.cumpleLongitud(pro_desLarga, 5, 2000)) {
			this.pro_desLarga = pro_desLarga;
		}else {
			throw new DomainException("Longitud erronea (5 - 2000)");
		}
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(double pro_precio) throws DomainException {
		if (Validator.cumpleRango(pro_precio, 0, 100)) {
			this.pro_precio = pro_precio;
		}else {
			throw new DomainException("Precio fuera de rango (0 - 100)");
		}
		
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}

	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if(Validator.esFechaValida(pro_fecRepos.toString()) && Validator.valDateMax(pro_fecRepos, LocalDate.EPOCH)) {
			this.pro_fecRepos = pro_fecRepos;
		}else {
			throw new DomainException("La fecha no es válida (xxxx-MM-dd) o es inferior a la fecha actual");
		}
		
	}

	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}

	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if (Validator.esFechaValida(pro_fecActi.toString()) && Validator.valDateMax(pro_fecActi, LocalDate.EPOCH)) {
			this.pro_fecActi = pro_fecActi;
		}else {
			throw new DomainException("La fecha no es válida (xxxx-MM-dd) o es inferior a la fecha actual");

		}
	}

	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	public void setPro_fecDesacti(LocalDate pro_fecDesacti) throws DomainException {
		if (getPro_fecActi() != null) {
			if (Validator.esFechaValida(pro_fecDesacti.toString()) && Validator.valDateMax(pro_fecDesacti, pro_fecActi))
				this.pro_fecDesacti = pro_fecDesacti;
			else {
				throw new DomainException("La fecha no es válida (xxxx-MM-dd) o es inferior a la fecha de activacion");
			}
		}else {
			if (Validator.esFechaValida(pro_fecDesacti.toString()) && Validator.valDateMax(pro_fecDesacti, LocalDate.EPOCH))
				this.pro_fecDesacti = pro_fecDesacti;
			else {
				throw new DomainException("La fecha no es válida (xxxx-MM-dd) o es inferior a la fecha actual");

			}
		}
		
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	public void setPro_uniVenta(String pro_uniVenta) throws DomainException {
		if(Validator.isAlfanumeric(pro_uniVenta) && Validator.cumpleLongitud(pro_uniVenta, 1, 10)) {
			this.pro_uniVenta = pro_uniVenta;
		}else {
			throw new DomainException("El precio de venta no cumple con la longitud (0 - 100)");
		}
	}

	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public String getId_pais() {
		return pais;
	}

	public void setId_pais(String pais) {
		this.pais = pais;
		
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	public int getId_categoria() {
		return categoria;
	}

	public void setId_categoria(int id_categoria) throws DomainException {
	
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public char getPro_stat() {
		return pro_stat;
	}

	public void setPro_stat(char pro_stat) throws DomainException {
		if (Validator.cumpleRango(pro_stat, 1, 1))
			this.pro_stat = pro_stat;
		else {
			throw new DomainException("El estado del producto es erroneo");
		}
	}

}
