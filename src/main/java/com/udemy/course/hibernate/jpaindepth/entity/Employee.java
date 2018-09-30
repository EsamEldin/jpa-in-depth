package com.udemy.course.hibernate.jpaindepth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Entity
@NamedQuery(name="find-all-employee",query="select E from Employee E")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//TABLE_PER_CLASS or JOINED
//@DiscriminatorColumn(name="EmployeeType") // this used to change the name of the additional column(DType)
public abstract class Employee {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="name",nullable=true,insertable=true,updatable=true)
    private String name;
    

    
    protected Employee(){}
    public Employee(String name){
        this.name=name;
    }
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    


  
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return String.format("Employee [%s]",name);
    }
    

 
   
    
    
    
}
