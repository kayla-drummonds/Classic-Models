package hibernate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customerNumber")
    private Integer id;
    
    @Column(name = "customerName")
    private String name;
    
    @Column(name = "contactFirstName")
    private String firstName;
    
    @Column(name = "contactLastName")
    private String lastName;
    
    
    /*
     * @Column(name = "salesRepEmployeeNumber") private Integer salesRepId;
     */
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "salesRepEmployeeNumber", nullable = false)
    private Employee salesRep;
}
