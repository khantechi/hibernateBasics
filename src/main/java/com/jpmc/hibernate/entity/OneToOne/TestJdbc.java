package com.jpmc.hibernate.entity.OneToOne;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?userSSL=false&serverTimezone=UTC";
        String userID = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("Connectiing to databse");
            Connection myConn = DriverManager.getConnection(jdbcUrl,userID,pass);
            System.out.println("Connection is sucessful");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
