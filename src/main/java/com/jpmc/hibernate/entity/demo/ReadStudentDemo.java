package com.jpmc.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {


    public static void main(String[] args) {

        //Create Session Facory
        SessionFactory factory = new Configuration().configure("file:src/main/resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save the java object
            System.out.println("Creating Student object");
            Student student = new Student("Daffy","duck","Daffy.duck@gmail.com");

            //begin transation
            System.out.println("Begin transaction");
            session.beginTransaction();
            //save Student object
            System.out.println("Save the Student object");
            System.out.println(student);
            session.save(student);

            //commit transaction
            System.out.println("Commit transaction");
            session.getTransaction().commit();

            System.out.println("DONE");

            //To retrieve java object

            //get new session
            session = factory.getCurrentSession();
            //start transaction
            session.beginTransaction();

            //retrieve the student based on primary key
            System.out.println("Saved Student. Generated Id: "+student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get Complete : "+myStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Getting java object is done");


        }
        catch (Exception e){
            factory.close();
        }
    }
}
