/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;


import com.school.dao.support.IPaymentDao;
import com.school.domain.entity.Payment;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IPaymentService;
import com.school.support.IGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class PaymentService implements IPaymentService<Payment>{
    
    @Autowired
    private IPaymentDao<Payment> iPaymentDao;
    
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
