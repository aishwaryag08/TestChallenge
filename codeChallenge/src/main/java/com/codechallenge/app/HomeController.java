package com.codechallenge.app;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codechallenge.domain.SecurityQuestionRequest;
import com.codechallenge.domain.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);				
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loadHome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);				
		return "home";
	}
	
	@RequestMapping(value = "/navigate", method = RequestMethod.POST, params = "signup")
	public String navigateToSignUp(Model model) {
		model.addAttribute("user",new User());
	    return "signup";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String navigateToLogin(@RequestParam("userName")String userName, HttpServletRequest request, Model model) { 
		HttpSession session = request.getSession(false);
		Object object = session.getAttribute("sessionUser");
		if(object  == null){
			return "home";
		}else{
			User user = (User)object;
			if(user.getUserName().equals(userName)){
				model.addAttribute("securityQuestion", new SecurityQuestionRequest());
				return "login";
			}else{
				return "home";
			}
		}
		
	}
	
}
