package main.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: LGM
 * Date: 4/3/16
 * Time: 9:39 PM
 */
@Controller
public class HomeManager
{
	@Autowired
	UserService userService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CourseGroupService courseGroupService;
	@RequestMapping(value="/home", method= RequestMethod.GET)
	public String loginForm(Model model,@CookieValue(value = "username",defaultValue = "") String username)
	{
		if (username.equals("")) return "redirect:/login";
		User user=userService.findByUsername(username).get(0);
		model.addAttribute("user",user);
		if (teacherService.findByUsername(user.getUsername()).size()>0)
			model.addAttribute("courses",courseGroupService.findByTeacher(teacherService.findByUsername(user.getUsername()).get(0)));
		return "courses";
	}
}
