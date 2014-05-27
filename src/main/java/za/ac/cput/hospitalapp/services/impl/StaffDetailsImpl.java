/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalapp.domain.Contact;
import za.ac.cput.hospitalapp.domain.Name;
import za.ac.cput.hospitalapp.domain.Staff;
import za.ac.cput.hospitalapp.repository.StaffRepository;
import za.ac.cput.hospitalapp.services.StaffDetailsService;

/**
 *
 * @author Mhumhu
 */
@Service
public class StaffDetailsImpl implements StaffDetailsService{
    
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public String getFullName(Long staffId) {
        
        Staff staff = staffRepository.findOne(staffId);
        Name name = staff.getName();
        return name.getFname() + " " + name.getLname();
    }

    @Override
    public String getTitle(Long staffId) {
        Staff staff = staffRepository.findOne(staffId);
        return staff.getTitle();
    }

    @Override
    public String getContact(Long staffId) {
        
        Staff staff = staffRepository.findOne(staffId);
        Contact contact = staff.getContact();
        return contact.getAddress() + " " + contact.getLandline()
                + " " +contact.getCellnumber();
    }
    
}
