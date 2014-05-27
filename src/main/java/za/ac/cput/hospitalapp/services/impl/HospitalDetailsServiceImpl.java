/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalapp.domain.Contact;
import za.ac.cput.hospitalapp.domain.Department;
import za.ac.cput.hospitalapp.domain.Hospital;
import za.ac.cput.hospitalapp.repository.DepartmentRepository;
import za.ac.cput.hospitalapp.repository.HospitalRepository;
import za.ac.cput.hospitalapp.services.HospitalDetailService;

/**
 *
 * @author Mhumhu
 */
@Service
public class HospitalDetailsServiceImpl implements HospitalDetailService{
    
    @Autowired
    private HospitalRepository hospitalRepository;
    private DepartmentRepository deptRepository;

    @Override
    public String getHospitalName(Long ID) {
        Hospital hospital = hospitalRepository.findOne(ID);
        return hospital.getName();
    }

    @Override
    public String getAddress(Long ID) {
        Hospital hospital = hospitalRepository.findOne(ID);
        Contact contact = hospital.getContact();
        return contact.getAddress();
    }

    @Override
    public List<Department> getDepartments(Long ID) {
        
        List<Department> depts = new ArrayList();
        List<Department> allDepts = deptRepository.findAll();

        for (Department dept : allDepts) {
            
                depts.add(dept);            
        }
        return depts;
    }
    
}
