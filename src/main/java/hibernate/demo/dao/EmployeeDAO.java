package hibernate.demo.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Employee;

public class EmployeeDAO {
    SessionFactory factory;
    Session session;
    Transaction t;

    public EmployeeDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }
    
    public Employee findByEmployeeId(Integer id) {
   	factory = new Configuration().configure().buildSessionFactory();
   	session = factory.openSession();
   	t = session.beginTransaction();
   	
   	String hql = "from Employee e where e.employeeNumber = :empId";
   	TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
   	query.setParameter("empId", id);
   	
   	Employee result = query.getSingleResult();
   	
   	t.commit();
   	factory.close();
   	session.close();
   	
   	return result;
       }
}
