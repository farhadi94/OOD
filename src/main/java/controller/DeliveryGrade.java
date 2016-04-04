package main.java.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryGrade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student")
	private Student student;

	@ManyToMany
	@JoinTable(
		name="DeliveryGrade_File",
		joinColumns=@JoinColumn(name="deliveryGradeId", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="fileId", referencedColumnName="id"))
	private List<File> files;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="educationDelivery")
	private EducationDelivery educationDelivery;

	@Column(nullable=true)
	private double grade;

	private Timestamp receivedTime;

	public DeliveryGrade() {
	}
}
