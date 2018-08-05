package com.school.domain.entity;
// Generated Jul 12, 2018 5:22:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Groups generated by hbm2java
 */
@Entity
@Table(name="groups"
    ,catalog="db_school"
)
public class Groups  implements java.io.Serializable {


     private Integer groupId;
     private String groupName;
     private Set<TeacherClasses> teacherClasseses = new HashSet<TeacherClasses>(0);
     private Set<StudentRecordBs> studentRecordBses = new HashSet<StudentRecordBs>(0);
     private Set<Subjects> subjectses = new HashSet<Subjects>(0);

    public Groups() {
    }

	
    public Groups(String groupName) {
        this.groupName = groupName;
    }
    public Groups(String groupName, Set<TeacherClasses> teacherClasseses, Set<StudentRecordBs> studentRecordBses, Set<Subjects> subjectses) {
       this.groupName = groupName;
       this.teacherClasseses = teacherClasseses;
       this.studentRecordBses = studentRecordBses;
       this.subjectses = subjectses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="group_id", unique=true, nullable=false)
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    
    @Column(name="group_name", nullable=false, length=45)
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="groups")
    public Set<TeacherClasses> getTeacherClasseses() {
        return this.teacherClasseses;
    }
    
    public void setTeacherClasseses(Set<TeacherClasses> teacherClasseses) {
        this.teacherClasseses = teacherClasseses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="groups")
    public Set<StudentRecordBs> getStudentRecordBses() {
        return this.studentRecordBses;
    }
    
    public void setStudentRecordBses(Set<StudentRecordBs> studentRecordBses) {
        this.studentRecordBses = studentRecordBses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="groups")
    public Set<Subjects> getSubjectses() {
        return this.subjectses;
    }
    
    public void setSubjectses(Set<Subjects> subjectses) {
        this.subjectses = subjectses;
    }




}


