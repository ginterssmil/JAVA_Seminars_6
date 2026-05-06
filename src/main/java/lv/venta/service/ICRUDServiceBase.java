package lv.venta.service;

import java.util.ArrayList;

//Ttype - template datu tips kas pielagosies velak jau konkretaja CRUD intefeisa
public interface ICRUDServiceBase<Ttype> {
	//CRUD - ka baze tam funkcijam kurasd var sablozinet
	
	public	abstract ArrayList<Ttype> retrieveAll() throws Exception;
	
	public	abstract Ttype retrieveById(long id) throws Exception;
	
	public	abstract void deleteByID(long id) throws Exception;
}
