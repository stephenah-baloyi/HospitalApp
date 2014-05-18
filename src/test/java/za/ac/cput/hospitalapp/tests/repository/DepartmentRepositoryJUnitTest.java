/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.tests.repository;

import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import za.ac.cput.hospitalapp.app.config.ConnectionConfig;
import za.ac.cput.hospitalapp.domain.Department;
import za.ac.cput.hospitalapp.domain.Ward;
import za.ac.cput.hospitalapp.repository.DepartmentRepository;

/**
 *
 * @author Mhumhu
 */
public class DepartmentRepositoryJUnitTest {
    public static ApplicationContext ctx;
    private Long id;

    private DepartmentRepository repo;
    
    public DepartmentRepositoryJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void createDepartment() {
         repo = ctx.getBean(DepartmentRepository.class);
         
            
        Ward ward = new Ward();
        ward.setWardNum("W1234");
        ward.setStatus("Open");
        ward.setWardGender("Female");
            
        Department dept = new Department();
        List<Ward> wards = dept.getWard();
        wards.add(ward);
        dept.setWard(wards);
        
        
        Department department = new Department.Builder("D202")
                 .deptName("Health")
                .ward(wards)
                 .build();
         repo.save(department);
         id = department.getId();
         Assert.assertNotNull(department);
         
     
     }
     
     @Test
     public void readDepartment(){
         repo = ctx.getBean(DepartmentRepository.class);
         Department dept = repo.findById(id);
         Assert.assertEquals("D202", dept.getDeptID());
         
     }
     
    @Test
     private void updateDepartment(){
         
         repo = ctx.getBean(DepartmentRepository.class);
         
         Department dept = repo.findById(id);
         Department updatedDept = new Department.Builder("D202")
                 .department(dept)
                 .deptName("Physio")                 
                 .build();
        
         repo.save(updatedDept);
         
         Department newDept = repo.findById(id);
         Assert.assertEquals("Physio", newDept.getDeptName());
         
     }
     
     @Test
     private void deleteDepartment(){
         repo = ctx.getBean(DepartmentRepository.class);
         Department dept = repo.findById(id);
         repo.delete(dept);
         
         Department deletedDept = repo.findById(id);
         
         Assert.assertNull(deletedDept);
         
         
     }
}
