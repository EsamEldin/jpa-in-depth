package com.udemy.course.hibernate.jpaindepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
public class CriteriaQueryTest {
    
   private Logger log=LoggerFactory.getLogger(this.getClass());

   @Autowired
   EntityManager em;
	
   @Test
	public void contextLoads() { 
	   log.info("testing is runing");
	}
   
   @Test
   public void criteria_basic() { 
      //select c from Course c
    
       CriteriaBuilder cb=  em.getCriteriaBuilder();
       CriteriaQuery<Course> cq = cb.createQuery(Course.class);
       //define roots for tables which are invloved in the query
       Root<Course> courseRoot= cq.from(Course.class);
    
       
      TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
      List resultList=query.getResultList();
      log.info("select c from Course c ->{}",resultList);
   }
   
   @Test
   public void all_course_having_100Steps() { 
       //select c from Course c where c.name like '%jpa'
     CriteriaBuilder c_Builder=  em.getCriteriaBuilder();
    CriteriaQuery<Course> c_Query = c_Builder.createQuery(Course.class);
    //define roots for tables which are invloved in the query
    Root<Course> courseRoot= c_Query.from(Course.class);
    
    //define predicates etc using criteria builder
    Predicate like= c_Builder.like(courseRoot.get("name"), "jpa");
    
    //add predicates etc to the criteria query
    c_Query.where(like);
       
      TypedQuery<Course> query=em.createQuery(c_Query.select(courseRoot));
      List resultList=query.getResultList();
      log.info("select c from Course c where c.name like '%jpa' ->{}",resultList);
   }
   
   @Test
   public void all_course_without_students() { 
       //select c from Course c where c.students is empty
     CriteriaBuilder c_Builder=  em.getCriteriaBuilder();
    CriteriaQuery<Course> c_Query = c_Builder.createQuery(Course.class);
    //define roots for tables which are invloved in the query
    Root<Course> courseRoot= c_Query.from(Course.class);
    
    //define predicates etc using criteria builder
    Predicate studentsIsEmpty= c_Builder.isEmpty(courseRoot.get("students"));
    
    //add predicates etc to the criteria query
    c_Query.where(studentsIsEmpty);
       
      TypedQuery<Course> query=em.createQuery(c_Query.select(courseRoot));
      List resultList=query.getResultList();
      log.info("select c from Course c where c.name like '%jpa' ->{}",resultList);
   }
   

   @Test
   public void course_Join_students() { 
       //select c,s from Course c join c.students  s
     CriteriaBuilder c_Builder=  em.getCriteriaBuilder();
    CriteriaQuery<Course> c_Query = c_Builder.createQuery(Course.class);
    //define roots for tables which are invloved in the query
    Root<Course> courseRoot= c_Query.from(Course.class);
    
    //define predicates etc using criteria builder
    Join<Object, Object> join=courseRoot.join("students");
   
      TypedQuery<Course> query=em.createQuery(c_Query.select(courseRoot));
      List resultList=query.getResultList();
      log.info("select c from Course c where c.name like '%jpa' ->{}",resultList);
   }
   

}
