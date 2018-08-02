package controller;

import entity.Course;
import entity.CourseId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import repository.CourseIdRepository;
import repository.CourseRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courseId")
public class CourseIdController {

    @Autowired
    CourseIdRepository courseIdRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("coursesIds",  courseIdRepository.findAll() );
        return "courseId/list";
    }

    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("courseId", new CourseId());
        return "/courseId/form";
    }

    @PostMapping("/form")
    public String addForm(@Valid CourseId courseId, BindingResult result){
        if (result.hasErrors()) {
            return "courseId/form";
        }
        courseIdRepository.save(courseId);
        return "redirect:/courseId";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id){
        CourseId courseId = courseIdRepository.findById(id);
        model.addAttribute("courseId", courseId);
        return "/courseId/form";
    }

    @PostMapping("/edit/{id}")
    public String editForm (Model model, @PathVariable long id, @ModelAttribute CourseId courseId) {
        courseIdRepository.save(courseId);
        return "redirect:/courseId";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        courseIdRepository.delete(id);
        return "redirect:/courseId";
    }

    @ModelAttribute("courses")
    public List<Course> modelCourses() {
        return courseRepository.findAll();
    }


}
