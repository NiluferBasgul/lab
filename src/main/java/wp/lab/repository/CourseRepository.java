package wp.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wp.lab.model.Course;
import wp.lab.model.Student;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
public interface CourseRepository {
    List<Course> findAllCourses();
    Course findById(Long courseId);
    List<Student> findAllStudentsByCourse(Long courseId);
    Course addStudentToCourse(Student student, Course course);
    public Course save(Course c);
    public void deleteById(Long courseId);


    }
