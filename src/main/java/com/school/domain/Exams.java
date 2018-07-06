package com.school.domain;
// Generated Jul 4, 2018 7:25:15 PM by Hibernate Tools 4.3.1


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
 * Exams generated by hbm2java
 */
@Entity
@Table(name="exams"
    ,catalog="db_school"
)
public class Exams  implements java.io.Serializable {


     private Integer examId;
     private String examName;
     private Set<Marks> markses = new HashSet<Marks>(0);

    public Exams() {
    }

	
    public Exams(String examName) {
        this.examName = examName;
    }
    public Exams(String examName, Set<Marks> markses) {
       this.examName = examName;
       this.markses = markses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="exam_id", unique=true, nullable=false)
    public Integer getExamId() {
        return this.examId;
    }
    
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    
    @Column(name="exam_name", nullable=false, length=45)
    public String getExamName() {
        return this.examName;
    }
    
    public void setExamName(String examName) {
        this.examName = examName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="exams")
    public Set<Marks> getMarkses() {
        return this.markses;
    }
    
    public void setMarkses(Set<Marks> markses) {
        this.markses = markses;
    }




}


