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
import za.ac.cput.hospitalapp.domain.Contact;
import za.ac.cput.hospitalapp.domain.Department;
import za.ac.cput.hospitalapp.domain.Hospital;
import za.ac.cput.hospitalapp.domain.Ward;
import za.ac.cput.hospitalapp.repository.DepartmentRepository;
import za.ac.cput.hospitalapp.repository.HospitalRepository;
import za.ac.cput.hospitalapp.repository.WardRepository;

/**
 *
 * @author Mhumhu
 */
public class HospitalRepositoryJUnitTest {
    public static ApplicationContext ctx;
    private Long id;

    private HospitalRepository repo;
    private WardRepository wardrepo;
    private DepartmentRepository deptrepo;
    
    public HospitalRepositoryJUnitTest() {
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
     public void createHospital() {
         repo = ctx.getBean(HospitalRepository.class);
         
        Ward ward = wardrepo.findById(id);
        Department dept = deptrepo.findById(id);
         
        Contact contact = new Contact();
        contact.setLandline("0215558479");
        contact.setAddress("20 gousblom Street");
        
        Hospital hospital = new Hospital();
        List<Department> department = hospital.getDepartment();
        department.add(dept);
        hospital.setDepartment(department);
        
        Hospital h = new Hospital.Builder("Tyger Hospital")
                 .contact(contact)
                .department(department)
                 .build();
         repo.save(h);
         id = h.getId();
         Assert.assertNotNull(h);
         
     
     }
     
     @Test
     public void readHospital(){
         repo = ctx.getBean(HospitalRepository.class);
         Hospital hospital = repo.findById(id);
         Assert.assertEquals("Tyger", hospital.getName());
         
     }
     
    @Test
     private void updateHospital(){
         
         repo = ctx.getBean(HospitalRepository.class);
        Contact contact = new Contact();
        contact.setLandline("0158899772");
        contact.setAddress("17 gousblom Street");
        
         Hospital hospital = repo.findById(id);
         Hospital updatedHospital = new Hospital.Builder("Tyger")
                 .contact(contact)                 
                 .build();
        
         repo.save(updatedHospital);
         
         Hospital newHospital = repo.findById(id);
         Assert.assertEquals("0158899772" + "17 gousblom Street", newHospital.getContact());
         
     }
     
     @Test
     private void deleteHospital(){
         repo = ctx.getBean(HospitalRepository.class);
         Hospital h = repo.findById(id);
         repo.delete(h);
         
         Hospital deletedHospital = repo.findById(id);
         
         Assert.assertNull(deletedHospital);
         
         
     }
}
