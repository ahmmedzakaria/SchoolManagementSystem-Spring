/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.domain.Guardian;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;

/**
 *
 * @author Faculty
 */
@Service
public class GuardianService implements ISupportService<Guardian>{
    
    @Autowired
    private ISupportDao<Guardian> iSupportDao;
    
    


    @Override
    public boolean add(Guardian gurdian) {
        iSupportDao.add(gurdian);
        return true;
    }

    @Override
    public boolean delete(int id) {
        iSupportDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Guardian gurdian) {
        iSupportDao.update(gurdian);
        return true;
    }

    @Override
    public List<Guardian> getAll() {
        
        return iSupportDao.getAll();
    }

    @Override
    public Guardian getById(int id) {
        return iSupportDao.getById(id);
        
    }
    
}
