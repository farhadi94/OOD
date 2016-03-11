package main.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisteryManager {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("loginFormFields", new LoginFormFields());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginSubmit(HttpServletResponse response, @RequestParam("user") String user,@RequestParam("pass") String pass, Model model) {
		System.err.println(user);
		if (true){
			response.addCookie(new Cookie("username", user));
			model.addAttribute("username",user);
			model.addAttribute("password",pass);
			return "profile";	
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