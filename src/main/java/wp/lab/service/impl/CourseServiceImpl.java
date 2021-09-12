package wp.lab.service.impl;

import org.springframework.stereotype.Service;
import wp.lab.model.Course;
import wp.lab.model.Student;
import wp.lab.model.Teacher;
import wp.lab.repository.CourseRepository;
import wp.lab.repository.StudentRepository;
import wp.lab.service.CourseService;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        final Course course = this.courseRepository.findById(courseId);

        return course.getStudents();

    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        final Course course = this.courseRepository.findById(courseId);
        final Student student = this.studentRepository.findByUsername(username);

        return this.courseRepository.addStudentToCourse(student, course);
    }

    @Override
    public List<Course> listAll() {
        return this.courseRepository.findAllCourses();
    }

    @Override
    public Course create(Long courseId, String name, String description, Teacher teacher) {
        Course course = this.courseRepository.findById(courseId);
        return this.courseRepository.save(course);

    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id);
    }


}
