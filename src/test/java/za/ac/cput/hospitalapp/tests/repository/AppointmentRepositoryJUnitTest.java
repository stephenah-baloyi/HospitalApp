/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import za.ac.cput.hospitalapp.domain.Appointment;
import za.ac.cput.hospitalapp.domain.Contact;
import za.ac.cput.hospitalapp.domain.Name;
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.domain.Staff;
import za.ac.cput.hospitalapp.repository.AppointmentRepository;

/**
 *
 * @author Mhumhu
 */
public class AppointmentRepositoryJUnitTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private AppointmentRepository repo;
    
    
    public AppointmentRepositoryJUnitTest() {
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
     public void createAppointment() {
         repo = ctx.getBean(AppointmentRepository.class);
         
        Name name = new Name();
        name.setFname("Rosie");
        name.setLname("Mickaelson");
        
        Contact contact = new Contact();
        contact.setLandline("0215558479");
        contact.setCellnumber("0769414940");
        contact.setAddress("17 meltonerose");
        
        Patient patient = new Patient();
        patient.setName(name);
        patient.setContact(contact);
        patient.setPatientNum("210188200");
        patient.setGender("Female");
        patient.setAge("23");
                   
        Appointment app = new Appointment();
        app.setPatient(patient);
        
        Staff staff = new Staff();
        staff.getId();
        staff.getName();
        
        Appointment appointment = new Appointment.Builder("001")
                 .patient(patient)
                .staff(staff)
                .app_date("04/05/2014")
                .app_time("10:30 am")
                 .build();
         repo.save(appointment);
         id = appointment.getId();
         Assert.assertNotNull(appointment);        
     
     }
     @Ignore
     @Test
     public void readPatient(){
         repo = ctx.getBean(AppointmentRepository.class);
         Appointment app = repo.findOne(id);
         Assert.assertEquals("001", app.getAppointmentNum());
         
     }
    @Ignore
    @Test
     public void updatePatient(){
         
         repo = ctx.getBean(AppointmentRepository.class);
        
         Appointment app = repo.findOne(id);
         Appointment updatedApp = new Appointment.Builder("011")
                 .appointment(app)
                 .app_date("07/05/2014")
                 .build();
        
         repo.save(updatedApp);
         
         Appointment newApp = repo.findOne(id);
         Assert.assertEquals("07/05/2014", newApp.getApp_date());
         
     }
     
     @Ignore
     @Test
     public void deleteApp(){
         repo = ctx.getBean(AppointmentRepository.class);
         Appointment app = repo.findOne(id);
         repo.delete(app);
         
         Appointment deleteApp = repo.findOne(id);
         
         Assert.assertNull(deleteApp);
         
         
     }
}
