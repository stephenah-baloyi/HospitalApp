/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.repository;

import za.ac.cput.hospitalapp.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Mhumhu
 */
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

  
}
