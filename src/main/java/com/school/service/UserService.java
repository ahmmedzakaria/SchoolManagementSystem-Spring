/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.dao.support.IUserDao;
import com.school.domain.entity.Role;
import com.school.domain.entity.Users;
import com.school.domain.support.CommonSupport;
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
public class UserService implements IUserService<Users>{
    
    @Autowired
    private IUserDao<Users> iUserDao;
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(Users obj) {
        obj.setRegisterDate(new Date());
        iUserDao.add(obj);
        return true;
    }

    @Override
    public boolean delete(int id) {
        iUserDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Users obj) {
        System.out.println("User: \n"+obj.toString());;
        iUserDao.update(obj);
        return true;
    }

    @Override
    public List<Users> getAll() {
        System.out.println("GetAll Users............");
        List<Role> allClasses = iGetAll.get("Role");
        allClasses.forEach(System.out::println);    
        return iUserDao.getAll();
    }

    @Override
    public Users getById(int id) {   
        return iUserDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }
    
}
