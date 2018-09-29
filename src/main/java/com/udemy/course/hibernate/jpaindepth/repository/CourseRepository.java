package com.udemy.course.hibernate.jpaindepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.course.hibernate.jpaindepth.entity.Course;
import com.udemy.course.hibernate.jpaindepth.entity.Review;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Repository
@Transactional
public class CourseRepository {
    
    @Autowired
    EntityManager em;
    
    Logger log=LoggerFactory.getLogger(this.getClass());
    
    public Course findById(Long id){
        return em.find(Course.class, id);
    }
    
    public Course save(Course course){
        if(course.getId()==null){
            em.persist(course);
        }else{
            em.merge(course);
        }
        
        return course;
    }
    
    public void deleteById(Long id){
        Course course=findById(id);
         em.remove(course);
    }
    
    //important show transaction effect
    public void playWithEntityManager(){
        Course course=new Course("web Services");
        em.persist(course);
        
        Course course1=new Course("Angular");
        em.persist(course1);

        em.flush(); // this will pause the transaction and perform the above to steps(write to DB) then continue transaction to the next flush() 
        
      //  em.detach(course1);//this entity(course1) is no longer tracked by entity manager
        
        //course will be updated because the class is within transaction management 
        //scope that ended  with the end method
        course.setName("web services in 100 steps - updated"); 
        em.flush();
        
        course1.setName("Angular in 100 steps - updated"); // this will not updated becuase the entity is detached 
       
        em.flush();
        
        em.refresh(course1); // referesh the content of course one from database
        
        
    }
    
    public void addReviewsToCourse(Long courseId,List<Review> reviews){
        Course course=em.find(Course.class, courseId);
        log.info("course for id 10001L {}",course.getReviews());
        for(Review review:reviews){
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
        
       
    }
    
    
//    public Course save(Course course){
//        return em.
//    }

}
