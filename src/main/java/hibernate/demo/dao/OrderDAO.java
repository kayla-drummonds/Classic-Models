package hibernate.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.model.Order;

public class OrderDAO {
    
    SessionFactory factory;
    Session session;
    Transaction t;
    
    public OrderDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }
    
    public Order findByOrderNumber(Integer orderNumber) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Order o where o.orderNumber = :orderNumber";
	TypedQuery<Order> query = session.createQuery(hql, Order.class);
	query.setParameter("orderNumber", orderNumber);
	
	Order result = query.getSingleResult();
	
	t.commit();
	System.out.println("Successfully started hibernate demo project.");
	factory.close();
	session.close();
	
	return result;
    }
    
    public void save(Order order) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	session.merge(order);
	
	t.commit();
	System.out.println("Successfully saved order.");
	factory.close();
	session.close();
    }
    
    public List<Order> findByStatus(String status) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Order o where o.status = :stat";
	TypedQuery<Order> query = session.createQuery(hql, Order.class);
	query.setParameter("stat", status);
	
	List<Order> result = query.getResultList();
	
	t.commit();
	factory.close();
	session.close();
	
	return result;
    }
}
