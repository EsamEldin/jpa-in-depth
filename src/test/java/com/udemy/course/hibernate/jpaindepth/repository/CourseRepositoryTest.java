package com.udemy.course.hibernate.jpaindepth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.udemy.course.hibernate.jpaindepth.JpaInDepthApplication;
import com.udemy.course.hibernate.jpaindepth.entity.Course;
import com.udemy.course.hibernate.jpaindepth.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaInDepthApplication.class)
public class CourseRepositoryTest {
    
   private Logger log=LoggerFactory.getLogger(this.getClass());

   @Autowired
   CourseRepository courseRepository;
   
   
   @Autowired
   ReviewRepository reviewRepository;
	
   @Test
	public void contextLoads() { 
	   log.info("testing is runing");
	}
   
   @Test
   public void findById() { 
      
       
       Course course=courseRepository.findById(10001L);
       assertEquals("jpa",course.getName());
   }
   
   @Test
   @DirtiesContext // for any method that change in data 
   public void deleteById() { 
      
       
       courseRepository.deleteById(10001L);
       assertNull(courseRepository.findById(10001L));
   }
   
   @Test
   @DirtiesContext // for any method that change in data maintain data state 
   public void save_basic() { 
       Course course=courseRepository.findById(10001L);
       assertEquals("jpa",course.getName());
       course.setName("jpa updated");
       courseRepository.save(course);
       
       Course course1=courseRepository.findById(10001L);
       
       assertEquals("jpa updated",course1.getName());
   }
   
   @Test
   @DirtiesContext // for any method that change in data 
   public void playWithEntityManager() { 
       courseRepository.playWithEntityManager();
     //  assertNull(courseRepository.findById(10001L));
   }
   
   
   @Test // test the default strategy of @oneToMany the default is lazy
   @Transactional
   public void retriveReviewsForCourse() { 
       Course course=courseRepository.findById(10001L);
       log.info("{}",course.getReviews());
    
   }
   
   @Test // test the default strategy of @oneToMany the default is lazy
   @Transactional
   public void retriveCourseForReview() { 
       Review revieo=reviewRepository.findById(6003L);
       log.info("{}",revieo.getCourse());
    
   }
   

   
   
   
   
   

}
