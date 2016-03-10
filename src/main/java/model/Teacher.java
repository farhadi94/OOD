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
public class Teacher {
	
	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
	
	@Column(unique=true)
	private Long teacherId;
	private Long depNo;
	
	@OneToMany(mappedBy="teacher")
	List<CourseGroup> courseGroups;
	
	public Teacher() {
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
