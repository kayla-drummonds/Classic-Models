package hibernate.demo;

import java.util.Date;
import java.util.List;

import hibernate.demo.dao.OrderDAO;
import hibernate.demo.model.Order;


/**
 * Hello world!
 *
 */
public class HibernateDemoMain {
    public static void main(String[] args) {
	OrderDAO orderDAO = new OrderDAO();
	
	Order x = orderDAO.findByOrderNumber(10100);	
	
	System.out.println(x.toString());
	
	x.setStatus("PENDING");
	x.setShippedDate(new Date());
	
	orderDAO.save(x);
	System.out.println(x.toString());
	
	List<Order> orders = orderDAO.findByStatus("Cancelled");
	for(Order order : orders) {
	    System.out.println(order.toString());
	}
    }
}
