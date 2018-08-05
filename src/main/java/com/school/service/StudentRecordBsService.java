/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.domain.entity.StudentRecordBs;

import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;
import com.school.support.StudentInfoConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class StudentRecordBsService implements ISupportService<StudentInfo>{
    
    @Qualifier(value = "studentRecordBsDao")
    @Autowired
    private ISupportDao<StudentRecordBs> iStudentRecordBsDao;
    
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
//    @Autowired
//    private IGetAll iGetAll;

    @Override
    public boolean add(StudentInfo obj) {
        
        StudentRecordBs rbs=StudentInfoConverter.getStudentRecordBs(obj);
        iStudentRecordBsDao.add(rbs);
        return true;
    }

    
    @Override
    public boolean delete(int id) {
        iStudentRecordBsDao.delete(id);
        return true;
    }

    @Override
    public boolean update(StudentInfo obj) {
        iStudentRecordBsDao.update(StudentInfoConverter.getStudentRecordBs(obj));
        return true;
    }

    @Override
    public List<StudentInfo> getAll() {
           
        //return iStudentRecordBsDao.getAll();
        return null;
    }

    @Override
    public StudentInfo getById(int id) {   
        //return iStudentRecordBsDao.getById(id);
        return null;
    }
    
   

    @Override
    public int getMaxRoll(int sectionId, int classId, int groupId, int sessionId) {
        return iStudentRecordBsDao.getMaxRoll(sectionId, classId , sessionId, groupId);
    }

    @Override
    public StudentInfo getAllByClassSectionGroupInfo(int sessionId, int classId, int sectionId, int groupId) {
        List<StudentRecordBs> rbsList= iStudentRecordBsDao.getAllByClassSectionGroup(sessionId, classId, sectionId, groupId);
       return StudentInfoConverter.convertStudentInfoListForRbs(rbsList);
    }

    @Override
    public StudentInfo getAllByClassAndSectionInfo(int sessionId, int classId, int sectionId) {
        List<StudentRecordBs> rbsList= iStudentRecordBsDao.getAllByClassAndSection(sessionId,classId,sectionId);
       return StudentInfoConverter.convertStudentInfoListForRbs(rbsList);
    }

    @Override
    public StudentInfo getAllByClassInfo(int sessionId, int classId) {
        List<StudentRecordBs> rbsList= iStudentRecordBsDao.getAllByClass(sessionId,classId);
       return StudentInfoConverter.convertStudentInfoListForRbs(rbsList);
    }

    @Override
    public StudentInfo getAllBySessionInfo(int sessionId) {
       List<StudentRecordBs> rbsList= iStudentRecordBsDao.getAllBySession(sessionId);
       return StudentInfoConverter.convertStudentInfoListForRbs(rbsList);
    }

    
    

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

    
}
