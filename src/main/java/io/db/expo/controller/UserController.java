package io.db.expo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.db.expo.entity.User;
import io.db.expo.service.SecurityService;
import io.db.expo.service.UserService;
import io.db.expo.validator.UserValidator;



@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    

    

    
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/registration")
    public String displayRegistraionForm(Model model) {
    	
    	LOG.info("**INSIDE displayRegistraionForm**");
    	model.addAttribute("userForm", new User());
        return ".Registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
    	LOG.info("**INSIDE registerUser**");
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
        	LOG.info("**INSIDE hasErrors**");
        	return ".Registration";
        }

        userService.saveUser(userForm);
        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());

        return "redirect:/index";
    }

    @GetMapping({"/login","/logout"})
    public String login(Model model, String error, String logout) {
    	
    	LOG.info("**INSIDE /login/logout**");
    	
    	LOG.debug("**DEBUGGING: error: " + error + "and logout: " + logout);
    	
        if (error != null) {
        	LOG.info("**INSIDE error**");
        	model.addAttribute("error", "Your username and password is invalid.");
        }
            
        if (logout != null) {
        	
        	model.addAttribute("message", "You have been logged out successfully.");
        }
        return ".Login";
    }


}