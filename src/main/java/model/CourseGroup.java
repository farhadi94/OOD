package main.java.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CourseGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="courseGroup")
	private List<TA> tas;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course")
	private Course course;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teacherUserId")
	private Teacher teacher;
	
	private String room;
	private int semesterYear;
	
	@Column(length=31)
	private String semesterType;
}
