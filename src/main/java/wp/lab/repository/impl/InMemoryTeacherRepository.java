package wp.lab.repository.impl;

import org.springframework.stereotype.Repository;
import wp.lab.bootstrap.DataHolder;
import wp.lab.model.Teacher;
import wp.lab.repository.TeacherRepository;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@Repository
public class InMemoryTeacherRepository implements TeacherRepository {
    @Override
    public List<Teacher> findAll() {
        return DataHolder.teacherList;
    }
}
