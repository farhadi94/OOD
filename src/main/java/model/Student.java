package main.java.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorColumn(name="s")
public class Student extends User{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private long id;
	
	@OneToMany(mappedBy="student")
	private List<TA> tas;
	
	@Column(unique=true)
	private Long studentId;
	
	@ManyToMany(mappedBy="students")
	private List<CourseGroup> courseGroups;
	
	@OneToMany(mappedBy="student")
	private List<ExamGrade> examGrades;
	
	private Long depNo;
	
	public Student() {
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getDepNo() {
		return depNo;
	}
	public void setDepNo(Long depNo) {
		this.depNo = depNo;
	}
}
