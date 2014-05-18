 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.hospitalapp.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mhumhu
 */
@Entity
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String staffNum;
    private String gender;
    private String age;
    private String title;
    @Embedded
    private Contact contact;
    @Embedded
    private Name name;
    
        private Staff(Builder builder) {
        id = builder.id;
        name = builder.name;
        contact = builder.contact;
        staffNum = builder.staffNum;
        gender = builder.gender;
        age = builder.age;
        title = builder.title;
        }

    public Staff() {
    }
    
    
    
    public static class Builder{
    private Long id;
    private String staffNum;
    private String gender;
    private String age;
    private String title;
    private Contact contact;
    private Name name;
        
        public Builder(String staffNum) {
            this.staffNum = staffNum;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder name(Name name)
        {
            this.name = name;
            return this;
        }
        public Builder contact(Contact contact)
        {
            this.contact = contact;
            return this;
        }
        /*public Builder staffNum(String staff_no)
        {
            this.staffNum = staff_no;
            return this;
        }*/
        public Builder gender(String sex)
        {
            this.gender = sex;
            return this;
        }
        public Builder age(String dob)
        {
            this.age = dob;
            return this;
        }
        public Builder title(String title)
        {
            this.title = title;
            return this;
        }
        public Staff build(){
            return new Staff(this);
        }
    
        
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
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
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cput.hospitalapp.domain.Staff[ id=" + id + " ]";
    }
    
}
