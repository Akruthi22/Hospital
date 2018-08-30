package com.assignment.repositories;

import com.assignment.dbconnection.Dbconnection;
import com.assignment.model.Login;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Map;

@Repository
public class LoginRepository {

    public Map checkLogin(Login login) {
        Dbconnection dbConnection = new Dbconnection();
        Connection connection = dbConnection.createConnection();
        Map hashMap = dbConnection.getUser(connection, login);
        return hashMap;

    }
}