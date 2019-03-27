package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sarthak on 2/27/19.
 */
public class DatabaseConnect {
    public static final String CONNECTION_STRING= "jdbc:sqLite:/Users/Sarthak/Desktop/DatabasePopulater/testjava1.db";
    public boolean open() {
                try(Connection conn = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = conn.createStatement()){
        statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        statement.execute("INSERT INTO contacts (name, phone, email)" + "VALUES('Tim', 765476, 'tim@gmail.com')");
        return true;
    }
        catch(SQLException e)
     {
            System.out.printf("Something went wrong: " + e.getMessage());
        return false;
      }
    }






}
