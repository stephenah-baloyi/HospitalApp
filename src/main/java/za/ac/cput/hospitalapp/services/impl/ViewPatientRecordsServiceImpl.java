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
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.domain.Patient_Record;
import za.ac.cput.hospitalapp.repository.PatientRecordRepository;
import za.ac.cput.hospitalapp.repository.PatientRepository;
import za.ac.cput.hospitalapp.services.ViewPatientRecordsService;

/**
 *
 * @author Mhumhu
 */
@Service
public class ViewPatientRecordsServiceImpl implements ViewPatientRecordsService{

    @Autowired
    private PatientRecordRepository recordRepository;
    private PatientRepository patientRepository;
    
    @Override
    public List<Patient_Record> viewRecords(Patient Id, Long ID) {
                
        Patient_Record record = recordRepository.findOne(ID);
        
        List<Patient_Record> records = new ArrayList();
        
        if(Id.equals(record.getId()) )
        {
            List<Patient_Record> allRecords = recordRepository.findAll();
            for (Patient_Record rec : allRecords) {
            
                records.add(rec);            
             }
        } 
        
        return records;
    }
    
}
