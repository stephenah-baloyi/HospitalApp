/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.tests.repository;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import za.ac.cput.hospitalapp.app.config.ConnectionConfig;
import za.ac.cput.hospitalapp.domain.Ward;
import za.ac.cput.hospitalapp.repository.WardRepository;

/**
 *
 * @author Mhumhu
 */
public class WardRepositoryJUnitTest {
public static ApplicationContext ctx;
    private Long id;

    private WardRepository repo;
    
    public WardRepositoryJUnitTest() {
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
     public void createWard() {
         repo = ctx.getBean(WardRepository.class);
        
         Ward ward = new Ward.Builder("W1234")
                 .status("Open")
                 .wardGender("Female Ward")
                 .build();
         repo.save(ward);
         id = ward.getId();
         Assert.assertNotNull(ward);
         
     
     }
     @Test
     public void readWard(){
         repo = ctx.getBean(WardRepository.class);
         Ward ward = repo.findById(id);
         Assert.assertEquals("W1234", ward.getWardNum());
         
     }
     
    @Test
     private void updateWard(){
         repo = ctx.getBean(WardRepository.class);
                
         Ward ward = repo.findById(id);
         Ward updatedWard = new Ward.Builder("W1234")
                 .wardGender("Male")
                 .build();
        
         repo.save(updatedWard);
         
         Ward newWard = repo.findById(id);
         Assert.assertEquals("Male", newWard.getWardGender());
         
     }
     
     @Test
     private void deleteWard(){
         repo = ctx.getBean(WardRepository.class);
         Ward ward = repo.findById(id);
         repo.delete(ward);
         
         Ward deletedWard = repo.findById(id);
         
         Assert.assertNull(deletedWard);
         
         
     }
}
