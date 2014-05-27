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
import za.ac.cput.hospitalapp.domain.Department;
import za.ac.cput.hospitalapp.domain.Hospital;
import za.ac.cput.hospitalapp.repository.DepartmentRepository;
import za.ac.cput.hospitalapp.repository.HospitalRepository;
import za.ac.cput.hospitalapp.services.HospitalDetailService;

/**
 *
 * @author Mhumhu
 */
public class HospitalDetailsServiceJUnitTest {
    
    private static ApplicationContext ctx;
    private HospitalDetailService hospitalDetailsService;
    private HospitalRepository hospitalRepository;
    private DepartmentRepository deptRepository;
    private Long id;
    
    public HospitalDetailsServiceJUnitTest() {
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
    
        hospitalRepository = ctx.getBean(HospitalRepository.class);
        hospitalDetailsService = ctx.getBean(HospitalDetailService.class);
        deptRepository = ctx.getBean(DepartmentRepository.class);
                       
        Hospital h = hospitalRepository.findOne(id);
        String name = hospitalDetailsService.getHospitalName(h.getId());
        Assert.assertEquals("Tyger", name);
                        
        String contact = hospitalDetailsService.getAddress(h.getId());
        Assert.assertEquals("17 gousblom Street", contact);
        
        Department dept1 = new Department.Builder("D202")
                .build();
        Department dept2 = new Department.Builder("D202")
                .build();
        Department dept3 = new Department.Builder("D202")
                .build();
        deptRepository.save(dept1);
        deptRepository.save(dept2);
        deptRepository.save(dept3);

        List<Department> depts = hospitalDetailsService.getDepartments(id);

        Assert.assertEquals(depts.size(), 3);
    }
}
