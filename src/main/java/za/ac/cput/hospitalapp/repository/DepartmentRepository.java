/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.repository;

import java.util.List;
import za.ac.cput.hospitalapp.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Mhumhu
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
