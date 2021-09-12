package wp.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wp.lab.model.Student;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
public interface StudentRepository {
    List<Student> findAllStudents();
    List<Student> findAllByNameOrSurname(String text);
    Student findByUsername(String username);

}
