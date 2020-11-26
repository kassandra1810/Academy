package demo;

import entity.Lecturer;
import entity.Subject;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import java.sql.Date;

public class CreateSubjectAndLecturerDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Subject.class)
                                .addAnnotatedClass(Lecturer.class)
                                .buildSessionFactory();
        // create a session
        Session session = factory.getCurrentSession();
        try {

            // start the transaction
            session.beginTransaction();

            // create the Subject
            Subject tempSubject = new Subject("Matematyka dyskretna 1", "MAD1");

            // save the subject
            session.save(tempSubject);

            // create the lecturer
            String lBdate = "1965-11-12";
            Date bdate = Date.valueOf(lBdate);

            Lecturer tempLecturer = new Lecturer("Jan", "Kowalski", bdate, "Doktor", "Politechnika Warszawska", "wykładowca");

            // add lecturer to subject
            tempSubject.addLecturer(tempLecturer);

            // save lecturer
            session.save(tempLecturer);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            // add cleanup code
            session.close();
            factory.close();
        }



    }
}
