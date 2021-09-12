package wp.lab.service;

import wp.lab.model.Course;
import wp.lab.model.Student;
import wp.lab.model.Teacher;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
public interface CourseService {
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    List<Course> listAll();
    Course create(Long courseId, String name, String description, Long teacher);
    public void delete(Long courseId);
    Course findById(Long id);

}
