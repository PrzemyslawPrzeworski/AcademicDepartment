package repository;

import entity.Expenditure;
import entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    Expenditure findById(long id);
    List<Expenditure> findByEmployeeId(long id);


    @Query(value = "SELECT * FROM expenditure A INNER JOIN employee B ON A.employee_id = B.id WHERE B.department_id = :id", nativeQuery = true)
    List<Expenditure> findExpenditureByDepartment(@Param("id") Long id);


}
