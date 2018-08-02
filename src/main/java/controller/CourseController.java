package controller;

import entity.Course;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.CourseRepository;
import repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("courses",  courseRepository.findAll() );
        return "course/list";
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("course", new Course());
        return "/course/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Course course, BindingResult result){
        if (result.hasErrors()) {
            return "course/form";
        }
        courseRepository.save(course);
        return "redirect:/course";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "/course/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Course course) {
        courseRepository.save(course);
        return "redirect:/course";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        courseRepository.delete(id);
        return "redirect:/course";
    }

    @ModelAttribute("employees")
    public List<Employee> modelCourses() {
        return employeeRepository.findAll();
    }

}
