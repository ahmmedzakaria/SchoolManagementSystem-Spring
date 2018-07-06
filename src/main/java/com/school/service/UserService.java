/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.dao.support.CommonSuppportDao;
import com.school.domain.Role;
import com.school.domain.Users;
import com.school.support.IGetAll;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class UserService implements ISupportService<Users>{
    
    @Autowired
    private ISupportDao<Users> iSupportDao;
    

    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(Users user) {
        iSupportDao.add(user);
        return true;
    }

    @Override
    public boolean delete(int id) {
        iSupportDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Users user) {
        iSupportDao.update(user);
        return true;
    }

    @Override
    public List<Users> getAll() {
        System.out.println("GetAll Users............");
        List<Role> allClasses = iGetAll.get("Role");
        allClasses.forEach(System.out::println);
        
        return iSupportDao.getAll();
    }

    @Override
    public Users getById(int id) {   
        return iSupportDao.getById(id);
    }
    
}
