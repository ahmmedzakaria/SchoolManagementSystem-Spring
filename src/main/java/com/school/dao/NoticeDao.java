/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.entity.Notice;
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
public class NoticeDao implements ISupportDao<Notice>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Notice add(Notice obj) {
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Notice obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<Notice> getAll() {
        String hql = "FROM Notice";
        return (List<Notice>) hibernateTemplate.find(hql);
    }

    @Override
    public Notice getById(int id) {
        return hibernateTemplate.get(Notice.class, id);
    }

    
    
}
