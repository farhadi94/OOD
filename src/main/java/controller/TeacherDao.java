package main.java.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao extends CrudRepository<Teacher, Long>{
	List<Teacher> findByUsername(String username);

}
