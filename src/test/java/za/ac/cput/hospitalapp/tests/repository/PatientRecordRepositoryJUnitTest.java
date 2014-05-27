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
import za.ac.cput.hospitalapp.domain.Patient_Record;
import za.ac.cput.hospitalapp.repository.PatientRecordRepository;

/**
 *
 * @author Mhumhu
 */
public class PatientRecordRepositoryJUnitTest {
    public static ApplicationContext ctx;
    private Long id;

    private PatientRecordRepository repo;
    
    public PatientRecordRepositoryJUnitTest() {
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
     public void createPatientRecord() {
         repo = ctx.getBean(PatientRecordRepository.class);
         
        
        Patient_Record p = new Patient_Record.Builder("80869195")
                        .description("AIDS")
                        .prescription("ARV")
                        .amount(200.00)
                        .build();
                
                repo.save(p);
                id = p.getId();
                Assert.assertNotNull(p);
         
     
     }
     
     @Test
     public void readPatientRecord(){
         repo = ctx.getBean(PatientRecordRepository.class);
         Patient_Record record = repo.findOne(id);
         Assert.assertEquals(record.getRecordNum(), "80869195");
         
     }
     
    @Test
     public void updatePatientRecord(){
         
         repo = ctx.getBean(PatientRecordRepository.class);
         
         Patient_Record record = repo.findOne(id);
         Patient_Record updatedRecord = new Patient_Record.Builder("80869195")
                 .amount(250.94)
                 .build();
        
         repo.save(updatedRecord);
         
         Patient_Record newRecord = repo.findOne(id);
         Assert.assertEquals(250.94, newRecord.getAmount());
         
     }
     
     @Test
     public void deletePatientRecord(){
         repo = ctx.getBean(PatientRecordRepository.class);
         Patient_Record record = repo.findOne(id);
         repo.delete(record);
         
         Patient_Record deletedRecord = repo.findOne(id);
         
         Assert.assertNull(deletedRecord);
         
         
     }
}
