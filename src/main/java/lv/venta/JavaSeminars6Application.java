package lv.venta;

import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.Subject;
import lv.venta.model.enums.Degree;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.ISubjectRepo;
import lv.venta.repo.iStudentRepo;

import java.util.Arrays;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSeminars6Application {

	private final IGradeRepo IGradeRepo;
	private final ISubjectRepo ISubjectRepo;
	private final IProfessorRepo IProfessorRepo;
	private final iStudentRepo iStudentRepo;



	JavaSeminars6Application(iStudentRepo iStudentRepo, IProfessorRepo IProfessorRepo, ISubjectRepo ISubjectRepo, IGradeRepo IGradeRepo) {
		this.iStudentRepo = iStudentRepo;
		this.IProfessorRepo = IProfessorRepo;
		this.ISubjectRepo = ISubjectRepo;
		this.IGradeRepo = IGradeRepo;
	}



	public static void main(String[] args) {
		SpringApplication.run(JavaSeminars6Application.class, args);
	}

	
	@Bean
	public CommandLineRunner testRepo(iStudentRepo studRepo, IProfessorRepo profRepo, ISubjectRepo subjectRepo, IGradeRepo gradeRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student stud1 = new Student("Rendijs", "Serna");
				Student stud2 = new Student("Janis", "Berzins");
				studRepo.saveAll(Arrays.asList(stud1, stud2));
				
				Professor prof1 = new Professor("Vairis", "Caune", Degree.bachelor);
				Professor prof2 = new Professor("Galina", "Hilkevica", Degree.master);
				profRepo.saveAll(Arrays.asList(prof1, prof2));

				
				Subject subj1 = new Subject("JAVA", 6, prof2);
				Subject subj2 = new Subject("Timekla tehno", 3, prof1);
				subjectRepo.saveAll(Arrays.asList(subj1, subj2));
				
				Grade grade1 = new Grade(10, stud1, subj1);
				Grade grade2 = new Grade(7, stud2, subj2);
				gradeRepo.saveAll(Arrays.asList(grade1, grade2));
				
			}
		};
	}
}
