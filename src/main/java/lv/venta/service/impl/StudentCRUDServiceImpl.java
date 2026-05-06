package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.iStudentRepo;
import lv.venta.service.IStudentCRUDService;

@Service
public class StudentCRUDServiceImpl implements IStudentCRUDService{

	@Autowired
	private iStudentRepo studRepo;
	@Autowired
	private IGradeRepo grRepo;
	
	
	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if(studRepo.count()==0) {
			throw new Exception("Produkta tabula DB ir tuksa");
		}
		
		return (ArrayList<Student>) studRepo.findAll();
	}

	@Override
	public Student retrieveById(long id) throws Exception {
		if(id <=0 || !studRepo.existsById(id)) {
			throw new Exception("id nevar but negativs vai nulle, vai nepastav produkts ar tadu id");
		}
		Student studenttFromDB = studRepo.findById(id).get();
		return studenttFromDB;
	}

	@Override
	public void deleteByID(long id) throws Exception {
		Student studentForRemoving = retrieveById(id);
		ArrayList<Grade> gradesForThisStudent = grRepo.findByStudentSid(id);
		
		for(Grade tempG : gradesForThisStudent) {
			tempG.setStudent(null);
			grRepo.save(tempG);
		}
		studRepo.delete(studentForRemoving);
		
	}

	@Override
	public void create(String name, String surname) throws Exception {
		// TODO pabeigt
		
	}

	@Override
	public void updateById(long id, String name, String surname) throws Exception {
		// TODO pabeigt
		
	}

	
}
