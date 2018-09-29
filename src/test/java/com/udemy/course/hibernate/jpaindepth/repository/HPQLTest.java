package com.udemy.course.hibernate.jpaindepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udemy.course.hibernate.jpaindepth.JpaInDepthApplication;
import com.udemy.course.hibernate.jpaindepth.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaInDepthApplication.class)
public class HPQLTest {
    
   private Logger log=LoggerFactory.getLogger(this.getClass());

   @Autowired
   EntityManager em;
	
   @Test
	public void contextLoads() { 
	   log.info("testing is runing");
	}
   
   @Test
   public void jpql_basic() { 
      
      Query query=em.createQuery("select c from Course c");
      List resultList=query.getResultList();
      log.info("select c from Course c ->{}",resultList);
   }
   
   @Test
   public void findById_typed() { 
      
      TypedQuery<Course> query=em.createQuery("select c from Course c",Course.class);
      List<Course>resultList=query.getResultList();
      log.info("select c from Course c ->{}",resultList);
   }
   
   @Test
   public void findById_where() { 
      
      TypedQuery<Course> query=em.createQuery("select c from Course c where name like '%jpa'",Course.class);
      List<Course>resultList=query.getResultList();
      log.info("select c from Course c ->{}",resultList);
   }
   
//   @Test
//   @DirtiesContext // for any method that change in data 
//   public void deleteById() { 
//      
//       
//       courseRepository.deleteById(10001L);
//       assertNull(courseRepository.findById(10001L));
//   }
//   
//   @Test
//   @DirtiesContext // for any method that change in data maintain data state 
//   public void save_basic() { 
//       Course course=courseRepository.findById(10001L);
//       assertEquals("jpa",course.getName());
//       course.setName("jpa updated");
//       courseRepository.save(course);
//       
//       Course course1=courseRepository.findById(10001L);
//       
//       assertEquals("jpa updated",course1.getName());
//   }
//   
//   @Test
//   @DirtiesContext // for any method that change in data 
//   public void playWithEntityManager() { 
//       courseRepository.playWithEntityManager();
//     //  assertNull(courseRepository.findById(10001L));
//   }
//   
//   
//   
   
   
   

}
