package hibernate.demo.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Customer;

public class CustomerDAO {
    SessionFactory factory;
    Session session;
    Transaction t;

    public CustomerDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }
    
    public Customer findByCustomerId(Integer id) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Customer c where c.id = :custId";
	TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
	query.setParameter("custId", id);
	
	Customer result = query.getSingleResult();
	
	t.commit();
	factory.close();
	session.close();
	
	return result;
    }
}
