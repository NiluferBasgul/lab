package wp.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wp.lab.model.Teacher;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
