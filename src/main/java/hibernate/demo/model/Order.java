package hibernate.demo.model;

import java.util.Date;
// import java.util.List;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderNumber")
    private Integer orderNumber;
    
    @Column(name = "orderDate")
    private Date orderDate;
    
    @Column(name = "requiredDate")
    private Date requiredDate;
    
    @Column(name = "shippedDate")
    private Date shippedDate;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;
    
    @Column(name = "customerNumber")
    private Integer customerNumber;
    
    /*
     * @OneToMany(targetEntity = OrderDetails.class, cascade = CascadeType.ALL)
     * private List<OrderDetails> orderDetails;
     */    
    
}
