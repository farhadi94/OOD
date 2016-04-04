package main.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LGM
 * Date: 4/4/16
 * Time: 1:15 AM
 */
@Service
@Component
public class StudentService
{
	@Autowired
	private StudentDao dao;

	public List<Student> findByUsername(String username)
	{
		return dao.findByUsername(username);
	}

	public void save(Student user)
	{
		dao.save(user);
	}

	public void saveIfNotExist(Student user)
	{
		if (findByUsername(user.getUsername()).size()>0) return;
		save(user);
	}
}
