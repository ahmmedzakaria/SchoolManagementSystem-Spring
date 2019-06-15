package com.school.domain.entity;
// Generated Aug 3, 2018 10:07:42 PM by Hibernate Tools 4.3.1


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
 * Attendance generated by hbm2java
 */
@Entity
@Table(name="attendance"
    ,catalog="db_school"
)
public class Attendance  implements java.io.Serializable {


     private Integer attendanceId;
     private Months months;
     private StudentRecordBs studentRecordBs;
     private int attendanceStatus;
     private Date attendanceDate;

    public Attendance() {
    }

    public Attendance(Months months, StudentRecordBs studentRecordBs, int attendanceStatus, Date attendanceDate) {
       this.months = months;
       this.studentRecordBs = studentRecordBs;
       this.attendanceStatus = attendanceStatus;
       this.attendanceDate = attendanceDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="attendance_id", unique=true, nullable=false)
    public Integer getAttendanceId() {
        return this.attendanceId;
    }
    
    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="month_id", nullable=false)
    public Months getMonths() {
        return this.months;
    }
    
    public void setMonths(Months months) {
        this.months = months;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="record_bs_id", nullable=false)
    public StudentRecordBs getStudentRecordBs() {
        return this.studentRecordBs;
    }
    
    public void setStudentRecordBs(StudentRecordBs studentRecordBs) {
        this.studentRecordBs = studentRecordBs;
    }

    
    @Column(name="attendance_status", nullable=false)
    public int getAttendanceStatus() {
        return this.attendanceStatus;
    }
    
    public void setAttendanceStatus(int attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="attendance_date", nullable=false, length=10)
    public Date getAttendanceDate() {
        return this.attendanceDate;
    }
    
    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }




}

