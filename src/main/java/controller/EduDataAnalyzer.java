package main.java.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EduDataAnalyzer {
	
	private static EduDataAnalyzer instance = null;
	
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public EduDataAnalyzer() {}
	
	public static EduDataAnalyzer getInstance() {
		if (instance == null)
			instance = new EduDataAnalyzer();
		return instance;
	}
	
	public void parseAndInsertNewData(File file){
		ArrayList<EduData> eduDatas = parseEduData(file); 
		for (EduData eduData: eduDatas)
			if (eduData.validateAndInsert() == false)
				System.err.println("Invalid data");
		System.err.println("COUNT: " + userDao.count());

	}
	
	private ArrayList<EduData> parseEduData(File file){
		ArrayList<EduData> eduDatas = new ArrayList<EduData>();
		try{
			Workbook wb = new XSSFWorkbook(file);
			eduDatas.addAll(parseStudentsSheet(wb.cloneSheet(0), 0));
			eduDatas.addAll(parseLecturersSheet(wb.cloneSheet(1), 1));
			eduDatas.addAll(parseCLMappingSheet(wb.cloneSheet(2), 2));
			eduDatas.addAll(parseSCMappingSheet(wb.cloneSheet(3), 3));
			wb.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return eduDatas;
	}
	
	private ArrayList<EduData> parseStudentsSheet(Sheet sheet, int priority) {
		Iterator<Row> itRow = sheet.rowIterator();
		ArrayList<EduData> students = new ArrayList<EduData>();
		while (itRow.hasNext())
			students.add(new EduStudentData(itRow.next(), priority));
		return students;
	}
	
	private ArrayList<EduData> parseLecturersSheet(Sheet sheet, int priority) {
		Iterator<Row> itRow = sheet.rowIterator();
		ArrayList<EduData> teachers = new ArrayList<EduData>();
		while (itRow.hasNext())
			teachers.add(new EduTeacherData(itRow.next(), priority));
		return teachers;
	}
	
	private ArrayList<EduData> parseCLMappingSheet(Sheet sheet, int priority) {
		Iterator<Row> itRow = sheet.rowIterator();
		ArrayList<EduData> courseGroups = new ArrayList<EduData>();
		while (itRow.hasNext())
			courseGroups.add(new EduTCGData(itRow.next(), priority));
		return courseGroups;
	}
	
	private ArrayList<EduData> parseSCMappingSheet(Sheet sheet, int priority) {
		Iterator<Row> itRow = sheet.rowIterator();
		ArrayList<EduData> studentCourseGroupMapping = new ArrayList<EduData>();
		while (itRow.hasNext())
			studentCourseGroupMapping.add(new EduSCGData(itRow.next(), priority));
		return studentCourseGroupMapping;
	}
	
	abstract class EduData{
		protected int priority;
		public abstract boolean validateAndInsert();
	}
	
	class EduStudentData extends EduData{
		
		private long studentId;
		private String name;
		private String password;
		private Date birthDate;
		private long depNo;
		
		public EduStudentData(Row row, int priority) {
			try{
				this.priority = priority;
				DataFormatter formatter = new DataFormatter();
				studentId = Long.parseLong(formatter.formatCellValue(row.getCell(0)));
				name = formatter.formatCellValue(row.getCell(1));
				password = formatter.formatCellValue(row.getCell(2));
				String birthDataRaw = formatter.formatCellValue(row.getCell(3));
				String[] ymd = birthDataRaw.split("/");
				birthDate = new Date(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]));
				depNo = Long.parseLong(formatter.formatCellValue(row.getCell(4)));
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		@Override
		public boolean validateAndInsert() {
			return false;
		}
	}
	
	class EduTeacherData extends EduData{
		private long teacherId;
		private String name;
		private String password;
		private Date birthDate;
		private long depNo;
		
		public EduTeacherData(Row row, int priority) {
			try{
				this.priority = priority;
				DataFormatter formatter = new DataFormatter();
				teacherId = Long.parseLong(formatter.formatCellValue(row.getCell(0)));
				name = formatter.formatCellValue(row.getCell(1));
				password = formatter.formatCellValue(row.getCell(2));
				String birthDataRaw = formatter.formatCellValue(row.getCell(3));
				String[] ymd = birthDataRaw.split("/");
				birthDate = new Date(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]));
				depNo = Long.parseLong(formatter.formatCellValue(row.getCell(4)));
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		@Override
		public boolean validateAndInsert() {
			return false;
		}
	}
	
	class EduTCGData extends EduData{
		
		private long tcId;
		private long courseId;
		private String courseTitle;
		private long teacherId;
		private String sessionTimes;
		private String finalExamTime;
		private String semester;
		private long groupId;
		private String room;
		private long depNo;
		
		public EduTCGData(Row row, int priority) {
			try{
				this.priority = priority;
				DataFormatter formatter = new DataFormatter();
				tcId= Long.parseLong(formatter.formatCellValue(row.getCell(0)));
				courseId= Long.parseLong(formatter.formatCellValue(row.getCell(1)));
				courseTitle= formatter.formatCellValue(row.getCell(2));
				teacherId= Long.parseLong(formatter.formatCellValue(row.getCell(3)));
				sessionTimes= formatter.formatCellValue(row.getCell(4));
				finalExamTime= formatter.formatCellValue(row.getCell(5));
				semester= formatter.formatCellValue(row.getCell(6));
				groupId= Long.parseLong(formatter.formatCellValue(row.getCell(7)));
				room= formatter.formatCellValue(row.getCell(8));
				depNo= Long.parseLong(formatter.formatCellValue(row.getCell(9)));
//				System.err.print(tcId + ", ");
//				System.err.print(courseId + ", ");
//				System.err.print(courseTitle + ", ");
//				System.err.print(teacherId + ", ");
//				System.err.print(sessionTimes + ", ");
//				System.err.print(finalExamTime + ", ");
//				System.err.print(semester + ", ");
//				System.err.println(groupId + ", ");
//				System.err.println(room + ", ");
//				System.err.println(depNo + ", ");
			}catch (Exception e){
				e.printStackTrace();
			}			
		}
		
		@Override
		public boolean validateAndInsert() {
			return false;
		}
	}
	
	class EduSCGData extends EduData{
		
		private long tcgId;
		private long studentId;
		
		public EduSCGData(Row row, int priority) {
			try{
				this.priority = priority;
				DataFormatter formatter = new DataFormatter();
				tcgId = Long.parseLong(formatter.formatCellValue(row.getCell(0)));
				studentId = Long.parseLong(formatter.formatCellValue(row.getCell(1)));
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}
		
		@Override
		public boolean validateAndInsert() {
			return false;
		}
	}
}
