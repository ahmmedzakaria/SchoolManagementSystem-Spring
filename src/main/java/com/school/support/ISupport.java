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
public interface ISupport<T> {
    
    boolean delete(int id);
    boolean update(T t);
    List<T> getAll();
    T getById(int id);
    default int addAll(List<T> list){
        return 0;
    }
    default List<T> getAllWithoutStudent(){return null;}
    

   default int getMaxRoll(int sessionId,int classId, int sectionId, int groupId){return 0;}
   
 
}
