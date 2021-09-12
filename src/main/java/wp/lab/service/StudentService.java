package wp.lab.service;

import wp.lab.model.Student;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
public interface StudentService {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text, String surname);
    Student save(String username, String password, String name, String surname);
}
