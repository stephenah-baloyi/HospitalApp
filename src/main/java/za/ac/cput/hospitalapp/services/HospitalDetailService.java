/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services;

import java.util.List;
import za.ac.cput.hospitalapp.domain.Department;

/**
 *
 * @author Mhumhu
 */
public interface HospitalDetailService {
    
    public String getHospitalName(Long ID);
    public String getAddress(Long ID);
    public List<Department> getDepartments(Long ID);
}
