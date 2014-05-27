/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.tests.services;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import za.ac.cput.hospitalapp.app.config.ConnectionConfig;
import za.ac.cput.hospitalapp.domain.Staff;
import za.ac.cput.hospitalapp.repository.StaffRepository;
import za.ac.cput.hospitalapp.services.StaffDetailsService;

/**
 *
 * @author Mhumhu
 */
public class StaffDetailsServiceJUnitTest {
    
    private static ApplicationContext ctx;
    private StaffDetailsService staffDetailsService;
    private StaffRepository staffRepository;
    private Long id;
    
    public StaffDetailsServiceJUnitTest() {
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
    public void testStaffDetailService() {
    
        staffRepository = ctx.getBean(StaffRepository.class);
        staffDetailsService = ctx.getBean(StaffDetailsService.class);
                       
        Staff staff = staffRepository.findOne(id);
        String name = staffDetailsService.getFullName(staff.getId());
        Assert.assertEquals("Rhulani" + "Baloyi", name);
                
        String title = staffDetailsService.getTitle(staff.getId());
        Assert.assertEquals("Doctor", title);
        
        String contact = staffDetailsService.getContact(staff.getId());
        Assert.assertEquals("17 summer Street" + "0215558479" + "0769414940", contact);
    }
}
