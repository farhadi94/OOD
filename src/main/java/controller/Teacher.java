package main.java.controller;

import main.java.controller.CourseGroup;
import main.java.controller.User;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("t")
public class Teacher extends User
{
	
	@Column(unique=true)
	private Long teacherId;
	private Long depNo;
	
	@OneToMany(mappedBy="teacher")
	List<CourseGroup> courseGroups;
	
	public Teacher() {
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Long getDepNo() {
		return depNo;
	}

	public void setDepNo(Long depNo) {
		this.depNo = depNo;
	}
	
}
