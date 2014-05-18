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
import za.ac.cput.hospitalapp.domain.Appointment;
import za.ac.cput.hospitalapp.domain.Contact;
import za.ac.cput.hospitalapp.domain.Name;
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.domain.Staff;
import za.ac.cput.hospitalapp.repository.AppointmentRepository;
import za.ac.cput.hospitalapp.services.MakingAppointmentService;

/**
 *
 * @author Mhumhu
 */
public class MakingAppointmentServiceJUnitTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private AppointmentRepository appRepo;
    private MakingAppointmentService makingApp;
    
    public MakingAppointmentServiceJUnitTest() {
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
    public void testMakingAppointmentService() {
    
        appRepo = ctx.getBean(AppointmentRepository.class);
        makingApp = ctx.getBean(MakingAppointmentService.class);
        
        Name name = new Name();
        name.setFname("Smangele");
        name.setLname("Hobyani");
        
        Contact contact = new Contact();
        contact.setLandline("0124567891");
        contact.setCellnumber("0734266419");
        contact.setAddress("jerome");
        
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
        
        Appointment appointment = new Appointment.Builder("002")
                 .patient(patient)
                .staff(staff)
                .app_date("04/05/2014")
                .app_time("10:30 am")
                 .build();
         appRepo.save(appointment);
         id = appointment.getId();
         String appointments = makingApp.makeAppointment(id);
         Assert.assertNotNull(appointments);       
        
       
    }
}
