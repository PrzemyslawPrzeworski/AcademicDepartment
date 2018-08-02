package repository;

import entity.Course;
import entity.CourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseIdRepository extends JpaRepository<CourseId, Long> {

    CourseId findById(long id);

//    List<CourseId> findAllByEmployeeId(Long id);

}
