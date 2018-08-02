package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String student_group;
    private String faculty;
    private String major;
    private Integer year;
    private Integer semester;

    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private String room;


    @ManyToOne
    @JoinColumn
    private Employee employee;

    @OneToMany
    private List<CourseId> courseIds = new ArrayList<>();


}
