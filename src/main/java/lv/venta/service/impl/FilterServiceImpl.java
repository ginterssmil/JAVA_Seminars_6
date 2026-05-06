package lv.venta.service.impl;

import java.io.CharArrayReader;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.Subject;
import lv.venta.model.enums.Degree;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.repo.ISubjectRepo;
import lv.venta.service.IFilterService;

public class FilterServiceImpl implements IFilterService{
	@Autowired
	private IProfessorRepo profRepo;
	@Autowired
	private IStudentRepo studRepo;
	@Autowired
	private ISubjectRepo subjectRepo;
	@Autowired
	private IGradeRepo grRepo;
	
	@Override
	public ArrayList<Professor> filterProfessorByDegree(Degree degree) throws Exception{
		if(degree == null) {
			throw new Exception("Gradam jabut eksistejosam");
		}
		
		ArrayList<Professor> result = profRepo.findByDegree(degree);
		if(result.isEmpty()) {
			throw new Exception("nav profesoru ar " + degree);
		}
		return result;
	}

	@Override
	public ArrayList<Subject> filterSubjectByProfessorId(long id) throws Exception {
		if(id<=0) {
			throw new Exception("Id jabut pozitivam");
		}
		if(!profRepo.existsById(id)) {
			throw new Exception("Nevar athirzt kursus, jo profesors ar id" + id + " nekesiste");
		}
		
		ArrayList<Subject> result = subjectRepo.findByProfessorPid(id);
		if(result.isEmpty()) {
			throw new Exception("profesorma ar id" +id + " nav piesaistits neviens kurss");
		}
		return result;
	}

	@Override
	public ArrayList<Grade> filterGradesByNameAndSurname(String name, String surname) throws Exception {
		if(name ==null || surname == null) {
			throw new Exception("ievades dati nav pilnigi");
		}
		if(!studRepo.existsByNameAndSurname(name, surname)) {
			throw new Exception(" Students ar vardu " + name + " un uzvardu " + surname + "neeksiste");
		}
		
		ArrayList<Grade> result = grRepo.findByStudentNameAndSurname(name, surname);
		
		if(result.isEmpty()) {
			throw new Exception(" Studentam ar vardu " + name + " un uzvardu " + surname + "nav piesaistitas atzimes");
		}
		return result;
	}

	@Override
	public float calculateAvgGradeOfSubjectByTitle(String title) throws Exception {
		if(title == null) {//TODO isempty un regex
			throw new Exception("Ievades dati nav pilnigi");
		}
		
		if(!subjectRepo.existsByTitle(title)) {
			throw new Exception("Kurss ar nosaukumu " + title + " neeksite");
		}
		
		
		float result = grRepo.calculateAVGGradeForSubject(title);
		
		if(result == 0) {
			throw new Exception("Kursam " + title + " nav piesaistias atzimes un nevar aprekinat videjo");
		}
		
		return result;
	}

	@Override
	public ArrayList<Student> filterStudentsWithFailedGrades() throws Exception {
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula ir tuksa");
		}
		if(grRepo.count()==0) {
			throw new Exception("atzimju tabula ir tuksa");

		}
		
		ArrayList<Student> result = grRepo.findByGradesGrvalueLessThan(4);
		
		if(result.isEmpty()) {
			throw new Exception(" ");
		}
		return result;
	}

}
