package main.java.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: LGM
 * Date: 4/4/16
 * Time: 10:58 AM
 */
@Repository
public interface CourseGroupDao extends CrudRepository<CourseGroup, Long>
{
}
