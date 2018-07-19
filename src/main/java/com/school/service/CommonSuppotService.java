/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

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
import com.school.domain.support.CommonSupport;
import com.school.support.IGetAll;
import com.school.support.MyUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CommonSuppotService {
    @Autowired
    private IGetAll iGetAll;
    
    
    private List<Classes> classList;
    private List<Exams> examList;
    private List<Gender> genderList;
    private List<Grade> gradeList;
    private List<Groups> groupsList;
    private List<MarksPattern> marksPatternsList;
    private List<Religion> religionList;
    private List<Role> roleList;
    private List<Section> sectionList;
    private List<Subjects> subjectList;
    private List<StudentPaymentType> studentPaymentTypesList;
    private List<StudentSession> studentSessionsList;

    public static final String CLASSES="Classes";
    public static final String EXAMS="Exams";
    public static final String GRADE="Grade";
    public static final String GENDER="Gender";
    public static final String GROUPS="Groups";
    public static final String MARK_PATTERN="MarksPattern";
    public static final String RELIGION="Religion";
    public static final String ROLE="Role";
    public static final String SECTION="Section";
    public static final String SUBJECT="Subjects";
    public static final String STUDENT_PAYMENT_TYPE="StudentPaymentType";
    public static final String STUDENT_SESSION="StudentSession";



    
//    public CommonSuppotService(List<Gender> genderList, List<Religion> religionList, List<Role> roleList) {
//        this.genderList = getGenderList();
//        this.religionList = getReligionList();
//        this.roleList = getRoleList();
//    }
    
 
    public CommonSupport getCommonSupportServiceUser(){
        roleList=(List<Role>) iGetAll.get(CommonSuppotService.ROLE);
        religionList=(List<Religion>) iGetAll.get(CommonSuppotService.RELIGION);
        genderList=(List<Gender>) iGetAll.get(CommonSuppotService.GENDER);
        CommonSupport c=new CommonSupport(genderList,roleList,religionList);
        return c;
    }
    
       public CommonSupport getCommonSupportServiceStudent(){
        classList=(List<Classes>) iGetAll.get(CommonSuppotService.CLASSES);
        examList=(List<Exams>) iGetAll.get(CommonSuppotService.EXAMS);
        gradeList=(List<Grade>) iGetAll.get(CommonSuppotService.GRADE);
        groupsList=(List<Groups>) iGetAll.get(CommonSuppotService.GROUPS);
        marksPatternsList=(List<MarksPattern>) iGetAll.get(CommonSuppotService.MARK_PATTERN);
        sectionList=(List<Section>) iGetAll.get(CommonSuppotService.SECTION);
        subjectList=(List<Subjects>) iGetAll.get(CommonSuppotService.SUBJECT);

        studentSessionsList=(List<StudentSession>) iGetAll.get(CommonSuppotService.STUDENT_SESSION);

        CommonSupport c=new CommonSupport(classList,examList,gradeList,groupsList,marksPatternsList,sectionList,subjectList,studentSessionsList);
           MyUtil.print("SubjectsListSize", ""+subjectList.size());
        return c;
    }
    
    
    
    
    
    
    
    
    
    
    public List<Classes> getClassList() {     
        return (List<Classes>)iGetAll.get(CommonSuppotService.CLASSES);
    }

    public List<Exams> getExamList() {
        return (List<Exams>)iGetAll.get(CommonSuppotService.EXAMS);
    }

    public List<Gender> getGenderList() {
        return (List<Gender>)iGetAll.get(CommonSuppotService.EXAMS);
    }

    public List<Grade> getGradeList() {
        return (List<Grade>)iGetAll.get(CommonSuppotService.GRADE);
    }

    public List<Groups> getGroupsList() {
        return (List<Groups>)iGetAll.get(CommonSuppotService.GROUPS);
    }

    public List<MarksPattern> getMarksPatternsList() {
        return (List<MarksPattern>)iGetAll.get(CommonSuppotService.MARK_PATTERN);
    }

    public List<Religion> getReligionList() {
        return (List<Religion>)iGetAll.get(CommonSuppotService.RELIGION);
    }

    public List<Role> getRoleList() {
        return (List<Role>)iGetAll.get(CommonSuppotService.ROLE);
    }

    public List<Section> getSectionList() {
        return (List<Section>)iGetAll.get(CommonSuppotService.SECTION);
    }

    public List<Subjects> getSubjectsList() {
        return (List<Subjects>)iGetAll.get(CommonSuppotService.SUBJECT);
    }

    public List<StudentPaymentType> getStudentPaymentTypesList() {
        return (List<StudentPaymentType>)iGetAll.get(CommonSuppotService.STUDENT_PAYMENT_TYPE);
    }

    public List<StudentSession> getStudentSessionsList() {
        return (List<StudentSession>)iGetAll.get(CommonSuppotService.STUDENT_SESSION);
    }

  
    
    
    
}
