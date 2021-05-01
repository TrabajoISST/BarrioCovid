package es.upm.dit.isst.tfg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.tfg.model.TFG;


/********************************************************************
 *
 * 
 *                     * TFGDAOImplementatio *
 *     - Me da acceso a los metodos CRUD para manipular los atributos  
 *       de la entidad  TFG(es.upm.dit.isst.tfg.model.TFG)
 * 
 * 
 ********************************************************************/
public class TFGDAOImplementation implements TFGDAO {

	private static TFGDAOImplementation instancia = null;

	private TFGDAOImplementation() {

	}

	public static TFGDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new TFGDAOImplementation();
		return instancia;
	}

/*****************************************************
 * 
 *  Implementacion Metodos CRUD:
 *             
 *         - read
 *         - create
 *         - update
 *         - delete
 ******************************************************/ 

	@Override
	public TFG read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		TFG tfg = session.get(TFG.class, email);
		session.getTransaction().commit();
		session.close();
		return tfg;
	}

	

	@Override
	public TFG update(TFG tfg) {

		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		session.saveOrUpdate(tfg);
		session.getTransaction().commit();

		session.close();
		return tfg;

	}

	@Override
	public TFG delete(TFG tfg) {

		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		session.delete(tfg);
		session.getTransaction().commit();

		session.close();
		return tfg;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TFG> readAll() {

		List<TFG> tfgs = new ArrayList<TFG>();
		Session session = SessionFactoryService.get().openSession();

		session.beginTransaction();
		tfgs.addAll(session.createQuery("from TFG").list());
		session.getTransaction().commit();

		session.close();
		return tfgs;

	}
	
	@Override
	public TFG create(TFG tfg) {

		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		try {
			session.save(tfg);
		} catch (Exception e) {
			tfg = null;
		}

		session.getTransaction().commit();
		session.close();
		return tfg;

	}




@Override
public List<TFG> readAll(String professor) {
	
	List<TFG> res = new ArrayList<TFG>();
	for (TFG tfg : this.readAll())
		if (tfg.getAdvisor().equals(professor)) {
			
			res.add(tfg);
		}
	
	System.out.println("\n");
	System.out.print("Numero de TFGs asociados al "+ professor +" son : " + res.size() );
	System.out.println("\n");
	
	return res;
}

	
}
