package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fund")
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double services_expenditure;

    private Double chemicals_expenditure;

    private String note;

    @ManyToMany(mappedBy = "funds")
    private List<Employee> employees = new ArrayList<>();
}
