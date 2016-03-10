package main.java.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("e")
public class Exam extends Gradable{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private long id;
	
	private Date date;
	
	@Column(length=1023, nullable=true)
	private String place;
	
	@OneToMany(mappedBy="exam")
	private List<ExamGrade> examGrades;
	
	public Exam() {}
}
