/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.tests.services;

import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import za.ac.cput.hospitalapp.app.config.ConnectionConfig;
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.domain.Patient_Record;
import za.ac.cput.hospitalapp.repository.PatientRecordRepository;
import za.ac.cput.hospitalapp.repository.PatientRepository;
import za.ac.cput.hospitalapp.services.ViewPatientRecordsService;

/**
 *
 * @author Mhumhu
 */
public class ViewPatientRecordsServiceJUnitTest {
    public static ApplicationContext ctx;
    private Long id;

    private PatientRecordRepository recordrepo;
    private PatientRepository patientrepo;
    private ViewPatientRecordsService viewrecord;
    
    public ViewPatientRecordsServiceJUnitTest() {
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
    public void testHospitalDetailService() {
    
        recordrepo = ctx.getBean(PatientRecordRepository.class);
        patientrepo = ctx.getBean(PatientRepository.class);
        viewrecord = ctx.getBean(ViewPatientRecordsService.class);
        Patient patient = patientrepo.findById(id);
        
        List<Patient_Record> records = viewrecord.viewRecords(patient, id);

        Assert.assertEquals(1, records.size());
    }
}
