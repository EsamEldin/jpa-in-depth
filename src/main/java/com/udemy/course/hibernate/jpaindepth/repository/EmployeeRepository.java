package com.udemy.course.hibernate.jpaindepth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udemy.course.hibernate.jpaindepth.entity.Employee;

/**
 * @author TFNP0469 Elghareb ahmed
 *
 */
@Repository
@Transactional
public class EmployeeRepository {
    
    @Autowired
    EntityManager em;
    
    public Employee findById(Long id){
        return em.find(Employee.class, id);
    }
    
    public List<Employee> findAll(){
        TypedQuery<Employee> employees= em.createNamedQuery("find-all-employee", Employee.class);
        return employees.getResultList();
    }
    
    
    public Employee save(Employee employee){
        if(employee.getId()==null){
            em.persist(employee);
        }else{
            em.merge(employee);
        }
        
        return employee;
    }
    
    public void deleteById(Long id){
        Employee employee=findById(id);
         em.remove(employee);
    }
    
  
}
