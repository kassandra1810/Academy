package demo;

import entity.Lecturer;
import entity.Student;
import entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class CreateStudentAndLecturerDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Subject.class)
                                .addAnnotatedClass(Student.class)
                                .addAnnotatedClass(Lecturer.class)
                                .buildSessionFactory();
        // create a session
        Session session = factory.getCurrentSession();
        try {
            // start the transaction
            session.beginTransaction();

            // create the student
            String date = "1993-10-18";
            Date bdate = Date.valueOf(date);

            String sdate = "2016-10-01";
            Date ssdate = Date.valueOf(sdate);

            String edate = "2020-10-01";
            Date sedate = Date.valueOf(edate);

            Student tempStudent = new Student("Liliia", "Baluk", bdate, "s15421", ssdate, sedate);

            String lecBdate = "1977-06-15";
            Date ldate = Date.valueOf(lecBdate);
            Lecturer tempLecturer = new Lecturer("Tom", "Johnson", ldate, "Doktor", "PJATK", "wykładowca");

            // save the subject
            session.save(tempStudent);
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
