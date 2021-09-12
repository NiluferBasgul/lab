package wp.lab.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@Entity
public class Course {

    @Id
    @GeneratedValue
    public Long courseId;
    public String name;
    public String description;

    @ManyToMany
    public List<Student> students;

    @ManyToMany
    public List<Teacher> teachers;

    @Enumerated
    private Type type = Type.ELECTIVE;

    public Course(Long courseId, String name, String description, List<Student> students, List<Teacher> teachers) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.students = students;
        this.teachers = teachers;
    }

    public Course() {

    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
