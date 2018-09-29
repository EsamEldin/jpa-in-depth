package com.udemy.course.hibernate.jpaindepth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Entity
public class Passport {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="number",nullable=true,insertable=true,updatable=true)
    private String number;
    
    @OneToOne(fetch=FetchType.LAZY,mappedBy="passport")
    private Student student;

    /**
     * @param id
     * @param number
     */
    public Passport(String number) {
        super();
     
        this.number = number;
    }

    /**
     * 
     */
    public Passport() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport [id=" + id + ", number=" + number + "]";
    }
    
    
    

}
