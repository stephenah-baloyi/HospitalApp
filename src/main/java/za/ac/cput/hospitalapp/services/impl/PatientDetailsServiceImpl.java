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
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.repository.PatientRepository;
import za.ac.cput.hospitalapp.services.PatientDetailsService;

/**
 *
 * @author Mhumhu
 */
@Service
public class PatientDetailsServiceImpl implements PatientDetailsService{

    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public String getFullName(Long ID) {
        
        Patient p = patientRepository.findById(ID);
        Name name = p.getName();
        return name.getFname() + " " + name.getLname();
    }

    @Override
    public String getContactNumbers(Long ID) {
        
        Patient p = patientRepository.findById(ID);
        Contact contact = p.getContact();
        return contact.getLandline() + " " +contact.getCellnumber();
    }

    @Override
    public String getAddress(Long ID) {
        Patient p = patientRepository.findById(ID);
        Contact contact = p.getContact();
        return contact.getAddress();
    }
    
}
