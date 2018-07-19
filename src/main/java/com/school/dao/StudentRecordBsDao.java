/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.dao.support.IStudentRecordBsDao;
import com.school.domain.entity.StudentRecordBs;
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
public class StudentRecordBsDao implements IStudentRecordBsDao<StudentRecordBs>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public StudentRecordBs add(StudentRecordBs obj) {
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(StudentRecordBs obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<StudentRecordBs> getAll() {
        String hql = "FROM StudentRecordBs";
        return (List<StudentRecordBs>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentRecordBs getById(int id) {
       // String hql = "FROM StudentRecordBs obj LEFT JOIN FETCH  obj.users.userId where obj.recordBsId=?";
        String hql = "FROM StudentRecordBs obj WHERE obj.users.userId=?";
 
       //StudentRecordBs rbs=hibernateTemplate.get(StudentRecordBs.class, id);
        List<StudentRecordBs> rbsList=(List<StudentRecordBs>)hibernateTemplate.find(hql, id);
        if(rbsList.size()>0){
            return rbsList.get(0);
        }else{
            System.out.println("------Warning-----\n No StudentRecordBs Record for UserId: "+id);
            return null;
        }
       // rbs.getClass();
        
       // return rbs;
        
    }

    
    
}
