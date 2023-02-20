package com.jpmc.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {


    public static void main(String[] args) {

        //Create Session Facory
        SessionFactory factory = new Configuration().configure("file:src/main/resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

       //begin transation
            System.out.println("Begin transaction");
            session.beginTransaction();

            //query students
            System.out.println("===========Querying all students ===================");
            List<Student>  theStudents = session.createQuery("from Student").list();
            DisplayStudents(theStudents);

            //query based on lastname
            System.out.println("===========Querying students based on lastName ===================");
            theStudents = session.createQuery("from Student s where s.lastName='khan1'").list();
            DisplayStudents(theStudents);

            //query based on lastname or firstName
            System.out.println("\n ===========Querying students based on lastName or firstName===================");
            theStudents = session.createQuery("from Student s where s.lastName='khan1' OR s.firstName='Kareem2'").list();
            DisplayStudents(theStudents);

            //query based on LIKE
            System.out.println("\n ===========Querying students based on LIKE ==================");
            theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
            DisplayStudents(theStudents);

            //query based on LIKE
            System.out.println("\n ===========Querying students based on LIKE ==================");
            theStudents = session.createQuery("from Student s where s.email LIKE '%@luv2code.com'").list();
            DisplayStudents(theStudents);



            //commit transaction
            System.out.println("Commit transaction");
        session.getTransaction().commit();

        }
        catch (Exception e){
            factory.close();
        }
    }

    private static void DisplayStudents(List<Student> theStudents) {
        for(Student teStudent : theStudents){
            System.out.println(teStudent);
        }
    }
}
