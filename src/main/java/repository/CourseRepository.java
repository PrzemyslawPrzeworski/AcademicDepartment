package repository;

import entity.Course;
import entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findById(long id);

    List<Course> findAllByEmployeeId(Long id);

}
