/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service.support;

import com.school.domain.Classes;
import com.school.domain.Exams;
import com.school.domain.Gender;
import com.school.domain.Grade;
import com.school.domain.Groups;
import com.school.domain.MarksPattern;
import com.school.domain.Religion;
import com.school.domain.Role;
import com.school.domain.Section;
import com.school.domain.StudentPaymentType;
import com.school.domain.StudentSession;
import com.school.support.IGetAll;
import java.util.List;
import javax.security.auth.Subject;
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
    private List<Subject> subjectList;
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
    public static final String SUBJECT="Subject";
    public static final String STUDENT_PAYMENT_TYPE="StudentPaymentType";
    public static final String STUDENT_SESSION="StudentSession";

    public CommonSuppotService(List<Gender> genderList, List<Religion> religionList, List<Role> roleList) {
        this.genderList = getGenderList();
        this.religionList = getReligionList();
        this.roleList = getRoleList();
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

    public List<Subject> getSubjectList() {
        return (List<Subject>)iGetAll.get(CommonSuppotService.SUBJECT);
    }

    public List<StudentPaymentType> getStudentPaymentTypesList() {
        return (List<StudentPaymentType>)iGetAll.get(CommonSuppotService.STUDENT_PAYMENT_TYPE);
    }

    public List<StudentSession> getStudentSessionsList() {
        return (List<StudentSession>)iGetAll.get(CommonSuppotService.STUDENT_SESSION);
    }

  
    
    
    
}
