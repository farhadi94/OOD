package main.java.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: LGM
 * Date: 4/4/16
 * Time: 10:58 AM
 */
@Repository
public interface CourseDao extends CrudRepository<Course, Long>
{
	ArrayList<Course> findByCourseId(long courseId);
}
