package com.codechallenge.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codechallenge.domain.Questionnare;
import com.codechallenge.domain.SecurityQuestionRequest;
import com.codechallenge.domain.User;
import com.codechallenge.validators.QuestionnareValidator;
import com.codechallenge.validators.SecurityQuestionValidator;
import com.codechallenge.validators.UserValidator;

@Controller
@RequestMapping(value="/User")
@SessionAttributes({"sessionUser","sessionQuestionnare"})
public class UserController {
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private QuestionnareValidator questionnareValidator;
	
	@Autowired
	private SecurityQuestionValidator securityQuestionValidator;

	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(User user,ModelMap modelMap,Model model, BindingResult result){
		userValidator.validate(user, result);	
		if (result.hasErrors()){
			return "signup";
		}
		modelMap.addAttribute("sessionUser", user);
		model.addAttribute("userQuestionnare", new Questionnare());
		return "questions";
	}

	@RequestMapping(value="/processAnswers", method=RequestMethod.POST)
	public String processAnswers(@ModelAttribute("userQuestionnare") Questionnare userQuestionnare,ModelMap modelMap,BindingResult result){
		questionnareValidator.validate(userQuestionnare, result);	
		if (result.hasErrors()){
			return "questions";
		}
		modelMap.addAttribute("sessionQuestionnare", userQuestionnare);
		return "home";
	}
	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public String validateAnswer(@ModelAttribute("securityQuestion") SecurityQuestionRequest securityQuestion, BindingResult result, HttpServletRequest httpRequest){
		securityQuestionValidator.validate(securityQuestion, result);
		if(result.hasErrors()){
			return "login";
		}
		HttpSession session = httpRequest.getSession(false);
		Questionnare userQuestionnare = (Questionnare) session.getAttribute("sessionQuestionnare");
		if (userQuestionnare.getAnswer1().equals(securityQuestion.getAnswer())){
			return "loginsuccess";
		}else{
			result.addError(new ObjectError("securityQuestion", "Answer doesn't match"));
			return "login";
		}
	}

}
