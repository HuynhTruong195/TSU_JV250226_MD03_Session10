package ex.jv.Repository;

import ex.jv.Model.Entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(long studentId);
    Boolean save(Student student);
    Boolean update(Student student);
    Boolean delete(long studentId);
    List<Student> findByName(String studentName);
}
