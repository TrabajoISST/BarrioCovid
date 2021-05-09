package es.upm.dit.isst.barriocovid.dao;
import java.util.List;

import es.upm.dit.isst.barriocovid.model.PEDIDO;

public interface PEDIDODAO {

	public PEDIDO create(PEDIDO pedido);
	public PEDIDO read(String comprador);
	public PEDIDO update(PEDIDO pedido);
	public PEDIDO delete(PEDIDO pedido);
	public List<PEDIDO> readAll();
	public List<PEDIDO> readAllVendedor(String vendedor);
	public List<PEDIDO> readAllVoluntario(String voluntario);
}
