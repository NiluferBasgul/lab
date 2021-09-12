package wp.lab.repository.impl;

import org.springframework.stereotype.Repository;
import wp.lab.bootstrap.DataHolder;
import wp.lab.model.Course;
import wp.lab.model.Student;
import wp.lab.repository.CourseRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nilufer
 * @project lab
 */

@Repository
public class InMemoryCourseRepository implements CourseRepository {


    @Override
    public List<Course> findAllCourses() {
        return DataHolder.courseList;
    }

    @Override
    public Course findById(Long courseId) {
        return DataHolder.courseList.stream().filter(r->r.getCourseId().equals(courseId)).findFirst().orElseThrow();
    }

    @Override
    public List<Student> findAllStudentsByCourse(Long courseId) {
        return DataHolder.allStudentList.stream()
                .filter(std -> DataHolder.courseList.stream()
                        .anyMatch(c ->
                                c.getCourseId().equals(courseId)))
                .collect(Collectors.toList());
    }

    @Override
    public Course addStudentToCourse(Student student, Course course) {
        final Course foundCourse = DataHolder.courseList.stream().
                filter(c -> c.getCourseId().
                        equals(course.getCourseId())).
                findFirst().
                orElseThrow();

        final List<Student> newStudentList = foundCourse.students;
        newStudentList.add(student);

        foundCourse.setStudents(newStudentList);

        DataHolder.courseList.add(course);
        return foundCourse;
    }

    public Course save(Course c) {
        if (c==null || c.getName().isEmpty()) {
            return null;
        }
        DataHolder.courseList.removeIf(r->r.getName().equals(c.getName()));
        DataHolder.courseList.add(c);
        return c;
    }

    @Override
    public void deleteById(Long courseId) {
        DataHolder.courseList.removeIf(r->r.getCourseId().equals(courseId));
    }

}
