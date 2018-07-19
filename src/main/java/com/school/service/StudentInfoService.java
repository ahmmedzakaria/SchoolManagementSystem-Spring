/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.dao.support.IStudentRecordBsDao;
import com.school.dao.support.IUserDao;
import com.school.domain.entity.Classes;
import com.school.domain.entity.Groups;
import com.school.domain.entity.Section;
import com.school.domain.entity.StudentRecordBs;
import com.school.domain.entity.StudentSession;
import com.school.domain.entity.Users;
import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.service.support.IStudentInfoService;
import com.school.support.MyUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class StudentInfoService implements IStudentInfoService<StudentInfo> {

    @Autowired
    private IUserDao<Users> iUserDao;

    @Autowired
    private IStudentRecordBsDao<StudentRecordBs> iStudentRecordBsDao;

    @Qualifier(value = "commonSuppotService")
    @Autowired
    private CommonSuppotService commonSuppotService;

//    @Autowired
//    private IGetAll iGetAll;

    @Override
    public boolean add(StudentInfo obj) {
        Users user = obj.getUsers();
        Users insertedUser=iUserDao.add(user);
        MyUtil.print("Student Info", "StudentInfo: "+user.getFirstName()+" inserted Successfully");
        if(user.getRole().getRoleId()==4){
        StudentRecordBs rbs=new StudentRecordBs();
        rbs.setUsers(insertedUser);
        Classes cls=new Classes();
        cls.setClassId(6);
        rbs.setClasses(cls);
        Section section=new Section();
        section.setSectionId(1);
        rbs.setSection(section);
        StudentSession session =new StudentSession();
        session.setSessionId(1);
        rbs.setStudentSession(session);
        Groups group=new Groups();
        group.setGroupId(1);
        rbs.setGroups(group);
        rbs.setRollNumber(2);
        rbs.setRecordDate(new Date());
        System.out.println("Inserting iStudentRecordBsDao---------------- ");
        iStudentRecordBsDao.add(rbs);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        iUserDao.delete(id);
        return true;
    }

    @Override
    public boolean update(StudentInfo obj) {
        System.out.println("User: \n" + obj.toString());;
        iUserDao.update(obj.getUsers());
        return true;
    }

    @Override
    public List<StudentInfo> getAll() {
        System.out.println("GetAll Student StudentInfo............");
        List<StudentInfo> StudentinfoList = new ArrayList();
        
//        allClasses.forEach(System.out::println);    
        List<Users> userList = iUserDao.getAllByRole(4);
        userList.forEach(user -> {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setUsers(user);
            StudentinfoList.add(studentInfo);
        });
        return StudentinfoList;
        // return iUserDao.getAll();
    }

    @Override
    public StudentInfo getById(int id) {

        StudentInfo studentInfo = new StudentInfo();
        Users users=iUserDao.getById(id);
        StudentRecordBs studentRecordBs = iStudentRecordBsDao.getById(users.getUserId());
        List<StudentRecordBs> studentRecordBseList=new ArrayList();
        studentRecordBseList.add(studentRecordBs);
        studentInfo.setUsers(users);
        studentInfo.setStudentRecordBsList(studentRecordBseList);
        //studentRecordBs.getClass();
        //user.getStudentRecordBses().add(studentRecordBs);
        //System.out.println("student:" + iStudentRecordBsDao.getById(id));
        return studentInfo;
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceStudent();
       //return null;
    }

}
