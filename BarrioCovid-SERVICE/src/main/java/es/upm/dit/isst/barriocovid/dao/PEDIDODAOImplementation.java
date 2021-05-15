 package es.upm.dit.isst.barriocovid.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.barriocovid.model.PEDIDO;


public class PEDIDODAOImplementation implements PEDIDODAO{
	private static  PEDIDODAOImplementation instancia = null;
	  private PEDIDODAOImplementation() {
	  }

	 public static PEDIDODAOImplementation getInstance() {
	    if( null == instancia )
	      instancia = new PEDIDODAOImplementation();
	    return instancia;
	  }
	 
	 @Override
	 public PEDIDO create(PEDIDO pedido) {
		  Session session = SessionFactoryService.get().openSession();
		  session.beginTransaction();
		  	try {
		  		session.save(pedido);
		  	} catch (Exception e) {
		  		pedido = null;
		  	}
		  session.getTransaction().commit();
		  session.close();
		return pedido;
	 }
	 
	 public PEDIDO read(String comprador) {
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 PEDIDO pedido = session.get(PEDIDO.class, comprador);
		 session.getTransaction().commit();
		 session.close();
		 return pedido;
	}
	 
	 public PEDIDO update(PEDIDO pedido) {
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 session.saveOrUpdate(pedido);
		 session.getTransaction().commit();
		 session.close();
		 return pedido;
	 } 
	 public PEDIDO delete(PEDIDO pedido) {
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 session.delete(pedido);
		 session.getTransaction().commit();
		 session.close();
		 return pedido;
	}
	 @SuppressWarnings("unchecked")
	 @Override
	 public List<PEDIDO> readAll() {
		 List<PEDIDO> pedidos = new ArrayList<PEDIDO>();
		 Session session = SessionFactoryService.get().openSession();
		 session.beginTransaction();
		 pedidos.addAll(session.createQuery("from PEDIDO").list());
		 session.getTransaction().commit();
		 session.close();
		 return pedidos;
	 }
	 @Override
	 public List<PEDIDO> readAllVendedor(String vendedor) {
		List<PEDIDO> res = new ArrayList<PEDIDO>();
		for(PEDIDO pedido : this.readAll()) {
			if(pedido.getVendedor().contentEquals(vendedor)) {
				res.add(pedido);
			}
		}
		return res;
	}
	 @Override
	 public List<PEDIDO> readAllVoluntario(String voluntario) {
		List<PEDIDO> res = new ArrayList<PEDIDO>();
		for(PEDIDO pedido : this.readAll()) {
			if(pedido.getVoluntario().contentEquals(voluntario)) {
				res.add(pedido);
			}
		}
		return res;
	}
	 
	 
}
