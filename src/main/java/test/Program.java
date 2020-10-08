package test;

import dao.StudentDao;
import daoImpl.CollegeDaoImpl;
import daoImpl.StudentDaoImpl;
import daoImpl.TeacherDaoImpl;
import model.College;
import model.Student;
import model.Teacher;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Student student1 = new Student("Sindy","Loya","Los Angeles","Java");
        Student student2 = new Student("Christiano","Ronaldo","Madrid","Oracle");
        Student student3 = new Student("Diego","Maradona","Napoli" ,"java");

        Set<Student> studentList = new HashSet<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Teacher teacher1 = new Teacher ("George","Orwell","London",120000);
        Teacher teacher2 = new Teacher ("Jacques","Brel","Bobigny",90000);
        Teacher teacher3 = new Teacher("Johnny","Cash","Nashville",75000);

        Set<Teacher> teacherList = new HashSet<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);

        College college1 = new College("Montreal College", studentList, teacherList);

        StudentDao sDao = new StudentDaoImpl();
        sDao.insert(student1);
        sDao.insert(student2);
        sDao.insert(student3);

        TeacherDaoImpl tDao = new TeacherDaoImpl();
        tDao.insert(teacher1);
        tDao.insert(teacher2);
        tDao.insert(teacher3);

        //Relacionamento Student - College
        student1.setCollege(college1);
        student2.setCollege(college1);
        student3.setCollege(college1);

        //Relacionamento Teacher - College
        teacher1.setCollege(college1);
        teacher2.setCollege(college1);
        teacher3.setCollege(college1);

        CollegeDaoImpl cDao = new CollegeDaoImpl();
        cDao.insert(college1);

        Student student = sDao.findById(student1.getId());
        System.out.println("Student 1: " + student.toString());

        Teacher teacher = tDao.findById(teacher1.getId());
        System.out.println("Teacher 1: " + teacher.toString());

        College college = cDao.findById(college1.getId());
        System.out.println("College 1: " + college.toString());
    }
}
