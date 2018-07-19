/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.dao.support.ITeacherClassesDao;
import com.school.domain.entity.TeacherClasses;
import com.school.domain.support.CommonSupport;
import com.school.service.support.ITeacherClassesService;
import com.school.support.IGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class TeacherClassesService implements ITeacherClassesService<TeacherClasses> {

    @Autowired
    private ITeacherClassesDao<TeacherClasses> iTeacherClassesDao;

    @Autowired
    private CommonSuppotService commonSuppotService;

    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(TeacherClasses obj) {
        iTeacherClassesDao.add(obj);
        return true;
    }


    @Override
    public boolean delete(int id) {
        iTeacherClassesDao.delete(id);
        return true;
    }

    @Override
    public boolean update(TeacherClasses obj) {
        iTeacherClassesDao.update(obj);
        return true;
    }

    @Override
    public List<TeacherClasses> getAll() {

        return iTeacherClassesDao.getAll();
    }

    @Override
    public TeacherClasses getById(int id) {
        return iTeacherClassesDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

}
