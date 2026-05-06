package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Subject;

public interface ISubjectRepo extends CrudRepository<Subject, Long> {

	ArrayList<Subject> findByProfessorPid(long id);

	boolean existsByTitle(String title);

}
