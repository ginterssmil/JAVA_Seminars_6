package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Subject;

public interface ISubjectRepo extends CrudRepository<Subject, Long> {

}
