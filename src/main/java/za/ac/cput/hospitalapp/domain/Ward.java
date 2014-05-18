/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mhumhu
 */
@Entity
public class Ward implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String wardNum;
    private String status;
     private String wardGender;
    
    private Ward(Builder builder) {
        id = builder.id;
        wardNum = builder.wardNum;
        status = builder.status;
        wardGender = builder.wardGender;
        
        }

    public Ward() {
    }  
    
    public static class Builder{
    private Long id;
    private String wardNum;
    private String status;
    private String wardGender;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder(String wardNum)
        {
            this.wardNum = wardNum;
            
        }
        public Builder status(String status)
        {
            this.status = status;
            return this;
        }
        public Builder wardGender(String wardGender)
        {
            this.wardGender = wardGender;
            return this;
        }
        public Ward build(){
            return new Ward(this);
        }       
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWardNum() {
        return wardNum;
    }

    public void setWardNum(String wardNum) {
        this.wardNum = wardNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWardGender() {
        return wardGender;
    }

    public void setWardGender(String wardGender) {
        this.wardGender = wardGender;
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
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Ward[ id=" + id + " ]";
    }
    
}
