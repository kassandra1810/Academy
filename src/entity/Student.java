package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.sql.Date;

@Entity(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends Person {

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "studies_start_date")
    private Date studiesStartDate;

    @Column(name = "studies_end_date")
    private Date studiesEndDate;

    public Student() {}

    public Student(String firstName, String lastName, Date birthDate, String idNumber, Date studiesStartDate, Date studiesEndDate) {
        super(firstName, lastName, birthDate);
        this.idNumber = idNumber;
        this.studiesStartDate = studiesStartDate;
        this.studiesEndDate = studiesEndDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getStudiesStartDate() {
        return studiesStartDate;
    }

    public void setStudiesStartDate(Date studiesStartDate) {
        this.studiesStartDate = studiesStartDate;
    }

    public Date getStudiesEndDate() {
        return studiesEndDate;
    }

    public void setStudiesEndDate(Date studiesEndDate) {
        this.studiesEndDate = studiesEndDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + this.getFirstName() + '\'' +
                "lastName='" + this.getLastName() + '\'' +
                "birthdate='" + this.getBirthDate() + '\'' +
                "idNumber='" + idNumber + '\'' +
                ", studiesStartDate=" + studiesStartDate +
                ", studiesEndDate=" + studiesEndDate +
                '}';
    }
}
