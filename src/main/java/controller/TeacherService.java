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
public class TeacherService
{
	@Autowired
	private TeacherDao dao;

	public List<Teacher> findByUsername(String username)
	{
		return dao.findByUsername(username);
	}

	public void save(Teacher user)
	{
		dao.save(user);
	}

	public void saveIfNotExist(Teacher user)
	{
		if (findByUsername(user.getUsername()).size()>0) return;
		save(user);
	}
}
