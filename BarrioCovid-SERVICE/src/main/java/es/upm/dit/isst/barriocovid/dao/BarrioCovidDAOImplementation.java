package es.upm.dit.isst.barriocovid.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;



/********************************************************************
*
* 
*                     * BarrioCovidDAOImplementation *
*     - Me da acceso a los metodos CRUD para manipular los atributos  
*       de la entidad  BarrioCovid(es.upm.dit.isst.barriocovid.model.BarrioCovid)
* 
* 
********************************************************************/



public class BarrioCovidDAOImplementation implements BarrioCovidDAO {

	private static BarrioCovidDAOImplementation instancia = null;
	
	private BarrioCovidDAOImplementation() {

	}
	
	public static BarrioCovidDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new BarrioCovidDAOImplementation();
		return instancia;
	}
	
	/*****************************************************
	 * 
	 *  Implementacion Metodos CRUD:
	 *  
	 *         -readAll()
	 *         -realAll(String email)
	 *             
	 *         - read
	 *         - create
	 *         - update
	 *         - delete
	 ******************************************************/ 

	
	@SuppressWarnings("unchecked")
	@Override
	public List<BarrioCovid> readAll() {

		//lista == tabla completa
		List<BarrioCovid> lista = new ArrayList<BarrioCovid>();
		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		lista.addAll(session.createQuery("from BarrioCovid").list());
		session.getTransaction().commit();

		session.close();
		return lista;

	}
	
	
	@Override
	public List<BarrioCovid> readAll(String email) {
		
		List<BarrioCovid> res = new ArrayList<BarrioCovid>();
		for (BarrioCovid registro : this.readAll())
			if (registro.getVendedor().equals(email)) {
				
				res.add(registro);
			}
		
		System.out.println("\n");
		System.out.print("Lista asociados a  "+ email +" son : " + res.size() );
		System.out.println("\n");
		
		return res;
	}

	
	
	////registro === fila de la BBDD
	@Override
	public BarrioCovid read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		BarrioCovid registro = session.get(BarrioCovid.class, email);
		session.getTransaction().commit();
		session.close();
		return registro;
	}
	
	
	//registro === fila de la BBDD
	@Override
	public BarrioCovid create(BarrioCovid registro) {

		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(registro);
		} catch (Exception e) {
			registro = null;
		}

		session.getTransaction().commit();
		session.close();
		return registro;

	}
	
	
	
	//registro === fila de la BBDD
	@Override
	public BarrioCovid update(BarrioCovid registro) {

		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		session.saveOrUpdate(registro);
		session.getTransaction().commit();

		session.close();
		return registro;

	}
	
	@Override
	public BarrioCovid delete(BarrioCovid registro) {

		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		session.delete(registro);
		session.getTransaction().commit();

		session.close();
		return registro;

	}
	
	
	

	
}
