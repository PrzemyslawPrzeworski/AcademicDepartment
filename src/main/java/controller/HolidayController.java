package controller;

import entity.Employee;
import entity.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.EmployeeRepository;
import repository.HolidayRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/holiday")
public class HolidayController {

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("holidays",  holidayRepository.findAll() );
        return "holiday/list";
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("holiday", new Holiday());
        return "/holiday/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Holiday holiday, BindingResult result){
        if (result.hasErrors()) {
            return "holiday/form";
        }
        holidayRepository.save(holiday);
        return "redirect:/holiday";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Holiday holiday = holidayRepository.findById(id);
        model.addAttribute("holiday", holiday);
        return "/holiday/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Holiday holiday) {
        holiday.preUpdate();
        holidayRepository.save(holiday);
        return "redirect:/holiday";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        holidayRepository.delete(id);
        return "redirect:/holiday";
    }

    @ModelAttribute("employees")
    public List<Employee> modelCourses() {
        return employeeRepository.findAll();
    }
}
