package com.Initializer.Services;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Initializer.ModelClasses.Student;

@Repository
public class StudentDaoIMPL implements StudentDao {
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void saveStudent(Student student) {
		System.out.println("Dao Active Now");
		System.out.println(student);
		Session session = factory.openSession();
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		System.out.println("DATA NOW SAVED TO DB");
	}

	public List<Student> getAllStudentsRecord() {
		Session session = factory.openSession();
		Query q1 = session.createQuery("from Student ORDER BY rollno");
		List<Student> list1 = q1.getResultList();
		return list1;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query d1 = session.createQuery("delete from Student where rollno=:id");
		d1.setParameter("id", rollno);
		d1.executeUpdate();
		tx.commit();
		return getAllStudentsRecord();
	}

	@Override
	public Student editStudent(int rollno) {

		return factory.openSession().get(Student.class, rollno);
	}

	@Override
	public Student getSingleStudentData(int rollno, long mobileno) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Student where rollno=:id");
		q.setParameter("id", rollno);
		Student stu = (Student) q.getSingleResult();
		if (rollno == stu.getRollno() && mobileno == stu.getMobileno()) {
			return stu;
		} else
			return null;
	}

}
