/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.dao.support.IMarksDao;
import com.school.domain.entity.Role;
import com.school.domain.entity.Marks;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IMarksService;
import com.school.service.support.IUserService;
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
public class MarksService implements IMarksService<Marks>{
    
    @Autowired
    private IMarksDao<Marks> iMarksDao;
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(Marks obj) {
        iMarksDao.add(obj);
        return true;
    }

    @Override
    public int addAll(List<Marks> list) {
        return 0;
    }
    
    @Override
    public boolean delete(int id) {
        iMarksDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Marks obj) {
       
        iMarksDao.update(obj);
        return true;
    }

    @Override
    public List<Marks> getAll() {
           
        return iMarksDao.getAll();
    }

    @Override
    public Marks getById(int id) {   
        return iMarksDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

    
}
