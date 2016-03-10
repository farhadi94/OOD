package main.java.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

enum SemesterType{
	Spring,
	Fall,
	Summer,
}

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
	@JoinColumn(name="teacher")
	private Teacher teacher;
	
	@ManyToMany
	@JoinTable(
		name="CourseGroup_SessionTime",
		joinColumns=@JoinColumn(name="courseGroup", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="sessionTime", referencedColumnName="id"))
	private List<SessionTime> sessionTimes;
	
	@ManyToMany
	@JoinTable(
		name="CourseGroup_Student",
		joinColumns=@JoinColumn(name="courseGroup", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="student", referencedColumnName="id"))
	private List<Student> students;
	
	private String room;
	private int semesterYear;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="syllabus")
	private Syllabus syllabus;
	
	@OneToMany(mappedBy="courseGroup")
	private List<Resource> resources;
	
	@OneToMany(mappedBy="courseGroup")
	private List<Gradable> gradables;
	
	@Enumerated(EnumType.STRING)
	private SemesterType semesterType;
}
