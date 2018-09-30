package com.udemy.course.hibernate.jpaindepth.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Entity
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;
    
    protected FullTimeEmployee(){}
    
    public FullTimeEmployee(String name,BigDecimal salary ){
        super(name);
        this.salary=salary;
    }
}
