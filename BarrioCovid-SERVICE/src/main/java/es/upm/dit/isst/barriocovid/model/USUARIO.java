package es.upm.dit.isst.barriocovid.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class USUARIO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String password;
	private String zona;
	private String direccion;
	private String	rol;
	private int pedidosRealizados;
	private int pedidosEntregados;
	private int idUsuario;
	
	public USUARIO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getPedidosRealizados() {
		return pedidosRealizados;
	}

	public void setPedidosRealizados(int pedidosRealizados) {
		this.pedidosRealizados = pedidosRealizados;
	}

	public int getPedidosEntregados() {
		return pedidosEntregados;
	}

	public void setPedidosEntregados(int pedidosEntregados) {
		this.pedidosEntregados = pedidosEntregados;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "USUARIO [email=" + email + ", zona=" + zona + ", direccion=" + direccion + ", rol=" + rol
				+ ", pedidosRealizados=" + pedidosRealizados + ", pedidosEntregados=" + pedidosEntregados
				+ ", idUsuario=" + idUsuario + "]";
	}

}
