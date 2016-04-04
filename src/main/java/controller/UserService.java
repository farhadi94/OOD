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
public class UserService
{
	@Autowired
	private UserDao dao;

	public List<User> findByUsername(String username)
	{
		return dao.findByUsername(username);
	}

	public void save(User user)
	{
		dao.save(user);
	}

	public void saveIfNotExist(User user)
	{
		if (findByUsername(user.getUsername()).size()>0) return;
		save(user);
	}
}
