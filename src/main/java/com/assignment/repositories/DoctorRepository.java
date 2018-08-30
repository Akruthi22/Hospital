package com.assignment.repositories;

import com.assignment.dbconnection.Dbconnection;
import com.assignment.model.Doctor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class DoctorRepository {

    public void getDoctorsList(Doctor doctor) {

        Dbconnection dbConnection = new Dbconnection();
        Connection connection = dbConnection.createConnection();


    }
}