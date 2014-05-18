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
public class Patient_Record implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String recordNum;
    private String description;
    private String prescription;
    private double amount;
    
    private Patient_Record(Builder builder)
    {
        id = builder.id;
        recordNum = builder.recordNum;
        description = builder.description;
        prescription = builder.prescription;
        amount = builder.amount;
    }
    public Patient_Record(){
      }
    
    public static class Builder
    {
         private Long id;
        private String recordNum;
        private String description;
        private String prescription;
        private double amount;
        
        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }
        public Builder(String recordno)
        {
            this.recordNum = recordno;
            
        }
        public Builder amount(double value)
        {
            this.amount = value;
            return this;
        }
        public Builder description(String desc)
        {
            this.description = desc;
            return this;
        }
        public Builder prescription(String presc)
        {
            this.prescription = presc;
            return this;
        }
        public Patient_Record build()
        {
            return new Patient_Record(this);
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        if (!(object instanceof Patient_Record)) {
            return false;
        }
        Patient_Record other = (Patient_Record) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Patient_Record[ id=" + id + " ]";
    }
    
}
