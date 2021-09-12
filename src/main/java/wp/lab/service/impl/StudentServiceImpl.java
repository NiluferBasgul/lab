package wp.lab.service.impl;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.stereotype.Service;
import wp.lab.bootstrap.DataHolder;
import wp.lab.model.Student;
import wp.lab.repository.StudentRepository;
import wp.lab.service.StudentService;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text, String surname) {
        return this.studentRepository.findAllByNameOrSurname(text, surname);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        return null;
    }
}
