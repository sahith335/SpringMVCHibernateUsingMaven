package com.mvc.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mvc.entity.Employee;
import com.mvc.interfaces.EmployeeDAO;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction t;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	@Override
	public void insertEmployee(Employee e) {
		
		session = sessionFactory.openSession();

		Transaction t = session.beginTransaction();

		session.persist(e);

		t.commit();

		session.close();

	}
	@Override
	public ArrayList<Employee> fetchAll() {
		
		session = sessionFactory.openSession();
		 t = session.beginTransaction();
		 Query<Employee> query = session.createQuery("from Employee");
		 return(ArrayList<Employee>) query.list();
		 

		
	}
	@Override
	public Employee fetchSpecific(int id) {
		session = sessionFactory.openSession();

		 t = session.beginTransaction();
		 Employee e = session.get(Employee.class, id);
		 return e;
	}
	@Override
	public Employee update(Employee e) {
		session = sessionFactory.openSession();
		 t = session.beginTransaction();
		 if(e!=null) {
		
			 session.merge(e);
		 }
		 t.commit();
		 return e;
		
	}
	@Override
	public void delete(int id) {
		session = sessionFactory.openSession();
		 t = session.beginTransaction();
		 Employee e = session.get(Employee.class, id);
		 if(e!=null)
		 {
			 session.remove(e);
			 
		 }
		 t.commit();
		 session.close();
	}
	
	
	
}
