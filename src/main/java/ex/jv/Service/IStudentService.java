package ex.jv.Service;

import ex.jv.Model.DTO.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();
    StudentDTO findById(long studentId);
    Boolean save(StudentDTO studentDTO);
    Boolean update(StudentDTO studentDTO);
    Boolean delete(long studentId);
    List<StudentDTO> findByName(String studentName);
}
