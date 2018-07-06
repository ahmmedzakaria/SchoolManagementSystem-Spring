/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.Guardian;
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
public class GuardianDao implements ISupportDao<Guardian>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;



    @Override
    public boolean add(Guardian guardian) {
         hibernateTemplate.save(guardian);
         return true;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Guardian guardian) {
        hibernateTemplate.update(guardian);
        return true;
    }

    @Override
    public List<Guardian> getAll() {
        String hql = "FROM Guardian";
        return (List<Guardian>) hibernateTemplate.find(hql);
    }

    @Override
    public Guardian getById(int id) {
        return hibernateTemplate.get(Guardian.class, id);
    }

    
    
}
