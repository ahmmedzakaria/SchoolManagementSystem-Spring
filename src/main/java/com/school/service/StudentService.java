/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.dao.support.IStudentRecordBsDao;
import com.school.dao.support.IUserDao;
import com.school.domain.entity.Role;
import com.school.domain.entity.StudentRecordBs;
import com.school.domain.entity.Users;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IUserService;
import com.school.support.IGetAll;
import com.school.support.Num;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class StudentService implements IUserService<Users>{
    
    @Autowired
    private IUserDao<Users> iUserDao;
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
    @Autowired
    private IGetAll iGetAll;
    
     @Autowired
    private IStudentRecordBsDao<StudentRecordBs> iStudentRecordBsDao;

    @Override
    public boolean add(Users obj) {
        obj.getStudentRecordBses();
        obj.setRegisterDate(new Date());
        Users objReturned=iUserDao.add(obj);
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
        System.out.println("GetAll Student Users............");
//        List<Role> allClasses = iGetAll.get("Role");
//        allClasses.forEach(System.out::println);    
return iUserDao.getAllByRole(4);
       // return iUserDao.getAll();
    }

    @Override
    public Users getById(int id) {   
        
        Users user=new Users();
        StudentRecordBs studentRecordBs=iStudentRecordBsDao.getById(id);
        //studentRecordBs.getClass();
        user.getStudentRecordBses().add(studentRecordBs);
        System.out.println("student:"+iStudentRecordBsDao.getById(id));
        return user;
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }
    
}
