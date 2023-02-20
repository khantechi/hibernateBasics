package com.jpmc.hibernate.entity.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {


    public static void main(String[] args) {

        //Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("C:\\Users\\Administrator\\IdeaProjects\\hibernateTutorials\\src\\main\\java\\com\\jpmc\\hibernate\\entity\\OneToOne\\hibernates.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
        //use the session object to save the java object
            System.out.println("Creating Instructor object");
Instructor instructor = new Instructor("kareem1","khan1","kkkk11Instructor@gmail.com");
InstructorDetail instructorDetail = new InstructorDetail("bloggerSpot1","Coding1");
            instructor.setInstructorDetail(instructorDetail);

       //begin transation
            System.out.println("Begin transaction");
            session.beginTransaction();

       //save instructor object, as we have CASCADE.ALL, it saves all tables
            System.out.println("Save the instructor,instructorDetail  object");
        session.save(instructor);

       //commit transaction
            System.out.println("Commit transaction");
        session.getTransaction().commit();

        }
        catch (Exception e){
            factory.close();
        }
    }
}
