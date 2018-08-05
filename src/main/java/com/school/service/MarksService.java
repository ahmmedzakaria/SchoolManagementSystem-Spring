/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.domain.entity.Marks;

import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.support.IGetAll;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;
import com.school.support.MyUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class MarksService implements ISupportService<StudentInfo>{
    
    @Qualifier(value = "marksDao")
    @Autowired
    private ISupportDao<Marks> iMarksDao;
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(StudentInfo obj) {
        List<Marks> markList=obj.getMarkList();
        MyUtil.print("markList Size", markList.size()+"");
        markList.forEach(a->{
            iMarksDao.add(a);
        });
        return true;
    }

    @Override
    public int addAll(List<StudentInfo> list) {
        return 0;
    }
    
    @Override
    public boolean delete(int id) {
        iMarksDao.delete(id);
        return true;
    }

    @Override
    public boolean update(StudentInfo obj) {
       
       // iMarksDao.update(obj);
        return true;
    }

    @Override
    public List<StudentInfo> getAll() {
           
        //return iMarksDao.getAll();
        return null;
    }

    @Override
    public StudentInfo getById(int id) {   
        //return iMarksDao.getById(id);
        return null;
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

    
}
