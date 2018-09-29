package com.udemy.course.hibernate.jpaindepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaInDepthApplication.class)
public class NativeQueriesTest {
    
   private Logger log=LoggerFactory.getLogger(this.getClass());

   @Autowired
   EntityManager em;
	
   @Test
	public void contextLoads() { 
	   log.info("testing is runing");
	}
   
   @Test
   public void nativeQueries_basic() { 
      
      Query query=em.createNativeQuery("select * from course",Course.class);
      List resultList=query.getResultList();
      log.info("select * from course ->{}",resultList);
   }
   
   @Test
   public void nativeQueries_where() { 
      
      Query query=em.createNativeQuery("select * from course where id=?",Course.class);
      query.setParameter(1, 10001L);
      List resultList=query.getResultList();
      log.info("select * from course where id=? ->{}",resultList);
   }
   
   @Test
   public void nativeQueries_named_Parameter() { 
      
      Query query=em.createNativeQuery("select * from course where id=:id",Course.class);
      query.setParameter("id", 10001L);
      List resultList=query.getResultList();
      log.info("select * from course where id=:id ->{}",resultList);
   }
   
   
   @Test
   @Transactional //because it changes in data
   @DirtiesContext
   public void nativeQueries_TO_UPDATE() { 
      
      Query query=em.createNativeQuery("update course set last_updated_date=sysdate()",Course.class);
     
      int noOfRowsUpdated=query.executeUpdate();
      log.info("noOfRowsUpdated ->{}",noOfRowsUpdated);
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
