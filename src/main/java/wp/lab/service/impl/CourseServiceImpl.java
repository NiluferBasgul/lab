package wp.lab.service.impl;

import org.springframework.stereotype.Service;
import wp.lab.model.Course;
import wp.lab.model.Student;
import wp.lab.model.Teacher;
import wp.lab.model.exceptions.InvalidCourseCredentials;
import wp.lab.repository.CourseRepository;
import wp.lab.repository.StudentRepository;
import wp.lab.repository.TeacherRepository;
import wp.lab.service.CourseService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        final Course course = this.courseRepository.findById(courseId).orElseThrow(InvalidCourseCredentials::new);

        return course.getStudents();
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        final Course course = this.courseRepository.findById(courseId).orElseThrow(InvalidCourseCredentials::new);
        final Student student = this.studentRepository.findByUsername(username);

        course.getStudents().add(student);

        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> listAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course create(Long courseId, String name, String description, Long teacherId) {
        final List<Teacher> teachers = new ArrayList<>();
        final Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(InvalidCourseCredentials::new);

        teachers.add(teacher);

        Course course = new Course(courseId,name,description,null, teachers);
        courseRepository.save(course);
        return null;

    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(InvalidCourseCredentials::new);
    }


}
