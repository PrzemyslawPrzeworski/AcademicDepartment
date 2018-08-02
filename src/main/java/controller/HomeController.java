package controller;

import entity.Department;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.CourseRepository;
import repository.DepartmentRepository;
import repository.EmployeeRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("")
    public String showAll(Model model){
        List<Employee> all = employeeRepository.findAll();
        all.forEach(employee -> employee.setCourses(courseRepository.findAllByEmployeeId(employee.getId())));
        model.addAttribute("employees",  all);
        return "employee/list";
    }

    @ModelAttribute("departments")
    public List<Department> modelDepartments() {
        return departmentRepository.findAll();
    }
}
