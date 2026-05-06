package lv.venta.service;

import lv.venta.model.Student;

public interface IStudentCRUDService extends ICRUDServiceBase<Student>{
	//CRUD prieks Studenta - retrieveAll retrieveByID  deleteById
	
	//create
	public abstract void create(String name, String surname) throws Exception;
	
	//update
	public abstract void updateById(long id, String name, String surname) throws Exception;
}
