package dao;

import model.Teacher;

public interface TeacherDao {
    void insert(Teacher college);
    Teacher findById(int id);
    void delete(int id);
}
