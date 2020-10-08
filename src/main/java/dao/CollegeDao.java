package dao;

import model.College;

public interface CollegeDao {
    void insert(College college);
    College findById(int id);
    void delete(int id);
}
