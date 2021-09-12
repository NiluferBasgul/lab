package wp.lab.repository;

import wp.lab.model.Teacher;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
public interface TeacherRepository {
    List<Teacher> findAll();
}
