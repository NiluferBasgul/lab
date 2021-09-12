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
import wp.lab.service.TeacherService;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@Controller
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;


    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping({"/", "/courses"})
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

    @GetMapping("/courses/add")
    public String getAddCoursePage(Model model) {
        final List<Teacher> teachers = this.teacherService.findAll();
        model.addAttribute("teachers", teachers);

        return "/addCourse.html";
    }

    @PostMapping("/courses/add")
    public String saveCourse(@RequestParam Long teacherId,
                             @RequestParam String name,
                             @RequestParam String description){

        this.courseService.create(null,name,description,teacherId);

    return "redirect:/";

    }

    @PostMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        this.courseService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/courses/edit-form/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
        Course course = this.courseService.findById(id);
        model.addAttribute("course", course);
        return "add-course.html";
    }
}
