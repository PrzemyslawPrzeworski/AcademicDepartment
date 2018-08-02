package entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DateTime calendar;

    @ManyToOne
    private Employee employee;



}
