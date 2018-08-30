package com.assignment.controllers;


import com.assignment.model.Registration;
import com.assignment.services.RegistrationService;
import com.assignment.validators.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;


    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView viewRegistration(Model model) {
        model.addAttribute("registration",new Registration());


        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Validated @ModelAttribute("registration") Registration registration, BindingResult errors) {
        ModelAndView modelAndView=new ModelAndView();
        //registrationService.registerUser(registration);
        if(errors.hasErrors()) {
            System.out.println("errors");
            modelAndView.setViewName("registration");

//            return new ModelAndView("home");
            return modelAndView;
        }
        registrationService.registerUser(registration);
        modelAndView.setViewName("home");
        return modelAndView;


    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new RegistrationValidator());
    }
    /*@ExceptionHandler(value = NullPointerException.class)
    public String exception(){
        return "error";
    }*/

}