/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.school.support.IGetAll;

@Repository
@Transactional
public class CommonSuppportDao implements IGetAll{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
  
    
    List<?> get(Class<?> c){
        
    return null;
    }
//    void test(){
//        List<Grade> g=(List<Grade>) get(Grade.class);
//    }

    @Override
    public List<?> get(String className) {
        String hql = "FROM "+className;
        return (List<Object>) hibernateTemplate.find(hql);
    }
}
