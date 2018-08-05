/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.entity.Grade;
import com.school.domain.entity.Marks;
import com.school.support.ISupportDao;
import com.school.support.MarksManager;
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
public class MarksDao implements ISupportDao<Marks>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Marks add(Marks obj) {
        Grade grade=new Grade();
        grade.setGradeId(MarksManager.getGradeid(obj));
        obj.setGrade(grade);
         hibernateTemplate.saveOrUpdate(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Marks obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<Marks> getAll() {
        String hql = "FROM Marks";
        return (List<Marks>) hibernateTemplate.find(hql);
    }

    @Override
    public Marks getById(int id) {
        return hibernateTemplate.get(Marks.class, id);
    }

    
    
}
