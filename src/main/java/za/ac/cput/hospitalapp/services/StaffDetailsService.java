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
public interface StaffDetailsService {
    public String getFullName(Long staffId);
    public String getTitle(Long staffId);
    public String getContact(Long staffId);
    
}
