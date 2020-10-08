package dao;

import model.Student;

public interface StudentDao{
	 void insert(Student student);
	 Student findById(int id);
	 void delete(int id);
}
