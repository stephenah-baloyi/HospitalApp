/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Mhumhu
 */
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deptID;
    private String deptName;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private List<Ward> ward;
    
    private Department(Builder builder) {
        id = builder.id;
        deptID = builder.deptID;
        deptName = builder.deptName;
        ward = builder.ward;
        }

    public Department() {
    }
    
    
    
    public static class Builder{
    private Long id;
    private String deptID;
    private String deptName;
    List<Ward> ward;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder(String deptId)
        {
            this.deptID = deptId;
            
        }
        public Builder deptName(String deptName)
        {
            this.deptName = deptName;
            return this;
        }
        public Builder ward(List<Ward>  ward) {
            this.ward = ward;
            return this;
        }
        public Builder department(Department dept){
            id = dept.getId();
            deptID = dept.getDeptID();
            deptName = dept.getDeptName();
            ward = dept.getWard();
            return this;
            
        }
        public Department build(){
            return new Department(this);
        }       
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Ward> getWard() {
        return ward;
    }

    public void setWard(List<Ward> ward) {
        this.ward = ward;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Department[ id=" + id + " ]";
    }
    
}
