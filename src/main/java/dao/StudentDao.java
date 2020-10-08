package dao;

import model.Student;
import java.util.List;

public interface StudentDao{
	 void insert(Student student);
	 Student findById(int id);
	 List<Student> findAll();
	 void delete(int id);
}
