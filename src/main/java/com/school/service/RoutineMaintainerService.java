/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.dao.support.IRoutineMaintainerDao;
import com.school.domain.entity.RoutineMaintainer;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IRoutineMaintainerService;
import com.school.support.IGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class RoutineMaintainerService implements IRoutineMaintainerService<RoutineMaintainer> {

    @Autowired
    private IRoutineMaintainerDao<RoutineMaintainer> iRoutineMaintainerDao;

    @Autowired
    private CommonSuppotService commonSuppotService;

    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(RoutineMaintainer obj) {
        iRoutineMaintainerDao.add(obj);
        return true;
    }


    @Override
    public boolean delete(int id) {
        iRoutineMaintainerDao.delete(id);
        return true;
    }

    @Override
    public boolean update(RoutineMaintainer obj) {
        iRoutineMaintainerDao.update(obj);
        return true;
    }

    @Override
    public List<RoutineMaintainer> getAll() {

        return iRoutineMaintainerDao.getAll();
    }

    @Override
    public RoutineMaintainer getById(int id) {
        return iRoutineMaintainerDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

}
