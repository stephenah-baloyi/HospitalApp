/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services;

import java.util.List;
import za.ac.cput.hospitalapp.domain.Patient;
import za.ac.cput.hospitalapp.domain.Patient_Record;

/**
 *
 * @author Mhumhu
 */
public interface ViewPatientRecordsService {
    
    public List<Patient_Record> viewRecords(Patient Id, Long ID);
}
