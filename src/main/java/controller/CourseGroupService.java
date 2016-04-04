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
public class CourseGroupService
{
	@Autowired
	CourseGroupDao dao;
	public void save(CourseGroup course)
	{
		dao.save(course);
	}

	public CourseGroup saveIfNotExist(CourseGroup course)
	{
		if (dao.findByCourse(course.getCourse()).size()>0) return dao.findByCourse(course.getCourse()).get(0);
		save(course);
		return dao.findByCourse(course.getCourse()).get(0);
	}
}
