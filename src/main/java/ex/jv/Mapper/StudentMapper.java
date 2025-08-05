package ex.jv.Mapper;

import ex.jv.Model.DTO.StudentDTO;
import ex.jv.Model.Entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentDTO dto) {
        return Student.builder()
                .id(dto.getId())
                .studentName(dto.getStudentName())
                .email(dto.getEmail())
                .ageMark(dto.getAgeMark())
                .isStudying(dto.getIsStudying())
                .build();
    }

    public static StudentDTO toDTO(Student entity) {
        return StudentDTO.builder()
                .id(entity.getId())
                .studentName(entity.getStudentName())
                .email(entity.getEmail())
                .ageMark(entity.getAgeMark())
                .isStudying(entity.getIsStudying())
                .build();
    }
}
