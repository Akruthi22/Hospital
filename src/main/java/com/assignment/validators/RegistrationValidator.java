package com.assignment.validators;

import com.assignment.model.Registration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Registration.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Registration registration = (Registration)o;
        System.out.println("inside validate");
        if (registration.getFirstName() == null || registration.getFirstName().equals("")) {
            System.out.println("firstname is empty or null");
            errors.rejectValue("firstName","registration.firstName","firstname cannot be empty");

        }
        if (registration.getLastName() == null || registration.getLastName().equals("")) {
            System.out.println("lastname is empty or null");
            errors.rejectValue("lastName","registration.lasttName","lastname cannot be empty");

        }
        if (registration.getGender() == null || registration.getGender().equals("")) {
            System.out.println("Gender is empty or null");
            errors.rejectValue("gender","registration.gender","gender cannot be empty");

        }
        if (registration.geteMail() == null || registration.geteMail().equals("")) {
            System.out.println("Email is empty or null");
            errors.rejectValue("eMail","registration.eMail","email cannot be empty");

        }
        if (registration.getUserName() == null || registration.getUserName().equals("")) {
            System.out.println("username is empty or null");
            errors.rejectValue("userName","registration.userName","Username cannot be empty");

        }
        if (registration.getPassword() == null || registration.getPassword().equals("")) {
            System.out.println("password is empty or null");
            errors.rejectValue("password","registration.password","password cannot be empty");

        }
    }
}
