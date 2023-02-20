package com.jpmc.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {


    public static void main(String[] args) {

        //Create Session Factory
        SessionFactory factory = new Configuration().configure("file:src/main/resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            int studentId =10;


            //start transaction
            session.beginTransaction();

            //retrieve the student based on primary key
            System.out.println("Saved Student. Generated Id: "+studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Delete student name");

            //session.delete(myStudent);

            //2nd wauy to delete

            session.createQuery("delete from Student where id=10").executeUpdate();


            System.out.println("Update Complete : "+myStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Updating sutdent with Student ID =1 is done");



        }
        catch (Exception e){
            factory.close();
        }
    }
}
