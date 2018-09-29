package com.udemy.course.hibernate.jpaindepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.course.hibernate.jpaindepth.entity.Course;
import com.udemy.course.hibernate.jpaindepth.entity.Passport;
import com.udemy.course.hibernate.jpaindepth.entity.Student;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Repository
@Transactional
public class StudentRepository {
    
    @Autowired
    EntityManager em;
    
    public Student findById(Long id){
        return em.find(Student.class, id);
    }
    
    public Student save(Student student){
        if(student.getId()==null){
            em.persist(student);
        }else{
            em.merge(student);
        }
        
        return student;
    }
    
    public void deleteById(Long id){
        Student student=findById(id);
         em.remove(student);
    }
    
    //important show transaction effect
    public void playWithEntityManager(){
        Passport passport=new Passport("Z1234567");
        em.persist(passport);
        Student student=new Student("Waael");
        student.setPassport(passport);
        
        em.persist(student);

    }
    
    //this to test many to many relation
    public void insertStudentAndCourses(Student student,List<Course> courses){
        
        if(student==null)
            return;
        em.persist(student);
        for(Course course:courses){
           
            em.persist(course);
            course.addStudent(student);//take care for this
            student.addCourse(course);// take care for this
           
        }
        
       // em.persist(student); // persist the owner of the relationship finally after persisting each entity as above
        
    }
    
    
    
//    public Student save(Student student){
//        return em.
//    }

}
