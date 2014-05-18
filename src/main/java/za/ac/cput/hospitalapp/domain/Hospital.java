/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
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
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private Contact contact;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private List<Department> department;
    
    private Hospital(Builder builder) {
        id = builder.id;
        name = builder.name;
        contact = builder.contact;
        department = builder.department;
        }

    public Hospital() {
    }
    
    
    
    public static class Builder{
    private Long id;
    private Contact contact;
    private String name;
    List<Department> department;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder (String name)
        {
            this.name = name;
            
        }
        public Builder contact(Contact contact)
        {
            this.contact = contact;
            return this;
        }
        public Builder department(List<Department>  department) {
            this.department = department;
            return this;
        }
        public Hospital build(){
            return new Hospital(this);
        }       
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
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
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Hospital[ id=" + id + " ]";
    }
    
}
