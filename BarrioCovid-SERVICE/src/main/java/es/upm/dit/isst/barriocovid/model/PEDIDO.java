package es.upm.dit.isst.barriocovid.model;

import java.io.Serializable;
import java.util.Arrays;

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
	private int	idped;
	private int status;
	@Lob
	private String[] productos;
	
	public PEDIDO() {
		
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
	public String[] getProductos() {
		return productos;
	}
	
	public void setProductos(String[] productos) {
		this.productos = productos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comprador == null) ? 0 : comprador.hashCode());
		result = prime * result + idped;
		result = prime * result + Arrays.hashCode(productos);
		result = prime * result + status;
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
		result = prime * result + ((voluntario == null) ? 0 : voluntario.hashCode());
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
		if (idped != other.idped)
			return false;
		if (!Arrays.equals(productos, other.productos))
			return false;
		if (status != other.status)
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		if (voluntario == null) {
			if (other.voluntario != null)
				return false;
		} else if (!voluntario.equals(other.voluntario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PEDIDO [comprador=" + comprador + ", vendedor=" + vendedor + ", voluntario=" + voluntario + ", idped="
				+ idped + ", status=" + status + ", productos=" + Arrays.toString(productos) + "]";
	}

}

	

