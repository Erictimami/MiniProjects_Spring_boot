package com.codingdojo.authentification.controllers;

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

import com.codingdojo.authentification.models.User;
import com.codingdojo.authentification.services.UserService;

@Controller
public class UsersController {
	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/log_reg/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/log_reg/loginPage.jsp";
    }
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	if(result.hasErrors()) {
    		return "redirect:/errorRegistration";
    	} else if(user.getPassword().equals(user.getPasswordConfirmation()) && (userService.findByEmail(user.getEmail()) == null)) {
    		userService.registerUser(user);
    		session.setAttribute("logged", true);
    		session.setAttribute("id", user.getId());
    		return "redirect:/home";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
		return null;
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	if(userService.authentificateUser(email, password) == true) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("logged", true);
    		session.setAttribute("id", user.getId());
    		return "redirect:/home";
    	} else {
    		return "redirect:/errorLogin";
    	}
        // else, add error messages and return the login page
    }
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	if((session.getAttribute("logged").toString()).equals("false") == true) {
    		return "redirect:/login";
    	}
    	User user = userService.findUserById(Long.parseLong(session.getAttribute("id").toString()));
    	model.addAttribute("user", user);
    	return "/user/index.jsp";
    }
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
		return "redirect:/registration";
	}
	@RequestMapping("/errorLogin")//this is not the same error with this below. this is the root name, this below is the variable name for flash in the index.jsp page
	public String flashMessagesL(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorLog", "All the inputs are required and <br> You must enter valid inputs");
		return "redirect:/login";
	}
    
}
