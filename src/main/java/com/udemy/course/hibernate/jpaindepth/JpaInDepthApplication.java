package com.udemy.course.hibernate.jpaindepth;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.course.hibernate.jpaindepth.entity.Course;
import com.udemy.course.hibernate.jpaindepth.entity.Student;
import com.udemy.course.hibernate.jpaindepth.repository.CourseRepository;
import com.udemy.course.hibernate.jpaindepth.repository.StudentRepository;

@SpringBootApplication
public class JpaInDepthApplication implements CommandLineRunner {
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    Logger log=LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaInDepthApplication.class, args);
	}

    /* (non-Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
//        log.info("course for id 1001 {}",courseRepository.findById(10001L));
//        courseRepository.playWithEntityManager();
        //studentRepository.playWithEntityManager();
        List<Course> courses=new ArrayList<>();
        courses.add(new Course("course_11"));
        courses.add(new Course("course_22"));
      //  log.info("student for id 2001L {}",studentRepository.findById(2001L).getCourses());
      // courseRepository.addReviewsToCourse();
      //  log.info("course for id 10001L {}",courseRepository.findById(10001L));
      
        studentRepository.insertStudentAndCourses(new Student("amged"), courses);
    }
}
