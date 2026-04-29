package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Student;



public interface IStudentCrudService {

	public abstract void create(String name, String surname) throws Exception;

	public abstract ArrayList<Student> retrieveAll() throws Exception;

	public abstract Student retrieveById(long id) throws Exception;
	
	public abstract void updateById(long id, String name, String surname) throws Exception;

	public abstract void deleteById(long id) throws Exception;

}
