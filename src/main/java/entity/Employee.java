package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Degree> degrees = new ArrayList<>();

    private String name;
    private String surname;
    private String note;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Transient
    private String birthdateAsString;


    private Date birthdate;

//    @PreUpdate
    @PrePersist
    public void preUpdate() {
        try {
            System.out.println(birthdateAsString);
            if (birthdateAsString != null) {
                birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdateAsString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Email
    private String email;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Publication> publications = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Expenditure> expenditures = new ArrayList<>();

    @ManyToOne
    private Department department;


    @OneToMany(mappedBy = "employee")
    private List<Holiday> holidays = new ArrayList<>();


    @ManyToMany
    private List<Fund> funds = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Schedule> schedules = new ArrayList<>();

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
