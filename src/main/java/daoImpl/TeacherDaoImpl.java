package daoImpl;

import dao.TeacherDao;
import model.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TeacherDaoImpl implements TeacherDao {

    public void insert(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(teacher);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Teacher findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Teacher teacher = null;
        try {
            teacher = session.get(Teacher.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        return teacher;
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Teacher teacher = session.get(Teacher.class, id);
            session.delete(teacher);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }
}
