package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "publication")
@Getter
@Setter
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Date publicationDate;
    private String publicationDateAsString;
    private String journal;

    @ManyToOne
    private Employee employee;

    @PrePersist
    public void preUpdate() {
        try {
            System.out.println(publicationDateAsString);
            if (publicationDateAsString != null) {
                publicationDate = new SimpleDateFormat("yyyy-MM-dd").parse(publicationDateAsString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



}
