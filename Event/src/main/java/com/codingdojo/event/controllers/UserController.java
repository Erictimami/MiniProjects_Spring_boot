package com.codingdojo.event.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.event.models.User;
import com.codingdojo.event.services.UserService;
import com.codingdojo.event.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
		
	}

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "/regLog/regLog.jsp";
    }
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	userValidator.validate(user, result);//important for validation
    	if(result.hasErrors()) {
    		return "/regLog/regLog.jsp";
    	} else if(userService.findByEmail(user.getEmail()) == null) {
    		User u = userService.registerUser(user);
    		session.setAttribute("logged", true);
    		session.setAttribute("id", u.getId());
    		return "redirect:/events";//TO CHANGE
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	return "redirect:/errorRegistration";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	if(userService.authentificateUser(email, password) == true) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("logged", true);
    		session.setAttribute("id", user.getId());
    		return "redirect:/events";
    	} else {
    		return "redirect:/errorLogin";
    	}
        // else, add error messages and return the login page
    }
//    @RequestMapping("/home")
//    public String home(HttpSession session, Model model) {
//        // get user from session, save them in the model and return the home page
//    	if(session.getAttribute("logged") == null) {
//    		return "redirect:/login";
//    	}else if((session.getAttribute("logged").toString()).equals("false") == true) {
//    		return "redirect:/login";
//    	}
//    	User user = userService.findUserById(Long.parseLong(session.getAttribute("id").toString()));
//    	model.addAttribute("user", user);
//    	return "/home/index.jsp";
//    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.setAttribute("logged", false);
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
    
	@RequestMapping("/errorRegistration")//this is not the same error with this below. this is the root name, this below is the variable name for flash in the index.jsp page
	public String flashMessagesR(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorReg", "All the inputs are required and <br> You must enter valid inputs");
		return "redirect:/login";
	}
	@RequestMapping("/errorLogin")//this is not the same error with this below. this is the root name, this below is the variable name for flash in the index.jsp page
	public String flashMessagesL(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorLog", "All the inputs are required and <br> You must enter valid inputs");
		return "redirect:/login";
	}
    
}