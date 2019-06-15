/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.entity.Attendance;
import com.school.domain.entity.Months;
import com.school.support.ISupportDao;
import com.school.support.MyUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Faculty
 */
@Transactional
@Repository
public class AttendanceDao implements ISupportDao<Attendance> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Attendance add(Attendance obj) {
        Attendance attendance = getAttendanceIfExist(obj);
        if (attendance == null) {
            obj.setAttendanceDate(new Date());
            Months mon=new Months();
            mon.setMonthId(MyUtil.getCurrentMonth()+1);
            obj.setMonths(mon);
            attendance = obj;
        } else {
            attendance.setAttendanceStatus(obj.getAttendanceStatus());
        }
        hibernateTemplate.saveOrUpdate(attendance);
        return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Attendance obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<Attendance> getAll() {
        String hql = "FROM Attendance obj LEFT JOIN FETCH  obj.studentRecordBs";
        return (List<Attendance>) hibernateTemplate.find(hql);
    }

    @Override
    public Attendance getById(int id) {
        return hibernateTemplate.get(Attendance.class, id);
    }

    @Override
    public List<Attendance> getListById(int recordBsId) {
        String hql = "FROM Attendance obj where obj.studentRecordBs.recordBsId=?";
        List<Attendance> aList = new ArrayList();
        aList = (List<Attendance>) hibernateTemplate.find(hql,recordBsId);
        return aList;
    }

    ;
    
    @Override
    public boolean isAttendanceExist(Attendance obj) {
        String hql = "FROM Attendance obj where obj.studentRecordBs.recordBsId=? and obj.attendanceDate=?";
        List<Attendance> aList = new ArrayList();
        aList = (List<Attendance>) hibernateTemplate.find(hql, obj.getStudentRecordBs().getRecordBsId(), new Date());
        MyUtil.print("isAttendanceExist", aList.size() + "");

        return (aList.size() > 0 && aList != null) ? false : true;
    }

    @Override
    public Attendance getAttendanceIfExist(Attendance obj) {
        String hql = "FROM Attendance obj where obj.studentRecordBs.recordBsId=? and obj.attendanceDate=?";
        List<Attendance> aList = new ArrayList();
        aList = (List<Attendance>) hibernateTemplate.find(hql, obj.getStudentRecordBs().getRecordBsId(), new Date());
        MyUtil.print("isAttendanceExist", aList.size() + "");

        return (aList.size() > 0 && aList != null) ? aList.get(0) : null;
    }
    
    String ids = "";

    @Override
    public List<Attendance> getAttendanceForClass(List<Integer> recordBsIdList) {

        recordBsIdList.forEach(i -> {
            ids = ids + " " + i + ",";
            System.out.println("id: " + ids);
        });
        ids.trim();
        ids = ids.substring(0, ids.length() - 1);
        MyUtil.print("recordBsIdList Lengeth:" + recordBsIdList.size(), ids);

        String hql = "FROM Attendance obj where obj.studentRecordBs.recordBsId in(" + ids + ")";
        List<Attendance> aList = (List<Attendance>) hibernateTemplate.find(hql);
        return aList;
    }

}
