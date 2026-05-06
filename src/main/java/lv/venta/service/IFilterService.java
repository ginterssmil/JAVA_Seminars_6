package lv.venta.service;

import java.util.ArrayList;


import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.Subject;
import lv.venta.model.enums.Degree;

public interface IFilterService {

	//iegut profesorus, kura grads ir konkrets
	public abstract ArrayList<Professor> filterProfessorByDegree(Degree degree) throws Exception;
	
	//iegut kursus kurus pasniedz prfesors ar konkreto id
	public abstract ArrayList<Subject> filterSubjectByProfessorId(long id) throws Exception;
	
	//iegut visas atzimes ja ir zinams studenta vards un uzvards
	public abstract ArrayList<Grade> filterGradesByNameAndSurname(String name, String surname) throws Exception;

	// videjo atzimu vertibu ja ir zinams kursa nosaukums
	public abstract float calculateAvgGradeOfSubjectByTitle(String title) throws Exception;

	//iegut visus studentus kuriem ir kada nesekmīga atzīme
	public abstract ArrayList<Student> filterStudentsWithFailedGrades() throws Exception;

}
