package wp.lab.service.impl;

import org.springframework.stereotype.Service;
import wp.lab.model.Teacher;
import wp.lab.repository.TeacherRepository;
import wp.lab.service.TeacherService;

import java.util.List;

/**
 * @author nilufer
 * @project lab
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }



}
