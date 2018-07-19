/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.dao.support.ISubScholarshipDao;
import com.school.domain.entity.SubScholarship;
import com.school.domain.support.CommonSupport;
import com.school.service.support.ISubScholarshipService;
import com.school.support.IGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class SubScholarshipService implements ISubScholarshipService<SubScholarship> {

    @Autowired
    private ISubScholarshipDao<SubScholarship> iSubScholarshipDao;

    @Autowired
    private CommonSuppotService commonSuppotService;

    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(SubScholarship obj) {
        iSubScholarshipDao.add(obj);
        return true;
    }


    @Override
    public boolean delete(int id) {
        iSubScholarshipDao.delete(id);
        return true;
    }

    @Override
    public boolean update(SubScholarship obj) {
        iSubScholarshipDao.update(obj);
        return true;
    }

    @Override
    public List<SubScholarship> getAll() {

        return iSubScholarshipDao.getAll();
    }

    @Override
    public SubScholarship getById(int id) {
        return iSubScholarshipDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

}
