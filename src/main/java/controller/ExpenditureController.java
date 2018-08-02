package controller;

import entity.Employee;
import entity.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.EmployeeRepository;
import repository.ExpenditureRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/expenditure")
public class ExpenditureController {

    @Autowired
    ExpenditureRepository expenditureRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String showAll(Model model){
        List<Expenditure> expenditures = expenditureRepository.findAll();

        double sum = expenditures.stream().filter(o -> o.getValue() > 10).mapToDouble(o -> o.getValue()).sum();
        model.addAttribute("sum", sum);

        model.addAttribute("expenditures",  expenditures );

        return "expenditure/list";
    }

    @GetMapping("/department/{id}")
    public String showAllFromDepartment(Model model, @PathVariable long id){
        List<Expenditure> expenditures = expenditureRepository.findExpenditureByDepartment(id);

        double sum = expenditures.stream().filter(o -> o.getValue() > 10).mapToDouble(o -> o.getValue()).sum();
        model.addAttribute("sum", sum);
        model.addAttribute("expenditures",  expenditures );
        return "expenditure/list";
    }

    @GetMapping("/employee/{id}")
    public String showAllFromEmployee(Model model, @PathVariable long id){
        List<Expenditure> expenditures = expenditureRepository.findByEmployeeId(id);

        double sum = expenditures.stream().filter(o -> o.getValue() > 10).mapToDouble(o -> o.getValue()).sum();
        model.addAttribute("sum", sum);
        model.addAttribute("expenditures",  expenditures );
        return "expenditure/list";
    }


    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("expenditure", new Expenditure());
        return "/expenditure/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Expenditure expenditure, BindingResult result){
        if (result.hasErrors()) {
            return "expenditure/form";
        }
        expenditureRepository.save(expenditure);
        return "redirect:/expenditure";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Expenditure expenditure = expenditureRepository.findById(id);
        model.addAttribute("expenditure", expenditure);
        return "/expenditure/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Expenditure expenditure) {
        expenditureRepository.save(expenditure);
        return "redirect:/expenditure";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        expenditureRepository.delete(id);
        return "redirect:/expenditure";
    }

    @ModelAttribute("employees")
    public List<Employee> modelExpenditures() {
        return employeeRepository.findAll();
    }

}
