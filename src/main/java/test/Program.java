package test;

import dao.StudentDao;
import daoImpl.CollegeDaoImpl;
import daoImpl.StudentDaoImpl;
import daoImpl.TeacherDaoImpl;
import model.College;
import model.Student;
import model.Teacher;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Student student1 = new Student("Sindy","Loya","Los Angeles","Java");
        Student student2 = new Student("Christiano","Ronaldo","Madrid","Oracle");
        Student student3 = new Student("Diego","Maradona","Napoli" ,"java");

        Teacher teacher1 = new Teacher ("George","Orwell","London",120000);
        Teacher teacher2 = new Teacher ("Jacques","Brel","Bobigny",90000);
        Teacher teacher3 = new Teacher("Johnny","Cash","Nashville",75000);

        College college1 = new College("Montreal College");

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

        StudentDao sDao = new StudentDaoImpl();
        sDao.insert(student1);
        sDao.insert(student2);
        sDao.insert(student3);

        TeacherDaoImpl tDao = new TeacherDaoImpl();
        tDao.insert(teacher1);
        tDao.insert(teacher2);
        tDao.insert(teacher3);


        List<Student> students = sDao.findAll();
        System.out.println("Students on database: ");
        for(Student s : students) {
            System.out.println(s.toString());
        }

        System.out.println("*******************");
        List<Teacher> teachers = tDao.findAll();
        System.out.println("Teachers on database: ");
        for(Teacher t : teachers) {
            System.out.println(t.toString());
        }

        System.out.println("*******************");
        List<College> colleges = cDao.findAll();
        System.out.println("Colleges on database: ");
        for(College c : colleges) {
            System.out.println(c.toString());
        }
    }
}
