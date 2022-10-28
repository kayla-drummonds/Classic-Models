package hibernate.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "employees")
public class Employee {
    
    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "extension")
    private String extension;
    
    @Column(name = "officeCode")
    private String officeCode;
    
    // the mappedBy value is actually the name of the java variable in the
    // customer object that we are linking to
    @OneToMany(mappedBy = "salesRep", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Customer> customers;

}
