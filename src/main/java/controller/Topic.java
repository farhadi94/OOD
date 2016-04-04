package main.java.controller;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="syllabus")
	private Syllabus syllabus;
	
	//TODO subtopic
	
	public Topic() {}
}
