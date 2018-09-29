package com.udemy.course.hibernate.jpaindepth.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udemy.course.hibernate.jpaindepth.JpaInDepthApplication;
import com.udemy.course.hibernate.jpaindepth.entity.Course;
import com.udemy.course.hibernate.jpaindepth.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaInDepthApplication.class)
public class StudentRepositoryTest {
    
   private Logger log=LoggerFactory.getLogger(this.getClass());

   @Autowired
   StudentRepository studentRepository;
   
   @Autowired
   EntityManager em;
	
   @Test
	public void contextLoads() { 
	   log.info("testing is runing");
	}
   
//   @Test
//   public void findById() { 
//      
//       
//       Student student=studentRepository.findById(10001L);
//       assertEquals("jpa",student.getName());
//   }
   
   
//   @Test
//   @Transactional // without this each step using entity manager will be a transaction so will have start and close    //so the session will end for the next operation
//   public void Crud() { 
//       
//       //persistence context wiil track every change on entity in the transaction (every step operate on every entity)
//      //and also killed at the end of the transaction
//       
//       
//       Student student=em.find(Student.class, 2L); // only one trasaction end after this step
//       
//       Passport passport=student.getPassport();
//     
//       passport.setNumber("F112232");
//       
//       student.setName("khalid"); // if this fail all above operations will fail
//
//   }
//   
   
//   @Test
//   @Transactional // needed if lazy fetch because the session is terminated so we need to keep it live
//   //as the session ended as soon as the statement is executed
//   public void findStudentWithPassport() { 
//      
//       Student student=em.find(Student.class, 2001L);
//       log.info("Student details {}",student);
//       log.info("passport details {}",student.getPassport());
//       //assertEquals("jpa",student.getName());
//   }
   
//   @Test
//   @DirtiesContext // for any method that change in data 
//   public void deleteById() { 
//      
//       
//       studentRepository.deleteById(10001L);
//       assertNull(studentRepository.findById(10001L));
//   }
//   
//   @Test
//   @DirtiesContext // for any method that change in data maintain data state 
//   public void save_basic() { 
//       Student student=studentRepository.findById(10001L);
//       assertEquals("jpa",student.getName());
//       student.setName("jpa updated");
//       studentRepository.save(student);
//       
//       Student student1=studentRepository.findById(10001L);
//       
//       assertEquals("jpa updated",student1.getName());
//   }
//   
//   @Test
//   @DirtiesContext // for any method that change in data 
//   public void playWithEntityManager() { 
//       studentRepository.playWithEntityManager();
//     //  assertNull(studentRepository.findById(10001L));
//   }
//   
   
   @Test
   @Transactional
   public void retriveStudentAndCourses(){
       Student student=em.find(Student.class, 2001L);
       log.info("student -> {}",student);
       log.info("student courses -> {}",student.getCourses());
   }
   
   @Test
   @Transactional
   public void retriveCourseAndStudents(){
       Course course=em.find(Course.class, 10003L);
       log.info("course -> {}",course);
       log.info("course students -> {}",course.getReviews());
   }
   
   
   

}
