package com.jpmc.hibernate.entity.OneToOne;

import com.jpmc.hibernate.entity.demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {


    public static void main(String[] args) {

        //Create Session Facory
        SessionFactory factory = new Configuration().configure("hibernates.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
        //use the session object to save the java object
            System.out.println("Creating Student object");
        Student student = new Student("Kareem11","khan11","kareemk11.it@gmail.com");

       //begin transation
            System.out.println("Begin transaction");
            session.beginTransaction();
       //save Student object
            System.out.println("Save the Student object");
        session.save(student);

       //commit transaction
            System.out.println("Commit transaction");
        session.getTransaction().commit();

        }
        catch (Exception e){
            factory.close();
        }
    }
}
