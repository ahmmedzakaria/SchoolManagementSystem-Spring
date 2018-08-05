/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import com.school.domain.entity.StudentRecordBs;
import com.school.domain.entity.Users;
import com.school.domain.support.StudentInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zakaria
 */
public class StudentInfoConverter {
    public static List<StudentInfo> convertStudentInfoList(List<Users> rbsList){
        List<StudentInfo> studentinfoList = new ArrayList();  
        rbsList.forEach(user -> {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setUsers(user);
            studentinfoList.add(studentInfo);
        });
        return studentinfoList;
    }
//public static List<StudentInfo> convertStudentInfoListForRbs(List<StudentRecordBs> rbsList){
//        List<StudentInfo> studentinfoList = new ArrayList();  
//        rbsList.forEach(user -> {
//            int index=0;
//            StudentInfo studentInfo = new StudentInfo();
//            List<StudentRecordBs>newrbsList=new ArrayList();
//            newrbsList.add(rbsList.get(index));
//            studentInfo.setStudentRecordBsList(newrbsList);
//            studentinfoList.add(studentInfo);
//            index++;
//        });
//        return studentinfoList;
//    }
public static StudentInfo convertStudentInfoListForRbs(List<StudentRecordBs> rbsList){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentRecordBsList(rbsList);
        return studentInfo;
    }
public static StudentRecordBs getStudentRecordBs(StudentInfo obj){
    List<StudentRecordBs> rbsList=obj.getStudentRecordBsList();
    if(rbsList!=null && rbsList.size()>0){
        return rbsList.get(0);
    }else{
        MyUtil.print("StudentInfoConverter", "null value for StudentInfo obj");
        return null;
    }
}









}


