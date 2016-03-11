package main.java.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LGM
 * Date: 3/11/16
 * Time: 9:07 PM
 */
public interface UserRepository extends CrudRepository<User,Long>
{
	List<User> findByUsername(String username);
}
