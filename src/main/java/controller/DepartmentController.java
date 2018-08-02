package controller;

import entity.Employee;
import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.EmployeeRepository;
import repository.DepartmentRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("departments",  departmentRepository.findAll() );
        return "department/list";
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("department", new Department());
        return "/department/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Department department, BindingResult result){
        if (result.hasErrors()) {
            return "department/form";
        }
        departmentRepository.save(department);
        return "redirect:/department";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Department department = departmentRepository.findById(id);
        model.addAttribute("department", department);
        return "/department/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:/department";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        departmentRepository.delete(id);
        return "redirect:/department";
    }

    @ModelAttribute("employees")
    public List<Employee> modelDepartments() {
        return employeeRepository.findAll();
    }

}
