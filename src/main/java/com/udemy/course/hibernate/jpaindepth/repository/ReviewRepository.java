package com.udemy.course.hibernate.jpaindepth.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.course.hibernate.jpaindepth.entity.Review;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Repository
@Transactional
public class ReviewRepository {
    
    @Autowired
    EntityManager em;
    
    public Review findById(Long id){
        return em.find(Review.class, id);
    }
    
    public Review save(Review review){
        
        if(review.getId()==null){
            em.persist(review);
        }else{
            em.merge(review);
        }
        
        return review;
    }
    
    public void deleteById(Long id){
        Review review=findById(id);
         em.remove(review);
    }
    
    //important show transaction effect
    public void playWithEntityManager(){
//        Review review=new Review();
//        em.persist(review);
//        
//        Review review1=new Review("Angular");
//        em.persist(review1);
//
//        em.flush(); // this will pause the transaction and perform the above to steps(write to DB) then continue transaction to the next flush() 
//        
//      //  em.detach(review1);//this entity(review1) is no longer tracked by entity manager
//        
//        //review will be updated because the class is within transaction management 
//        //scope that ended  with the end method
//        review.setName("web services in 100 steps - updated"); 
//        em.flush();
//        
//        review1.setName("Angular in 100 steps - updated"); // this will not updated becuase the entity is detached 
//       
//        em.flush();
//        
//        em.refresh(review1); // referesh the content of review one from database
//        
        
    }
    
    
    
//    public Review save(Review review){
//        return em.
//    }

}
