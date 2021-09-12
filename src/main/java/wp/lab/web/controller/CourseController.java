package wp.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wp.lab.model.Course;
import wp.lab.model.Teacher;
import wp.lab.service.CourseService;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@Controller
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "courses");
        return "/listCourses.html";
    }

    @PostMapping("/courses/add")
    public String saveCourse(@PathVariable Long courseId,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Teacher teacher){
        this.courseService.create(courseId,name,description,teacher);

    return "redirect:/listCourses.html";

    }
    @PostMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        this.courseService.delete(id);
        return "redirect:/listCourses.html";
    }

    @GetMapping("/courses/edit-form/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
        Course course = this.courseService.findById(id);
        model.addAttribute("course", course);
        return "add-course.html";
    }
}
