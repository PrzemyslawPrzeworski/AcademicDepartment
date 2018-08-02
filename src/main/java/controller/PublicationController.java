package controller;

import entity.Publication;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.PublicationRepository;
import repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("publications",  publicationRepository.findAll() );
        return "publication/list";
    }

    @GetMapping("/department/{id}")
    public String showAllFromDepartment(Model model, @PathVariable long id){
        model.addAttribute("publications",  publicationRepository.findPublicationByDepartment(id) );
        return "publication/list";
    }

    @GetMapping("/employee/{id}")
    public String showAllFromEmployee(Model model, @PathVariable long id){
        model.addAttribute("publications",  publicationRepository.findByEmployeeId(id) );
        return "publication/list";
    }


    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("publication", new Publication());
        return "/publication/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Publication publication, BindingResult result){
        if (result.hasErrors()) {
            return "publication/form";
        }
        publicationRepository.save(publication);
        return "redirect:/publication";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Publication publication = publicationRepository.findById(id);
        model.addAttribute("publication", publication);
        return "/publication/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Publication publication) {
        publicationRepository.save(publication);
        return "redirect:/publication";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        publicationRepository.delete(id);
        return "redirect:/publication";
    }

    @ModelAttribute("employees")
    public List<Employee> modelPublications() {
        return employeeRepository.findAll();
    }

}
