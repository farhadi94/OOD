package main.java.controller;

import java.sql.Time;
import javax.persistence.*;

enum DayOfWeek{
	Saturday,
	Sunday,
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
}
@Entity
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
