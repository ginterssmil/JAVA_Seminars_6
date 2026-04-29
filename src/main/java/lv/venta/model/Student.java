package lv.venta.model;

import java.nio.charset.IllegalCharsetNameException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
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
public class Student {
	@Setter(value=AccessLevel.NONE)
	@Column(name="Sid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
	@Column(name="Name")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	private String name;
	

	@Column(name="Surame")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	private String surname;
	
	
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
