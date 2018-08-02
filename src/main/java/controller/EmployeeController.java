package controller;

import entity.Course;
import entity.Degree;
import entity.Department;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.CourseRepository;
import repository.DegreeRepository;
import repository.DepartmentRepository;
import repository.EmployeeRepository;
import services.EmployeeService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DegreeRepository degreeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("")
    public String showAll(Model model){
//        employeeService
        List<Employee> all = employeeRepository.findAll();

        all.forEach(employee -> employee.setCourses(courseRepository.findAllByEmployeeId(employee.getId())));
        model.addAttribute("employees",  all);
        return "employee/list";
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("employee", new Employee());
        return "/employee/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()) {
            return "employee/form";
        }
        employee.setCreated(LocalDateTime.now());
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        System.out.println(employee.getCourses());
//        System.out.println(employee.getCourses().get(0).getSubject());
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        System.out.println(employee.getBirthdateAsString());
//        for (int i = 0; i < employee.getCourses().size(); i++) {
//            Course course = employee.getCourses().get(i);
//            employee.getCourses().set(i, courseRepository.findById(course.getId()));
//        }
//        employeeRepository.save(employee);
        employeeService.createEmployeeWithCourses(employee, employee.getCourses());
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Employee employee = employeeRepository.findById(id);
        if (employee.getBirthdate() != null) {
            employee.setBirthdateAsString(new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirthdate()));
        }
        model.addAttribute("employee", employee);
        return "/employee/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Employee employee) {
        employee.setUpdated(LocalDateTime.now());

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(employee.getBirthdateAsString());
        employee.preUpdate();
        System.out.println(employee.getBirthdate());
        Employee merged = employeeRepository.save(employee);
        merged.setBirthdateAsString(employee.getBirthdateAsString());
        System.out.println("DATA W MERGE: " + merged.getBirthdateAsString());
        employeeRepository.save(merged);
        return "redirect:/employee";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        employeeRepository.delete(id);
        return "redirect:/employee";
    }


    @ModelAttribute("allDegrees")
    public List<Degree> modelDegrees() {
        return  degreeRepository.findAll();
    }

    @ModelAttribute("courses")
    public List<Course> modelCourses() {
        return courseRepository.findAll();
    }

    @ModelAttribute("departments")
    public List<Department> modelDepartments() {
        return departmentRepository.findAll();
    }


//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(       Date.class,
//                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true, 10));
//    }
}
