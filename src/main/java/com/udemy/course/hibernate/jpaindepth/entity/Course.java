package com.udemy.course.hibernate.jpaindepth.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Entity
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted=false")
public class Course {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="name",nullable=true,insertable=true,updatable=true)
    private String name;
    
    @UpdateTimestamp
    private  LocalDateTime lastUpdatedDate;
    
    @CreationTimestamp
    private  LocalDateTime createdDate;
    
    @OneToMany(fetch=FetchType.EAGER ,mappedBy="course")// this course has many reviews
    private List<Review> reviews =new ArrayList<>();
    
    @ManyToMany(mappedBy="courses")
    private List<Student> students=new ArrayList<>();
    
    private boolean is_deleted;
    
    @PreRemove
    private void preRemove(){
        this.is_deleted=true;
    }
    
    
    protected Course(){}
    public Course(String name){
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
    
    
    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    //Best practise from set list of reviews 
    public void addReview(Review review) {
        this.reviews.add(review);
    }
    
    public void removeReviews(Review review) {
        this.reviews.remove(review);
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public List<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate=" + createdDate  + "]";
    }
   
    
    
    
}
