package es.upm.dit.isst.tfg.dao;

import es.upm.dit.isst.tfg.model.TFG;

public class PruebaDAO {

	public static void main(String[] args) {
		
		TFG tfg =  new TFG();
		
		tfg.setEmail("edwin@gmail.com");
		tfg.setName("edwin");
		tfg.setTitle("PROYECTO1");
		
		TFGDAOImplementation.getInstance().create(tfg);

	}

}
