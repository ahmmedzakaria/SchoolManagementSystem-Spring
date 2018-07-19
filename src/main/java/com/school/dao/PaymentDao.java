/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.dao.support.IPaymentDao;
import com.school.domain.entity.Payment;
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
public class PaymentDao implements IPaymentDao<Payment>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Payment add(Payment obj) {
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Payment obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<Payment> getAll() {
        String hql = "FROM Payment";
        return (List<Payment>) hibernateTemplate.find(hql);
    }

    @Override
    public Payment getById(int id) {
        return hibernateTemplate.get(Payment.class, id);
    }

    
    
}
