/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.domain.entity.Payment;
import com.school.domain.support.CommonSupport;

import com.school.support.IGetAll;
import com.school.support.ISupportDao;
import com.school.support.ISupportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class PaymentService implements ISupportService<Payment>{
    
    @Qualifier(value = "paymentDao")
    @Autowired
    private ISupportDao<Payment> iPaymentDao;
    
    @Autowired
    private CommonSuppotService commonSuppotService;
    
    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(Payment obj) {
        iPaymentDao.add(obj);
        return true;
    }

    
    @Override
    public boolean delete(int id) {
        iPaymentDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Payment obj) {
        iPaymentDao.update(obj);
        return true;
    }

    @Override
    public List<Payment> getAll() {
           
        return iPaymentDao.getAll();
    }

    @Override
    public Payment getById(int id) {   
        return iPaymentDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

    
}
