package ex.jv.Service.Imp;

import ex.jv.Mapper.StudentMapper;
import ex.jv.Model.DTO.StudentDTO;
import ex.jv.Model.Entity.Student;
import ex.jv.Repository.IStudentRepository;
import ex.jv.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toDTO) // chuyển từng student sang studentDTO
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(long studentId) {
        return StudentMapper.toDTO(studentRepository.findById(studentId));
    }

    @Override
    public Boolean save(StudentDTO student) {
        return studentRepository.save(StudentMapper.toEntity(student));
    }

    @Override
    public Boolean update(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return false;
        }
        Student entity = StudentMapper.toEntity(studentDTO);
        studentRepository.update(entity);
        return true;
    }

    @Override
    public Boolean delete(long studentId) {
        return studentRepository.delete(studentId);
    }

    @Override
    public List<StudentDTO> findByName(String studentName) {
        return studentRepository.findByName(studentName)
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());

    }
}
