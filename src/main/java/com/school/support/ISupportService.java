/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import com.school.domain.support.CommonSupport;
import com.school.service.CommonSuppotService;


/**
 *
 * @author User
 */
public interface ISupportService<T> extends ISupport<T>{
    boolean add(T t);
   CommonSupport getCommonSupportService();
}
