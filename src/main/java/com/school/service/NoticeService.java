/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.dao.support.INoticeDao;
import com.school.domain.entity.Notice;
import com.school.domain.support.CommonSupport;
import com.school.service.support.INoticeService;
import com.school.support.IGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class NoticeService implements INoticeService<Notice> {

    @Autowired
    private INoticeDao<Notice> iNoticeDao;

    @Autowired
    private CommonSuppotService commonSuppotService;

    @Autowired
    private IGetAll iGetAll;

    @Override
    public boolean add(Notice obj) {
        iNoticeDao.add(obj);
        return true;
    }


    @Override
    public boolean delete(int id) {
        iNoticeDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Notice obj) {
        iNoticeDao.update(obj);
        return true;
    }

    @Override
    public List<Notice> getAll() {

        return iNoticeDao.getAll();
    }

    @Override
    public Notice getById(int id) {
        return iNoticeDao.getById(id);
    }

    @Override
    public CommonSupport getCommonSupportService() {
        return commonSuppotService.getCommonSupportServiceUser();
    }

}
