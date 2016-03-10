package main.java.model;

import java.sql.Time;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum DayOfWeek{
	Saturday,
	Sunday,
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
}

public class SessionTime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Time startTime;
	private Time endTime;
	
	@Enumerated(EnumType.STRING)
	private DayOfWeek day; 
	
	public SessionTime() {
	}
}
