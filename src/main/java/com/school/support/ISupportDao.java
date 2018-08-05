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
   default List<T> getListById(int id){return null;};
   default T getRecordBsById(int recordBsId){return null;};
   default List<T> getAllByRole(int id){return null;};
   default List<T> getAllBySession(int sessionId){return null;}
   
   default List<T> getAllByClass(int sessionId, int classId){return null;}
   
   default List<T> getAllByClassAndSection(int sessionId,int classId, int sectionId){return null;}
   
   default List<T> getAllByClassSectionGroup(int sessionId,int classId, int sectionId, int groupId){return null;}
   
   default List<Integer> getRecordBsIdList(int sessionId,int classId, int sectionId, int groupId){return null;}
   
   default boolean isAttendanceExist(T t){return true;}
   default T getAttendanceIfExist(T t){return null;}
   
   default List<T> getAttendanceForClass(List<Integer> recordBsIdList){return null;}
   default List<T> getAttendanceForClass(int sessionId,int classId, int sectionId, int groupId){return null;}
   
   default T getAttendanceReportByMonth(int recordBsId, int monthId){return null;}
   
}
