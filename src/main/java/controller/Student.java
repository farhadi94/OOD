package main.java.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorColumn(name="s")
public class Student extends User
{
	
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
