package main.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisteryManager {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String def(Model model)
	{
		return "redirect:/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model, @CookieValue(value = "username",defaultValue = "") String username) {
		if (!username.equals(""))
			return "redirect:/home";
		model.addAttribute("loginFormFields", new LoginFormFields());
		return "login";
	}
	@Autowired()
	UserService repository;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginSubmit(HttpServletResponse response, @RequestParam("user") String user,@RequestParam("pass") String pass, Model model) {
		List<User> users=repository.findByUsername(user);
		if (users.size()>0 && users.get(0).getPassword().equals(pass)){
			response.addCookie(new Cookie("username", user));
			model.addAttribute("username",user);
			model.addAttribute("password",pass);
			return "redirect:/login";
		}else
			return null;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout (HttpServletResponse response, Model model){
		Cookie cookie = new Cookie("username", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/login";
	}
}