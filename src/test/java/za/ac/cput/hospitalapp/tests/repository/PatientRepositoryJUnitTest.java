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
import za.ac.cput.hospitalapp.domain.Name;
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.domain.Patient_Record;
import za.ac.cput.hospitalapp.repository.PatientRepository;

/**
 *
 * @author Mhumhu
 */
public class PatientRepositoryJUnitTest {
    public static ApplicationContext ctx;
    private Long id;

    private PatientRepository repo;
    
    public PatientRepositoryJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
     public void createPatient() {
         repo = ctx.getBean(PatientRepository.class);
         
        Name name = new Name();
        name.setFname("Klaus");
        name.setLname("Salvatore");
        
        Contact contact = new Contact();
        contact.setLandline("0215558479");
        contact.setCellnumber("0769414940");
        contact.setAddress("17 summer Street");
        
        Patient_Record record = new Patient_Record();
        record.setRecordNum("321");
        record.setDescription("diagnosed with flu");
        record.setPrescription("Vicks veporup medicine");
            
        Patient paxion = new Patient();
        List<Patient_Record> records = paxion.getRecords();
        records.add(record);
        paxion.setRecords(records);
        
        Patient p = new Patient.Builder("80869195")
                 .name(name)
                 .contact(contact)
                 .gender("Female")
                 .age("19")
                 .records(records)
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
         
     
     }
     
     @Test
     public void readPatient(){
         repo = ctx.getBean(PatientRepository.class);
         Patient patient = repo.findOne(id);
         Assert.assertEquals(patient.getName(), "Rhulani");
         
     }
     
    @Test
     public void updatePatient(){
         
         repo = ctx.getBean(PatientRepository.class);
         Name name = new Name();
        name.setFname("Stefan");
        name.setLname("Salvatore");
        
         Patient patient = repo.findOne(id);
         Patient updatedPatient = new Patient.Builder("80869195")
                 .patient(patient)
                 .name(name)
                 .build();
        
         repo.save(updatedPatient);
         
         Patient newPatient = repo.findOne(id);
         Assert.assertEquals("Stefan Salvatore", newPatient.getName());
         
     }
     
     @Test
     public void deletePatient(){
         repo = ctx.getBean(PatientRepository.class);
         Patient patient = repo.findOne(id);
         repo.delete(patient);
         
         Patient deletedPatient = repo.findOne(id);
         
         Assert.assertNull(deletedPatient);
         
         
     }
}
