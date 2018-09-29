package com.udemy.course.hibernate.jpaindepth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Entity
public class Review {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="description",nullable=true,insertable=true,updatable=true)
    private String description;
    
    @Column(name="rating")
    private String rating;
    
    
    //reviews is the owning side of relation because it will contain courde_id the owner mean it will have the reference column
    @ManyToOne //many reviews related to one course
    private Course course;

    /**
     * @param id
     * @param description
     */
    public Review(String description,String rating) {
        super();
        this.description = description;
    }

    /**
     * 
     */
    public Review() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", description=" + description + ", rating=" + rating + "]";
    }

  


    
    
    

}
