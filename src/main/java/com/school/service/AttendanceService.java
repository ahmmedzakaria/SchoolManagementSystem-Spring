/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.domain.entity.Attendance;
import com.school.domain.entity.AttendanceReport;
import com.school.domain.entity.Months;
import com.school.domain.entity.StudentRecordBs;

import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;
import com.school.support.MyUtil;
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
public class AttendanceService implements ISupportService<StudentInfo> {

    @Qualifier(value = "attendanceDao")
    @Autowired
    private ISupportDao<Attendance> iSupportDao;

    @Qualifier(value = "attendanceReportDao")
    @Autowired
    private ISupportDao<AttendanceReport> iAttendanceReportDao;

    @Qualifier(value = "studentRecordBsDao")
    @Autowired
    private ISupportDao<StudentRecordBs> iStudentRecordBsDao;
    @Autowired
    private CommonSuppotService commonSuppotService;

//    @Autowired
//    private IGetAll iGetAll;
    @Override
    public boolean add(StudentInfo obj) {
        List<Attendance> attendanceList = obj.getAttendancesList();
        MyUtil.print("attendanceList Size", attendanceList.size() + "");
        int month = MyUtil.getCurrentMonth() + 1;
        Months mon = new Months();
        mon.setMonthId(month);
        attendanceList.forEach(a -> {
            if (iAttendanceReportDao.getAttendanceReportByMonth(a.getStudentRecordBs().getRecordBsId(), month) == null) {
                AttendanceReport ar = new AttendanceReport();
                ar.setStudentRecordBs(a.getStudentRecordBs());

                ar.setMonths(mon);
                iAttendanceReportDao.add(ar);
            }
            iSupportDao.add(a);

        });
        return true;
    }

    @Override
    public int addAll(List<StudentInfo> list) {
        return 0;
    }
    
    @Override
    public StudentInfo getListById(int recordBsId) {
        List<Attendance> aList = iSupportDao.getListById(recordBsId);
        StudentRecordBs studentRecordBs=iStudentRecordBsDao.getRecordBsById(recordBsId);
        List<StudentRecordBs> rbsList=new ArrayList();
        rbsList.add(studentRecordBs);
        StudentInfo studentInfo=new StudentInfo();
        //studentInfo.setStudentRecordBs(studentRecordBs);
        studentInfo.setStudentRecordBsList(rbsList);
        studentInfo.setAttendancesList(aList);
        return studentInfo;
    }

    @Override
    public boolean delete(int id) {
        iSupportDao.delete(id);
        return true;
    }

    @Override
    public boolean update(StudentInfo obj) {

        //iSupportDao.update(obj);
        return true;
    }
    
     @Override
    public StudentInfo getAttendanceForClass(int sessionId,int classId, int sectionId, int groupId){
       List<Integer> recordBsIdList=iStudentRecordBsDao.getRecordBsIdList(sessionId, classId, sectionId, groupId);
       StudentInfo studentInfo=new StudentInfo();
       List<Attendance> attendanceList=null;
       if(recordBsIdList!=null && recordBsIdList.size()>0){
       attendanceList=iSupportDao.getAttendanceForClass(recordBsIdList);
       
       
       studentInfo.setAttendancesList(attendanceList);
       }
        return studentInfo;
    }

    @Override
    public List<StudentInfo> getAll() {
        iSupportDao.getAll();
        return null;
    }

    @Override
    public StudentInfo getAllAttendance() {
        //iSupportDao.getAll();
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setAttendancesList(iSupportDao.getAll());
        return studentInfo;
    }

    @Override
    public StudentInfo getById(int id) {
        return null;
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceStudent();
    }

    @Override
    public int getMaxRoll(int sectionId, int classId, int groupId, int sessionId) {
        return ISupportService.super.getMaxRoll(sectionId, classId, groupId, sessionId); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<StudentInfo> getAllBySession(int sessionId) {
//       List<StudentRecordBs> rbsList= iStudentRecordBsService.getAllBySession(sessionId);
//       return StudentInfoConverter.convertStudentInfoListForRbs(rbsList);
//    }
    @Override
    public List<StudentInfo> getAllWithoutStudent() {
        return ISupportService.super.getAllWithoutStudent(); //To change body of generated methods, choose Tools | Templates.
    }

}
