package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="SubjectTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {
	@Setter(value=AccessLevel.NONE)
	@Column(name="Suid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long suid;
	
	@Column(name="Title")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[A-Za-z ]{1,40s}")
	private String title;
	
	@Column(name="CreditPoints")
	@NotNull
	@Min(1)
	@Max(30)
	private int creditPoints;
	
	@OneToOne
	//radis prof id Subject klase
	@JoinColumn(name="Pid")
	private Professor professor;
	
	@OneToMany(mappedBy = "subject")
	@ToString.Exclude
	private Collection<Grade> grades = new ArrayList<Grade>();
	
	public Subject(String title, int creditPoints, Professor professor) {
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}
}
