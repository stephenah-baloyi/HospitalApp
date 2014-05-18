/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services;

/**
 *
 * @author Mhumhu
 */
public interface PatientDetailsService {
    
    public String getFullName(Long ID);
    public String getContactNumbers(Long ID);
    public String getAddress(Long ID);
    
}
