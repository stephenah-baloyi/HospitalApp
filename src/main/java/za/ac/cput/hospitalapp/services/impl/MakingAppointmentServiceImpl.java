/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalapp.domain.Appointment;
import za.ac.cput.hospitalapp.repository.AppointmentRepository;
import za.ac.cput.hospitalapp.services.MakingAppointmentService;

/**
 *
 * @author Mhumhu
 */
@Service
public class MakingAppointmentServiceImpl implements MakingAppointmentService{

    @Autowired
    private AppointmentRepository appRepository;
    
    @Override
    public String makeAppointment(Long Id) {
        Appointment app = appRepository.findOne(Id);
        
       return app.getAppointmentNum();
    }
    
}
