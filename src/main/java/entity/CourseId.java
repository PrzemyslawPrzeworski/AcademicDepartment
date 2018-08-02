package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "course_id")
@Getter
@Setter
public class CourseId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String student_group;
    private String faculty;
    private String major;
    private Integer year;
    private Integer semester;

    @ManyToOne
    private Course course;


}
