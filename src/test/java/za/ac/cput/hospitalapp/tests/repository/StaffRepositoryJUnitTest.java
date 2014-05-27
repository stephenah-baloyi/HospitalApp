/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.tests.repository;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import za.ac.cput.hospitalapp.app.config.ConnectionConfig;
import za.ac.cput.hospitalapp.domain.Contact;
import za.ac.cput.hospitalapp.domain.Name;
import za.ac.cput.hospitalapp.domain.Staff;
import za.ac.cput.hospitalapp.repository.StaffRepository;

/**
 *
 * @author Mhumhu
 */
public class StaffRepositoryJUnitTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private StaffRepository repo;
    
    public StaffRepositoryJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /*@Test
    public void craeteStaff() {
    
        repo = ctx.getBean(StaffRepository.class);
        Name name = new Name();
        name.setFname("Rhulani");
        name.setLname("Baloyi");
        
        Contact contact = new Contact();
        contact.setLandline("0215558479");
        contact.setCellnumber("0769414940");
        contact.setAddress("17 summer Street");
        
         Staff staff = new Staff();
         staff.setStaffNum("210188200");
         staff.setName(name);
         staff.setContact(contact);
         staff.setGender("Female");
         staff.setAge("22");
         staff.setTitle("Docter");
         repo.save(staff);
         id = staff.getId();
         Assert.assertNotNull(staff);
    }*/
    
    @Test
     public void createStaff() {
         repo = ctx.getBean(StaffRepository.class);
        Name name = new Name();
        name.setFname("Rhulani");
        name.setLname("Baloyi");
        
        Contact contact = new Contact();
        contact.setLandline("0215558479");
        contact.setCellnumber("0769414940");
        contact.setAddress("17 summer Street");
        
         Staff s = new Staff.Builder("210188200")
                 .name(name)
                 .contact(contact)
                 .gender("Female")
                 .age("22")
                 .title("Doctor")
                 .build();
         repo.save(s);
         id = s.getId();
         Assert.assertNotNull(s);
         
     
     }
     @Ignore
     @Test
     public void readStaff(){
         repo = ctx.getBean(StaffRepository.class);
         Staff staff = repo.findOne(id);
         Assert.assertEquals("Rhulani", staff.getName());
         
     }
    @Ignore
    @Test
     public void updateStaff(){
         repo = ctx.getBean(StaffRepository.class);
         
         Name name = new Name();
        name.setFname("Stefan");
        name.setLname("Salvatore");
        
         Staff staff = repo.findOne(id);
         Staff updatedStaff = new Staff.Builder("210188200")
                 .name(name)                 
                 .build();
        
         repo.save(updatedStaff);
         
         Staff newStaff = repo.findOne(id);
         Assert.assertEquals("Stefan Baloyi", newStaff.getName());
         
     }
     @Ignore
     @Test
     public void deleteStaff(){
         repo = ctx.getBean(StaffRepository.class);
         Staff staff = repo.findOne(id);
         repo.delete(staff);
         
         Staff deletedStaff = repo.findOne(id);
         
         Assert.assertNull(deletedStaff);
         
         
     }
         
}
    