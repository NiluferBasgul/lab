package wp.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wp.lab.model.Student;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAll();
    List<Student> findAllByNameOrSurname(String text, String surname);
    Student findByUsername(String username);

}
