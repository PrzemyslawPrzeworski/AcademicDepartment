package services;

import entity.Course;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CourseRepository;
import repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CourseRepository courseRepository;

    public void createEmployeeWithCourses(Employee employee, List<Course> courses) {

//        List<Long> ids = courses.stream().map(course -> course.getId()).collect(Collectors.toList());
//        List<Course> mergedCourses = courseRepository.findAll(ids);
//        mergedCourses.forEach(course -> course.setId(null));
//        mergedCourses.forEach(course -> course.setEmployee(employee));
        employee.getCourses().forEach(course -> course.setEmployee(employee));
        employee.getCourses().forEach(course -> course.setId(null));
//        employee.setCourses(mergedCourses);
        employeeRepository.save(employee);
    }
}
