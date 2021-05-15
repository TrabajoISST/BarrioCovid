package es.upm.dit.isst.barriocovid.dao;

import java.util.List;

import es.upm.dit.isst.barriocovid.model.USUARIO;

public interface USUARIODAO {

	public USUARIO createUSUARIO(USUARIO usuario);
	public USUARIO readUSUARIO(String email);
	public USUARIO updateUSUARIO(USUARIO usuario);
	public USUARIO deleteUSUARIO(USUARIO usuario);
	public int readAllUSUARIONumber();
	public List<USUARIO> readAllUSUARIO();
	public List<USUARIO> readAllUSUARIOVoluntario(String voluntario);
	public List<USUARIO> readAllUSUARIOVendedor(String vendedor);

}
