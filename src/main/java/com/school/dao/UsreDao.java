/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.dao.support.IUserDao;
import com.school.domain.entity.Gender;
import com.school.domain.entity.Religion;
import com.school.domain.entity.Role;
import com.school.domain.entity.Users;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
@DynamicUpdate
public class UsreDao implements IUserDao<Users>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Users add(Users obj) {
        obj.setDob(new Date());
        obj.setRegisterDate(new Date());
//        Gender gender=new Gender();
//        gender.setGenderId(1);
//        Role role=new Role();
//        role.setRoleId(4);
//        obj.setGender(gender);
//        obj.setRole(role);
        Religion religion=new Religion();
        religion.setReligionId(1);
        obj.setReligion(religion);
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Users obj) {
        //getById(obj.getUserId());
//        obj.setDob(new Date());
//        obj.setRegisterDate(new Date());
        
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<Users> getAll() {
        String hql = "FROM Users";
        return (List<Users>) hibernateTemplate.find(hql);
    }
    
    @Override
    public List<Users> getAllByRole(int id) {
        String hql = "FROM Users ob WHERE ob.role.roleId=?";
        return (List<Users>) hibernateTemplate.find(hql,id);
    }
    
    

    @Override
    public Users getById(int id) {
        Users user=hibernateTemplate.get(Users.class, id);
        user.getStudentRecordBses();
        return user;
    }

    
    
}
