package main.java.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student, Long>{
	List<Student> findByUsername(String username);

}
