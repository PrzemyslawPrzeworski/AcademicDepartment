package controller;

import entity.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.DegreeRepository;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/degree")
public class DegreeController {

    @Autowired
    DegreeRepository degreeRepository;

//    @GetMapping("/aaa/{first}/{second}")
//    @ResponseBody
//    public String aaa(@PathVariable int first, @PathVariable int second){
//
//        Principal userPrincipal = request.getUser
//        model.addAttribute("allDegrees",  degreeRepository.findAll() );
//        return "degree/list";
//    }

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("degrees",  degreeRepository.findAll() );
        return "degree/list";
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("degree", new Degree());
        return "/degree/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid Degree degree, BindingResult result){
        if (result.hasErrors()) {
            return "degree/form";
        }
        degreeRepository.save(degree);
        return "redirect:/degree";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        Degree degree = degreeRepository.findById(id);
        model.addAttribute("degree", degree);
        return "/degree/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute Degree degree) {
        degreeRepository.save(degree);
        return "redirect:/degree";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        degreeRepository.delete(id);
        return "redirect:/degree";
    }




}
