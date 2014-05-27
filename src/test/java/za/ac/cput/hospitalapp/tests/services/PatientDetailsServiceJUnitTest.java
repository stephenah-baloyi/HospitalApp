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
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.repository.PatientRepository;
import za.ac.cput.hospitalapp.services.PatientDetailsService;

/**
 *
 * @author Mhumhu
 */
public class PatientDetailsServiceJUnitTest {
    private static ApplicationContext ctx;
    private PatientDetailsService patientDetailsService;
    private PatientRepository patientRepository;
    private Long id;
    
    public PatientDetailsServiceJUnitTest() {
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
    public void testPatientDetailService() {
    
        patientRepository = ctx.getBean(PatientRepository.class);
        patientDetailsService = ctx.getBean(PatientDetailsService.class);
                       
        Patient p = patientRepository.findOne(id);
        String name = patientDetailsService.getFullName(p.getId());
        Assert.assertEquals("Klaus" + "Salvatore", name);
                        
        String contact = patientDetailsService.getContactNumbers(p.getId());
        Assert.assertEquals("0215558479" + "0769414940", contact);
        
        String title = patientDetailsService.getAddress(p.getId());
        Assert.assertEquals("17 summer Street", title);
    }
}
