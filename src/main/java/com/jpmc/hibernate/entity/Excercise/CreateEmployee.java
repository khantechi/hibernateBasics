package com.jpmc.hibernate.entity.Excercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateEmployee {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();



        try{
            System.out.println("Creating Employee Object");
            Employee employee = new Employee("kareem","khan","JPMC");
            System.out.println("Begin Transaction");
        session.beginTransaction();
            System.out.println("Saving Employee Object");
        session.save(employee);
            System.out.println("Committing Employee Object");
        session.getTransaction().commit();
            System.out.println("Creating Employee Object --- DONE");

        }catch(Exception e){
            factory.close();
        }
    }



}
