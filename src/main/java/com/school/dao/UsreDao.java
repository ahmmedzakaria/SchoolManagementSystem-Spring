/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.Users;
import com.school.support.ISupportDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Faculty
 */
@Transactional
@Repository
public class UsreDao implements ISupportDao<Users>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean add(Users user) {
         hibernateTemplate.save(user);
         return true;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Users user) {
        hibernateTemplate.update(user);
        return true;
    }

    @Override
    public List<Users> getAll() {
        String hql = "FROM Users";
        return (List<Users>) hibernateTemplate.find(hql);
    }

    @Override
    public Users getById(int id) {
        return hibernateTemplate.get(Users.class, id);
    }

    
    
}
