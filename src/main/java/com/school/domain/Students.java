package com.school.domain;
// Generated Jul 4, 2018 7:25:15 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Students generated by hbm2java
 */
@Entity
@Table(name="students"
    ,catalog="db_school"
)
public class Students  implements java.io.Serializable {


     private Integer studentId;
     private Guardian guardian;
     private Users users;
     private String fatherName;
     private String motherName;
     private Date dob;

    public Students() {
    }

    public Students(Guardian guardian, Users users, String fatherName, String motherName, Date dob) {
       this.guardian = guardian;
       this.users = users;
       this.fatherName = fatherName;
       this.motherName = motherName;
       this.dob = dob;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="student_id", unique=true, nullable=false)
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="guardian_id", nullable=false)
    public Guardian getGuardian() {
        return this.guardian;
    }
    
    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    
    @Column(name="father_name", nullable=false, length=45)
    public String getFatherName() {
        return this.fatherName;
    }
    
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    
    @Column(name="mother_name", nullable=false, length=45)
    public String getMotherName() {
        return this.motherName;
    }
    
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dob", nullable=false, length=0)
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }




}


