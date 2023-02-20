package com.jpmc.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
//Create Session Facory
        SessionFactory factory = new Configuration().configure("file:src/main/resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //use the session object to save the java object
            System.out.println("Creating 3 Student object");
            Student student1 = new Student("Kareem1","khan1","kareemk1.it@gmail.com");
            Student student2 = new Student("Kareem2","khan2","kareemk2.it@gmail.com");
            Student student3 = new Student("Kareem3","khan3","kareemk3.it@gmail.com");

            //begin transation
            System.out.println("Begin transaction");
            session.beginTransaction();
            //save Student object
            System.out.println("Save the Student object");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //commit transaction
            System.out.println("Commit transaction");
            session.getTransaction().commit();

        }
        catch (Exception e){
            factory.close();
        }
    }
}
