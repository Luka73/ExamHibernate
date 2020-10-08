package dao;

import model.Student;
import model.Teacher;
import java.util.List;

public interface TeacherDao {
    void insert(Teacher college);
    Teacher findById(int id);
    List<Teacher> findAll();
    void delete(int id);
}
