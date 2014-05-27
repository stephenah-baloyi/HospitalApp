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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mhumhu
 */
@Entity
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String appointmentNum;
    private String app_time;
    private String app_date;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment() {
    }
    
    private Appointment(Builder builder) {
        id= builder.id;
        appointmentNum = builder.appointmentNum;
        app_time = builder.app_time;
        app_date = builder.app_date;
        staff = builder.staff;
        patient = builder.patient;
        
       }

 
    public static class Builder {

        private Long id;
        private String appointmentNum;
        private String app_time;
        private String app_date;
         Staff  staff;
         Patient  patient;
           
        public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder(String app_no) {
            this.appointmentNum = app_no;
            
        }
        public Builder app_time(String app_time) {
            this.app_time = app_time;
            return this;
        }

        public Builder app_date(String app_date) {
            this.app_date = app_date;
            return this;
        }

        public Builder staff(Staff  staff) {
            this.staff = staff;
            return this;
        }

        public Builder patient(Patient  patient) {
            this.patient = patient;
            return this;
        }
       
        public Builder appointment(Appointment appointment){
            id = appointment.getId();
            appointmentNum = appointment.getAppointmentNum();
            app_time = appointment.getApp_time();
            app_date = appointment.getApp_date();
            staff = appointment.getStaff();
            patient = appointment.getPatient();            
            return this;            
        }
        
        public Appointment build(){
            return new Appointment(this);
        }

    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(String appointmentNum) {
        this.appointmentNum = appointmentNum;
    }

    public String getApp_time() {
        return app_time;
    }

    public void setApp_time(String app_time) {
        this.app_time = app_time;
    }

    public String getApp_date() {
        return app_date;
    }

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Appointment[ id=" + id + " ]";
    }
    
}
