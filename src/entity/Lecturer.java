package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "lecturer")
@PrimaryKeyJoinColumn(name = "id")
public class Lecturer extends Person {

    @Column(name = "academic_degree")
    private String academicDegree;

    @Column(name = "finished_studies")
    private String finishedStudies;

    @Column(name = "position")
    private String position;

    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="lecturer_subject",
            joinColumns=@JoinColumn(name="id_lecturer"),
            inverseJoinColumns=@JoinColumn(name="id_subject")
    )
    private List<Subject> subjects;

    public Lecturer() {}

    public Lecturer(String firstName, String lastName, Date birthDate, String academicDegree, String finishedStudies, String position) {
        super(firstName, lastName, birthDate);
        this.academicDegree = academicDegree;
        this.finishedStudies = finishedStudies;
        this.position = position;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getFinishedStudies() {
        return finishedStudies;
    }

    public void setFinishedStudies(String finishedStudies) {
        this.finishedStudies = finishedStudies;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "firstName='" + this.getFirstName() + '\'' +
                "lastName='" + this.getLastName() + '\'' +
                "birthdate='" + this.getBirthDate() + '\'' +
                "academicDegree='" + academicDegree + '\'' +
                ", finishedStudies='" + finishedStudies + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
