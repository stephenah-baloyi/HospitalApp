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
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patientNum;
    @Embedded
    private Name name;
    @Embedded
    private Contact contact;
    private String gender;
    private String age;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    List<Patient_Record> records;
    
       private Patient(Builder builder) {
        id= builder.id;
        patientNum = builder.patientNum;
        name = builder.name;
        age = builder.age;
        gender = builder.gender;
        contact = builder.contact;
        records = builder.records;
       }

    public Patient() {
    }
    

    public static class Builder {

        private Long id;
        private String patientNum;
        private Name name;
        private Contact contact;
        private String gender;
        private String age;
        List<Patient_Record> records;
   
        public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder(String patientno) {
            this.patientNum = patientno;
            
        }
        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder age(String dob) {
            age = dob;
            return this;
        }

        public Builder gender(String sex) {
            this.gender = sex;
            return this;
        }

        public Builder records(List<Patient_Record> patient_record) {
            this.records = patient_record;
            return this;
        }
       
        public Builder patient(Patient patient){
            id = patient.getId();
            patientNum = patient.getPatientNum();
            name = patient.getName();
            contact = patient.getContact();
            gender = patient.getGender();
            age = patient.getAge();
            records = patient.getRecords();
            return this;
            
        }
        
        public Patient build(){
            return new Patient(this);
        }

    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(String patientNum) {
        this.patientNum = patientNum;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Patient_Record> getRecords() {
        return records;
    }

    public void setRecords(List<Patient_Record> records) {
        this.records = records;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Patient[ id=" + id + " ]";
    }
    
}
