/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import java.util.List;


/**
 *
 * @author User
 */
public interface ISupportDao<T> extends ISupport<T>{
   T add(T t);
   default List<T> getAllByRole(int id){return null;};
   
}
