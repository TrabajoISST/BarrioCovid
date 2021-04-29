package es.upm.dit.isst.barriocovid.dao;

import java.util.List;

import es.upm.dit.isst.barriocovid.model.BarrioCovid;



public interface BarrioCovidDAO {
	
	
	public BarrioCovid create(BarrioCovid tfg);
	public BarrioCovid read(String email);
	public BarrioCovid update(BarrioCovid tfg);
	public BarrioCovid delete(BarrioCovid tfg);
	
	public List<BarrioCovid>  readAll();
	
	
	//Este metodo lo utilizaran tanto el comprador, vendedor como voluntario
	public List<BarrioCovid>  readAll(String email);
	



}
