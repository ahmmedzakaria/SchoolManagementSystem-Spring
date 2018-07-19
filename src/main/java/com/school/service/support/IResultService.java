/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service.support;

import com.school.support.*;
import com.school.domain.support.CommonSupport;


/**
 *
 * @author User
 */
public interface IResultService<T> extends ISupportService<T>{
    default CommonSupport getCommonSupportService(){
        return null;
    };
}
