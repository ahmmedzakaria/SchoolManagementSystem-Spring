package com.school.dao;



import com.school.domain.entity.StudentRecordBs;
import com.school.support.ISupportDao;
import java.util.Date;
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
public class StudentRecordBsDao implements ISupportDao<StudentRecordBs>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public StudentRecordBs add(StudentRecordBs obj) {
        obj.setRecordDate(new Date());
         hibernateTemplate.save(obj);
         return obj;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(StudentRecordBs obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<StudentRecordBs> getAll() {
        String hql = "FROM StudentRecordBs";
        return (List<StudentRecordBs>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentRecordBs getById(int id) {
       // String hql = "FROM StudentRecordBs obj LEFStudentRecortBs JOIN FEStudentRecortBsCH  obj.users.userId where obj.recordBsId=?";
        String hql = "FROM StudentRecordBs obj WHERE obj.users.userId=?";
        List<StudentRecordBs> rbsList=(List<StudentRecordBs>)hibernateTemplate.find(hql, id);
        if(rbsList.size()>0){
            return rbsList.get(0);
        }else{
            System.out.println("------Warning-----\n No StudentRecordBs Record for UserId: "+id);
            return null;
        }  
    }
    
   @Override
    public StudentRecordBs getRecordBsById(int recordBsId){
        
        return (StudentRecordBs)hibernateTemplate.get(StudentRecordBs.class, recordBsId);
    }
    
@Override
    public List<StudentRecordBs> getAllBySession(int sessionId){
        String hql = "FROM StudentRecordBs obj WHERE obj.studentSession.sessionId=?";
        return (List<StudentRecordBs>) hibernateTemplate.find(hql,sessionId);
    }
    
    @Override
    public List<StudentRecordBs> getAllByClass(int sessionId, int classId){
        String hql = "FROM StudentRecordBs obj WHERE obj.studentSession.sessionId=? AND obj.classes.classId =?";
        return (List<StudentRecordBs>) hibernateTemplate.find(hql,sessionId,classId);
    }
   
    @Override
   public List<StudentRecordBs> getAllByClassAndSection(int sessionId,int classId, int sectionId){
        String hql = "FROM StudentRecordBs obj WHERE obj.studentSession.sessionId=? AND obj.classes.classId =? AND obj.section.sectionId=?";
        return (List<StudentRecordBs>) hibernateTemplate.find(hql,sessionId,classId,sectionId);
    }
   
    @Override
   public List<StudentRecordBs> getAllByClassSectionGroup(int sessionId,int classId, int sectionId, int groupId){
        String hql = "FROM StudentRecordBs obj WHERE obj.studentSession.sessionId=? AND obj.classes.classId =? AND obj.section.sectionId=? AND obj.groups.groupId=?";
        return (List<StudentRecordBs>) hibernateTemplate.find(hql,sessionId,classId,sectionId,groupId);
    }
   
    @Override
   public int getMaxRoll(int sessionId,int classId, int sectionId, int groupId){ 
       String hql = "SELECT MAX(obj.rollNumber)FROM StudentRecordBs obj WHERE obj.studentSession.sessionId=? AND obj.classes.classId =? AND obj.section.sectionId=? AND obj.groups.groupId=?";
         List<Integer> countList=(List<Integer>) hibernateTemplate.find(hql,sessionId,classId,sectionId,groupId);
         int count=1;
         try {
            if(countList!=null && countList.size()>0){
         count=countList.get(0)+1;
         }
        } catch (Exception e) {
           
        }
      // return (countList!=null || countList.size()>0) ? countList.get(0) : 0 ;
      return count;
   }
   
    @Override
   public List<Integer> getRecordBsIdList(int sessionId,int classId, int sectionId, int groupId){
        String hql = "SELECT obj.recordBsId FROM StudentRecordBs obj WHERE obj.studentSession.sessionId=? AND obj.classes.classId =? AND obj.section.sectionId=? AND obj.groups.groupId=?";
        return (List<Integer>) hibernateTemplate.find(hql,sessionId,classId,sectionId,groupId);
    }
       
}
