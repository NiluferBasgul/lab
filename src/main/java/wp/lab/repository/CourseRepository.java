package wp.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wp.lab.model.Course;
import wp.lab.model.Student;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
}
