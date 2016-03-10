package main.java.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="student")
	private List<TA> tas;
	
	@Column(unique=true)
	private Long studentId;
	
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
