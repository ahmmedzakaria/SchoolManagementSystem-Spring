/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.dao.support.IAttendanceDao;
import com.school.domain.entity.Attendance;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IAttendanceService;
import com.school.support.IGetAll;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class AttendanceService implements IAttendanceService<Attendance>{
    
    @Autowired
    private IAttendanceDao<Attendance> iAttendanceDao;
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(Attendance obj) {
        obj.setAttendanceDate(new Date());
        iAttendanceDao.add(obj);
        return true;
    }

    @Override
    public int addAll(List<Attendance> list) {
        return 0;
    }
    
    @Override
    public boolean delete(int id) {
        iAttendanceDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Attendance obj) {
    
        iAttendanceDao.update(obj);
        return true;
    }

    @Override
    public List<Attendance> getAll() {
          
        return iAttendanceDao.getAll();
    }

    @Override
    public Attendance getById(int id) {   
        return iAttendanceDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

    
}
