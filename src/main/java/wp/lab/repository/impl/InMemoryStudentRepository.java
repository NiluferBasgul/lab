package wp.lab.repository.impl;

import org.springframework.stereotype.Repository;
import wp.lab.bootstrap.DataHolder;
import wp.lab.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nilufer
 * @project lab
 */
@Repository
public class InMemoryStudentRepository  {
    public List<Student> findAllStudents() {
        return DataHolder.allStudentList;
    }

    public List<Student> findAllByNameOrSurname(String text) {
        return DataHolder.allStudentList.stream().filter(i -> i.getName().contains(text) || i.getSurname().contains(text)).collect(Collectors.toList());

    }

    public Student findByUsername(String username) {
        return DataHolder.allStudentList.stream().filter(r->r.getUsername().equals(username)).findFirst().orElseThrow();
    }
}
