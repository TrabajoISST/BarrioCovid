package es.upm.dit.isst.barriocovid.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class PEDIDO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String comprador;
	private String vendedor;
	private String voluntario;
	private String zona;
	private int	idped;
	private int status;
	
	@Lob
	private byte[] productos;
	
	
	public PEDIDO() {
		
	}

	public byte[] getProductos() {
		return productos;
	}

	public void setProductos(byte[] productos) {
		this.productos = productos;
	}

	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getVoluntario() {
		return voluntario;
	}
	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}
	public int getId_pedido() {
		return idped;
	}
	public void setId_pedido(int idped) {
		this.idped = idped;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comprador == null) ? 0 : comprador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PEDIDO other = (PEDIDO) obj;
		if (comprador == null) {
			if (other.comprador != null)
				return false;
		} else if (!comprador.equals(other.comprador))
			return false;
		return true;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	

}