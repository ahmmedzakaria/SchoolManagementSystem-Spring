/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import com.school.domain.support.CommonSupport;
import com.school.service.CommonSuppotService;
import java.util.List;


/**
 *
 * @author User
 */
public interface ISupportService<T> extends ISupport<T>{
    boolean add(T t);
   CommonSupport getCommonSupportService();
   default T getListById(int id){return null;};
   default T getAllAttendance(){return null;}
   default T getAllBySessionInfo(int sessionId){return null;}
   
   default T getAllByClassInfo(int sessionId, int classId){return null;}
   
   default T getAllByClassAndSectionInfo(int sessionId,int classId, int sectionId){return null;}
   
   default T getAttendanceForClass(int sessionId,int classId, int sectionId, int groupId){return null;}
   
   default T getAllByClassSectionGroupInfo(int sessionId,int classId, int sectionId, int groupId){return null;}
}
