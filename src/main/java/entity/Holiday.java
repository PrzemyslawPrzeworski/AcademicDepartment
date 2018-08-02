package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "holiday")
@Getter
@Setter
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date holiday_start;

    private Date holiday_end;

    @Transient
    private String holiday_start_as_string;
    @Transient
    private String holiday_end_as_string;

//    @PreUpdate
    @PrePersist
    public void preUpdate() {
        try {
            holiday_start = new SimpleDateFormat("yyyy-MM-dd").parse(holiday_start_as_string);
            holiday_end = new SimpleDateFormat("yyyy-MM-dd").parse(holiday_end_as_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @ManyToOne
    @JoinColumn
    private Employee employee;


}
