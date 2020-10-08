package daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import dao.StudentDao;
import model.Student;
import util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	public void insert(Student student) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction tx = session.beginTransaction();
         try {
             session.save(student);
             tx.commit();
             session.close();
         } catch (HibernateException e) {
             if (tx != null) {
                 tx.rollback();
             }
            	e.printStackTrace();
		}
	}

	public Student findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Student student = null;
		try {
			student = session.get(Student.class, id);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return student;
	}

	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Student student = session.get(Student.class, id);
			session.delete(student);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}
}
