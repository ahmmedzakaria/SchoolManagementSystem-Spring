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
 * Gender generated by hbm2java
 */
@Entity
@Table(name="gender"
    ,catalog="db_school"
)
public  class Gender  implements java.io.Serializable {


     private Integer genderId;
     private String genderName;
     private Set<Users> userses = new HashSet<Users>(0);

    public  Gender() {
    }

	
    public Gender(String genderName) {
        this.genderName = genderName;
    }
    public Gender(String genderName, Set<Users> userses) {
       this.genderName = genderName;
       this.userses = userses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="gender_id", unique=true, nullable=false)
    public  Integer getGenderId() {
        return this.genderId;
    }
    
    public  void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    
    @Column(name="gender_name", nullable=false, length=45)
    public  String getGenderName() {
        return this.genderName;
    }
    
    public  void setGenderName(String genderName) {
        this.genderName = genderName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="gender")
    public  Set<Users> getUserses() {
        return this.userses;
    }
    
    public  void setUserses(Set<Users> userses) {
        this.userses = userses;
    }




}


