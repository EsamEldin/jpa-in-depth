package com.udemy.course.hibernate.jpaindepth.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Entity
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;
    
    protected PartTimeEmployee(){}
    
    public PartTimeEmployee(String name,BigDecimal hourlyWage ){
        super(name);
        this.hourlyWage=hourlyWage;
    }
}
