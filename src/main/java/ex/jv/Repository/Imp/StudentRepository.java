package ex.jv.Repository.Imp;

import ex.jv.Model.Entity.Student;
import ex.jv.Repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Student findById(long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    @Transactional
    public Boolean save(Student student) {
        try {
            entityManager.persist(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean update(Student student) {
        try {
            entityManager.merge(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean delete(long studentId) {
        try {
            entityManager.remove(findById(studentId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findByName(String studentName) {
        return entityManager.createQuery("from Student s where s.studentName like :studentName", Student.class)
                .setParameter("studentName", "%" + studentName.toLowerCase() + "%")
                .getResultList();
    }
}
