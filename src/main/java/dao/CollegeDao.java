package dao;

import model.College;
import model.Student;
import java.util.List;

public interface CollegeDao {
    void insert(College college);
    College findById(int id);
    List<College> findAll();
    void delete(int id);
}
