/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.dao.support.IRoutineMaintainerDao;
import com.school.domain.entity.RoutineMaintainer;

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
public class RoutineMaintainerDao implements IRoutineMaintainerDao<RoutineMaintainer>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public RoutineMaintainer add(RoutineMaintainer obj) {
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(RoutineMaintainer obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<RoutineMaintainer> getAll() {
        String hql = "FROM RoutineMaintainer";
        return (List<RoutineMaintainer>) hibernateTemplate.find(hql);
    }

    @Override
    public RoutineMaintainer getById(int id) {
        return hibernateTemplate.get(RoutineMaintainer.class, id);
    }

    
    
}
