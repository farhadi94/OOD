package main.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: LGM
 * Date: 4/4/16
 * Time: 11:09 AM
 */
@Service
@Component
public class CourseService
{
	@Autowired
	CourseDao dao;
	public void save(Course course)
	{
		dao.save(course);
	}

	public Course saveIfNotExist(Course course)
	{
		if (dao.findByCourseId(course.getCourseId()).size()>0) dao.findByCourseId(course.getCourseId()).get(0);
		save(course);
		return course;
	}
}
