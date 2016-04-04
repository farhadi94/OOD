package main.java.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

enum ResourceType{
	File,
	URL,
}

@Entity
public class Resource {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=true, length=1023)
	private String url;
	
	@Enumerated(EnumType.STRING)
	private ResourceType resourceType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="courseGroup")
	private CourseGroup courseGroup;
	
	//TODO add resource file
	
	public Resource() {}
}
