package hibernate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderdetails")
public class OrderDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderNumber")
    private Integer orderNumber;
    
    @Column(name = "productCode")
    private String productCode;
    
    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;
    
    @Column(name = "priceEach", columnDefinition = "DECIMAL", precision = 10, scale = 2)
    private Double priceEach;
    
    @Column(name = "orderLineNumber", columnDefinition = "SMALLINT")
    private Integer orderLineNumber;
    
}
