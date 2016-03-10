package main.java.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("d")
public class EducationDelivery {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private long id;
	
	private Timestamp softDeadline;
	private Timestamp hardDeadline;
	private double policy;
	
	@ManyToMany
	@JoinTable(
		name="EducationalDelivery_File",
		joinColumns=@JoinColumn(name="educationalDelivery", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="file", referencedColumnName="id"))
	private List<File> files;
	
	@OneToMany(mappedBy="educationDelivery")
	private List<DeliveryGrade> deliveryGrades;
	
	public EducationDelivery() {
	}
}
