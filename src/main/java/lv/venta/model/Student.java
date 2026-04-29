package lv.venta.model;


import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="StudentTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends Person {
	
	
	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Collection<Grade> grades = new ArrayList<Grade>();
	
	public Student(String name, String surname) {
		super(name, surname);
	}
}
