package com.assignment.repositories;

import com.assignment.dbconnection.Dbconnection;
import com.assignment.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class RegistrationRepository {



    public void registerUser(Registration registration) {
        Dbconnection dbConnection = new Dbconnection();
        Connection connection = dbConnection.createConnection();
        dbConnection.registerUser(connection, registration);

    }

}