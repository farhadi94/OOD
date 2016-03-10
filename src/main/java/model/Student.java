package main.java.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user")
	private User user;
	
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
