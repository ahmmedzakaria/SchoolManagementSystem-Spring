/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.domain.support;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.school.domain.entity.Classes;
import com.school.domain.entity.Exams;
import com.school.domain.entity.Gender;
import com.school.domain.entity.Grade;
import com.school.domain.entity.Groups;
import com.school.domain.entity.MarksPattern;
import com.school.domain.entity.Religion;
import com.school.domain.entity.Role;
import com.school.domain.entity.Section;
import com.school.domain.entity.StudentPaymentType;
import com.school.domain.entity.StudentSession;
import com.school.domain.entity.Subjects;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CommonSupport {
     private List<Classes> classList=new ArrayList();
    private List<Exams> examList=new ArrayList();
    private List<Gender> genderList=new ArrayList();
    private List<Grade> gradeList=new ArrayList();
    private List<Groups> groupsList=new ArrayList();
    private List<MarksPattern> marksPatternsList=new ArrayList();
    private List<Religion> religionList=new ArrayList();
    private List<Role> roleList=new ArrayList();
    private List<Section> sectionList=new ArrayList();
    private List<Subjects> subjectList=new ArrayList();
    private List<StudentPaymentType> studentPaymentTypesList=new ArrayList();
    private List<StudentSession> studentSessionsList=new ArrayList();

    public CommonSupport() {
    }

     public CommonSupport(List<Gender> genderList, List<Role> roleList,List<Religion> religionList) {
        this.roleList = roleList;
        this.genderList=genderList;
        this.religionList=religionList;
    }

     public CommonSupport(List<Classes> classList,List<Exams> examList,List<Grade> gradeList,List<Groups> groupsList,List<MarksPattern> marksPatternsList,List<Section> sectionList,List<Subjects> subjectList,List<StudentSession> studentSessionsList) {
        this.classList = classList;
        this.examList=examList;
        this.gradeList=gradeList;
        this.groupsList=groupsList;
        this.marksPatternsList=marksPatternsList;
        this.sectionList=sectionList;
        this.subjectList=subjectList;
        this.studentSessionsList=studentSessionsList;


    }
    
     public List<Classes> getClassList() {
        return classList;
    }

    public List<Exams> getExamList() {
        return examList;
    }

    public List<Gender> getGenderList() {
        return genderList;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public List<Groups> getGroupsList() {
        return groupsList;
    }

    public List<MarksPattern> getMarksPatternsList() {
        return marksPatternsList;
    }

    public List<Religion> getReligionList() {
        return religionList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public List<Subjects> getSubjectsList() {
        return subjectList;
    }

    public List<StudentPaymentType> getStudentPaymentTypesList() {
        return studentPaymentTypesList;
    }

    public List<StudentSession> getStudentSessionsList() {
        return studentSessionsList;
    }
}
