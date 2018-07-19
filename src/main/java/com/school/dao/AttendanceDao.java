/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.dao.support.IAttendanceDao;
import com.school.domain.entity.Attendance;
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
public class AttendanceDao implements IAttendanceDao<Attendance>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Attendance add(Attendance obj) {
         hibernateTemplate.save(obj);
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
        String hql = "FROM Attendance";
        return (List<Attendance>) hibernateTemplate.find(hql);
    }

    @Override
    public Attendance getById(int id) {
        return hibernateTemplate.get(Attendance.class, id);
    }

    
    
}
