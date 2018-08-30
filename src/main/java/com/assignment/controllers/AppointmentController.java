package com.assignment.controllers;

import com.assignment.model.Doctor;
import com.assignment.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AppointmentController {
    String docName, specialization, day, time;
    String userName;


    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value = "/bookappointment", method = RequestMethod.POST)
    public ModelAndView bookAppointment(@ModelAttribute Doctor doctor) {

        this.docName = doctor.getDocName();
        this.specialization = doctor.getSpecialization();
        this.day = doctor.getDay();
        this.time = doctor.getTime();


        ModelAndView modelAndView = new ModelAndView("bookappointment");
        modelAndView.addObject("doctor", doctor);
        return modelAndView;
    }

    @RequestMapping(value = "/confirmAppointment", method = RequestMethod.POST)
    public ModelAndView confirmAppointment(String userName) {

        Doctor doctor = new Doctor(docName, specialization, day, time);


        appointmentService.confirmAppointment(doctor, userName);

        return new ModelAndView("loginHome");

    }

    @RequestMapping(value = "/myAppointments")
    public ModelAndView myAppointments() {


        return new ModelAndView("myappointments");

    }

    @RequestMapping(value = "/viewAppointments", method = RequestMethod.POST)
    public ModelAndView viewAppointments(String userName) {

        this.userName = userName;
        Map map = appointmentService.viewAppointments(userName);

        Doctor doctor = new Doctor((String) map.get("docName"),
                (String) map.get("specialization"),
                (String) map.get("day"),
                (String) map.get("time"));

        ModelAndView modelAndView = new ModelAndView("changeappointment");
        modelAndView.addObject("doctors", doctor);

        return modelAndView;


    }

    @RequestMapping(value = "/deleteAppointment")
    public ModelAndView deleteAppointment(@ModelAttribute Doctor doctor) {

        appointmentService.deleteAppointments(doctor, userName);

        return new ModelAndView("loginHome");


    }


//    @RequestMapping(value = "/myAppointments")
//    public ModelAndView myAppointments() {
//
//
//    }
}
