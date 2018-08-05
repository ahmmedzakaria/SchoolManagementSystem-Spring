/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.domain.support;

import com.school.domain.entity.Attendance;
import com.school.domain.entity.AttendanceReport;
import com.school.domain.entity.Marks;
import com.school.domain.entity.StudentRecordBs;
import com.school.domain.entity.Users;
import java.util.List;

/**
 *
 * @author User
 */
public class StudentInfo {
//    private int studentInfoId;
    private Users users;
//    private IdSupport idSupport;
//    private Attendance attendance;
//    private AttendanceReport attendanceReport;
//    private Marks marks;
//    private StudentRecordBs studentRecordBs;
    private List<StudentRecordBs> studentRecordBsList;
    private List<Attendance> attendancesList;
    private List<AttendanceReport> AttendanceReportList;
    private List<Marks> markList;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<StudentRecordBs> getStudentRecordBsList() {
        return studentRecordBsList;
    }

    public void setStudentRecordBsList(List<StudentRecordBs> studentRecordBsList) {
        this.studentRecordBsList = studentRecordBsList;
    }

    public List<Attendance> getAttendancesList() {
        return attendancesList;
    }

    public void setAttendancesList(List<Attendance> attendancesList) {
        this.attendancesList = attendancesList;
    }

    public List<AttendanceReport> getAttendanceReportList() {
        return AttendanceReportList;
    }

    public void setAttendanceReportList(List<AttendanceReport> AttendanceReportList) {
        this.AttendanceReportList = AttendanceReportList;
    }

    public List<Marks> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Marks> markList) {
        this.markList = markList;
    }
//
//    public IdSupport getIdSupport() {
//        return idSupport;
//    }
//
//    public void setIdSupport(IdSupport idSupport) {
//        this.idSupport = idSupport;
//    }
//
//    public Attendance getAttendance() {
//        return attendance;
//    }
//
//    public void setAttendance(Attendance attendance) {
//        this.attendance = attendance;
//    }
//
//    public AttendanceReport getAttendanceReport() {
//        return attendanceReport;
//    }
//
//    public void setAttendanceReport(AttendanceReport attendanceReport) {
//        this.attendanceReport = attendanceReport;
//    }
//
//    public Marks getMarks() {
//        return marks;
//    }
//
//    public void setMarks(Marks marks) {
//        this.marks = marks;
//    }

//    public StudentRecordBs getStudentRecordBs() {
//        return studentRecordBs;
//    }
//
//    public void setStudentRecordBs(StudentRecordBs studentRecordBs) {
//        this.studentRecordBs = studentRecordBs;
//    }

    
    
}
