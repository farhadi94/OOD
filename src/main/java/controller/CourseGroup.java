package main.java.controller;

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
	
	@ManyToMany()
	@JoinTable(
		name="CourseGroup_SessionTime",
		joinColumns=@JoinColumn(name="courseGroup", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="sessionTime", referencedColumnName="id"))
	private List<SessionTime> sessionTimes;
	
	@ManyToMany()
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

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public List<Gradable> getGradables()
	{
		return gradables;
	}

	public void setGradables(List<Gradable> gradables)
	{
		this.gradables = gradables;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public List<Resource> getResources()
	{
		return resources;
	}

	public void setResources(List<Resource> resources)
	{
		this.resources = resources;
	}

	public String getRoom()
	{
		return room;
	}

	public void setRoom(String room)
	{
		this.room = room;
	}

	public SemesterType getSemesterType()
	{
		return semesterType;
	}

	public void setSemesterType(SemesterType semesterType)
	{
		this.semesterType = semesterType;
	}

	public int getSemesterYear()
	{
		return semesterYear;
	}

	public void setSemesterYear(int semesterYear)
	{
		this.semesterYear = semesterYear;
	}

	public List<SessionTime> getSessionTimes()
	{
		return sessionTimes;
	}

	public void setSessionTimes(List<SessionTime> sessionTimes)
	{
		this.sessionTimes = sessionTimes;
	}

	public List<Student> getStudents()
	{
		return students;
	}

	public void setStudents(List<Student> students)
	{
		this.students = students;
	}

	public Syllabus getSyllabus()
	{
		return syllabus;
	}

	public void setSyllabus(Syllabus syllabus)
	{
		this.syllabus = syllabus;
	}

	public List<TA> getTas()
	{
		return tas;
	}

	public void setTas(List<TA> tas)
	{
		this.tas = tas;
	}

	public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
}
