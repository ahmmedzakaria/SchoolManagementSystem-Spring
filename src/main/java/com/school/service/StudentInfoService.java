/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;
import com.school.domain.entity.StudentRecordBs;
import com.school.domain.entity.Users;
import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;
import com.school.support.MyConstent;
import com.school.support.MyUtil;
import com.school.support.StudentInfoConverter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class StudentInfoService implements ISupportService<StudentInfo> {

    @Qualifier(value = "usreDao")
    @Autowired
    private ISupportDao<Users> iUserDao;

    @Qualifier(value = "studentRecordBsDao")
    @Autowired
    private ISupportDao<StudentRecordBs> iStudentRecordBsDao;
    
    @Qualifier(value = "studentRecordBsService")
    @Autowired
    private ISupportService<StudentInfo> iStudentRecordBsService;

    @Qualifier(value = "commonSuppotService")
    @Autowired
    private CommonSuppotService commonSuppotService;

    @Override
    public boolean add(StudentInfo obj) {
        Users user = obj.getUsers();
        iUserDao.add(user);
        int roleId = user.getRole().getRoleId();
        MyUtil.print("RoleId in StudentinfoService", MyConstent.Role.STUDENT + " " + roleId);

        if (roleId == MyConstent.Role.STUDENT) {
            Users insertedUser = insertedUser = iUserDao.add(user);
            StudentRecordBs rbs = null;

            MyUtil.print("StudentBsList Size", obj.getStudentRecordBsList().size() + "");
            rbs = obj.getStudentRecordBsList().get(0);
            rbs.setUsers(insertedUser);
            MyUtil.print("rbs Save Service", rbs.toString());
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
        Users user = obj.getUsers(); 
        int roleId = user.getRole().getRoleId();
        System.out.println("User: \n" + obj.toString());;
        iUserDao.update(user);
        
        if (roleId == MyConstent.Role.STUDENT) {
//            Users insertedUser = insertedUser = iUserDao.add(user);
            StudentRecordBs rbs = null;

//            MyUtil.print("StudentBsList Size", obj.getStudentRecordBsList().size() + "");
            rbs = obj.getStudentRecordBsList().get(0);
            MyUtil.print("rbs update Service", rbs.toString());
//            rbs.setUsers(insertedUser);
            iStudentRecordBsDao.update(rbs);
        }
        return true;
    }

    @Override
    public List<StudentInfo> getAll() {
//        System.out.println("GetAll Student StudentInfo............");
//        List<StudentInfo> StudentinfoList = new ArrayList();  
//        List<Users> userList = iUserDao.getAllByRole(4);
//        userList.forEach(user -> {
//            StudentInfo studentInfo = new StudentInfo();
//            studentInfo.setUsers(user);
//            StudentinfoList.add(studentInfo);
//        });
        return StudentInfoConverter.convertStudentInfoList(iUserDao.getAllByRole(MyConstent.Role.STUDENT));
        // return iUserDao.getAll();
    }
    
    

    @Override
    public StudentInfo getById(int id) {

        StudentInfo studentInfo = new StudentInfo();
        Users users = iUserDao.getById(id);
        StudentRecordBs studentRecordBs = iStudentRecordBsDao.getById(users.getUserId());
        List<StudentRecordBs> studentRecordBseList = new ArrayList();
        studentRecordBseList.add(studentRecordBs);
        studentInfo.setUsers(users);
        studentInfo.setStudentRecordBsList(studentRecordBseList);
        return studentInfo;
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceStudent();
        //return null;
    }

    @Override
    public List<StudentInfo> getAllWithoutStudent() {  
        return StudentInfoConverter.convertStudentInfoList(iUserDao.getAllWithoutStudent());
    }
   

    @Override
    public int getMaxRoll(int sectionId, int classId, int groupId, int sessionId) {
        return iStudentRecordBsService.getMaxRoll(sectionId, classId, groupId, sessionId);
    }

    @Override
    public StudentInfo getAllByClassSectionGroupInfo(int sessionId, int classId, int sectionId, int groupId) {
        return iStudentRecordBsService.getAllByClassSectionGroupInfo(sessionId, classId, sectionId,groupId);
    }

    @Override
    public StudentInfo getAllByClassAndSectionInfo(int sessionId, int classId, int sectionId) {
        return iStudentRecordBsService.getAllByClassAndSectionInfo(sessionId, classId, sectionId);
    }

    @Override
    public StudentInfo getAllByClassInfo(int sessionId, int classId) {
        StudentInfo studentInfo= iStudentRecordBsService.getAllByClassInfo(sessionId, classId);
        return studentInfo; 
    }

         @Override
    public StudentInfo getAllBySessionInfo(int sessionId) {
        
       StudentInfo studentInfo= iStudentRecordBsService.getAllBySessionInfo(sessionId);
       //return StudentInfoConverter.convertStudentInfoListForRbs(rbsList);
       return studentInfo;
    }
   

    @Override
    public int addAll(List<StudentInfo> list) {
        return ISupportService.super.addAll(list); //To change body of generated methods, choose Tools | Templates.
    }
}
