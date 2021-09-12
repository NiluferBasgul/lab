package wp.lab.repository.impl;

import org.springframework.stereotype.Repository;
import wp.lab.bootstrap.DataHolder;
import wp.lab.model.Teacher;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */

@Repository
public class InMemoryTeacherRepository  {

    public List<Teacher> findAll() {
        return DataHolder.teacherList;
    }
}
