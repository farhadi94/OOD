package main.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisteryManager {

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginSubmit(HttpServletResponse response, @ModelAttribute LoginFormFields loginFormFields, Model model) {
		//FIXME add correct authentication
		if (true){
			response.addCookie(new Cookie("username", loginFormFields.getUsername()));
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