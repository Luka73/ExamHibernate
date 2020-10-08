package daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import dao.StudentDao;
import model.Student;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

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

	public List<Student> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		criteria.from(Student.class);
		List<Student> students = session.createQuery(criteria).getResultList();
		return students;
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
