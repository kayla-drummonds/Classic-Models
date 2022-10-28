package hibernate.demo;

// import java.util.Date;
// import java.util.List;

import hibernate.demo.dao.CustomerDAO;
import hibernate.demo.dao.EmployeeDAO;
// import hibernate.demo.dao.OrderDAO;
import hibernate.demo.model.Customer;
import hibernate.demo.model.Employee;
// import hibernate.demo.model.Order;

/**
 * Hello world!
 *
 */
public class HibernateDemoMain {
    public static void main(String[] args) {
	/*
	 * OrderDAO orderDAO = new OrderDAO();
	 * 
	 * System.out.
	 * println("=========================== single row ==========================="
	 * );
	 * 
	 * Order x = orderDAO.findByOrderNumber(10100);
	 * 
	 * System.out.println(x.toString());
	 * 
	 * System.out.
	 * println("=========================== update row ==========================="
	 * );
	 * 
	 * x.setStatus("PENDING"); x.setShippedDate(new Date());
	 * 
	 * orderDAO.update(x); System.out.println(x.toString());
	 * 
	 * System.out.
	 * println("=========================== query multiple rows ==========================="
	 * );
	 * 
	 * List<Order> orders = orderDAO.findByStatus("Cancelled"); for (Order order :
	 * orders) { System.out.println(order.toString()); }
	 * 
	 * System.out.
	 * println("=========================== insert ===========================");
	 * 
	 * Order newOrder = new Order(); newOrder.setOrderNumber(1111100);
	 * newOrder.setOrderDate(new Date()); newOrder.setRequiredDate(new Date());
	 * newOrder.setShippedDate(new Date()); newOrder.setStatus("WHATEVER");
	 * newOrder.setComments("Some comments about the order");
	 * newOrder.setCustomerNumber(103); orderDAO.insert(newOrder);
	 */

	System.out.println("=========================== Find Single Customer Result ===========================");

	CustomerDAO customerDAO = new CustomerDAO();

	Customer customer = customerDAO.findByCustomerId(114);
	System.out.println("Customer ID: " + customer.getId());
	Employee salesRep = customer.getSalesRep();
	System.out.println("Employee (Sales Rep) First Name: " + salesRep.getFirstName());

	System.out.println("=========================== Find Single Employee Result ===========================");
	EmployeeDAO employeeDAO = new EmployeeDAO();

	Employee e = employeeDAO.findByEmployeeId(1165);
	System.out.println("Employee Number: " + e.getEmployeeNumber() + " | First Name: " + e.getFirstName());

	for (Customer c : e.getCustomers()) {
	    System.out.println("Customer ID: " + c.getId() + " | First Name: " + c.getFirstName()
		    + " | Customer Last Name: " + c.getLastName() + " | Sales Rep: " + c.getSalesRep().getFirstName());
	}

    }
}
