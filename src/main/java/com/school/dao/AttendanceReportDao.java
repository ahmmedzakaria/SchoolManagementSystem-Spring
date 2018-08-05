/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.entity.AttendanceReport;
import com.school.support.ISupportDao;
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
public class AttendanceReportDao implements ISupportDao<AttendanceReport>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public AttendanceReport add(AttendanceReport obj) {
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(AttendanceReport obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<AttendanceReport> getAll() {
        String hql = "FROM AttendanceReport";
        return (List<AttendanceReport>) hibernateTemplate.find(hql);
    }

    @Override
    public AttendanceReport getById(int id) {
        return hibernateTemplate.get(AttendanceReport.class, id);
    }
    
    public AttendanceReport getAttendanceReportByMonth(int recordBsId, int monthId){
        String hql = "FROM AttendanceReport obj where obj.studentRecordBs.recordBsId=? and obj.months.monthId=?";
        List<AttendanceReport> aList=(List<AttendanceReport>) hibernateTemplate.find(hql,recordBsId,monthId);
        
        return (aList!=null && aList.size()>0)?aList.get(0):null;
    }

    
    
}
