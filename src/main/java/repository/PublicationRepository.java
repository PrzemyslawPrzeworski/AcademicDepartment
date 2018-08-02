package repository;

import entity.CourseId;
import entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    Publication findById(long id);
    List<Publication> findByEmployeeId(long id);


    @Query(value = "SELECT * FROM publication A INNER JOIN employee B ON A.employee_id = B.id WHERE B.department_id = :id", nativeQuery = true)
    List<Publication> findPublicationByDepartment (@Param("id") Long id);


}
