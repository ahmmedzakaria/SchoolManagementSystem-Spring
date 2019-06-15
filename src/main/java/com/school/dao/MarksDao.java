/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.entity.Grade;
import com.school.domain.entity.Marks;
import com.school.support.ISupportDao;
import com.school.support.MarksManager;
import com.school.support.MyUtil;
import java.util.ArrayList;
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
public class MarksDao implements ISupportDao<Marks>{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Marks add(Marks obj) {
         Marks marks = getByObject(obj);
         Grade grade=new Grade();
        if (marks == null) {     
        grade.setGradeId(MarksManager.getGradeid(obj));
        obj.setGrade(grade);
            marks = obj;
        } else {
            marks.setSubjects(obj.getSubjects());
            marks.setWrittenMarks(obj.getWrittenMarks());
            marks.setMcqMarks(obj.getMcqMarks());
            marks.setPracticalMarks(obj.getPracticalMarks());
            grade.setGradeId(MarksManager.getGradeid(obj));
            marks.setGrade(grade);
        }
        
         hibernateTemplate.saveOrUpdate(marks);
         return marks;
    }

    @Override
    public boolean delete(int id) {
        hibernateTemplate.delete(getById(id));
        return true;
    }

    @Override
    public boolean update(Marks obj) {
        hibernateTemplate.update(obj);
        return true;
    }

    @Override
    public List<Marks> getAll() {
        String hql = "FROM Marks";
        return (List<Marks>) hibernateTemplate.find(hql);
    }

    @Override
    public Marks getById(int id) {
        return hibernateTemplate.get(Marks.class, id);
    }

     @Override
    public boolean isExist(Marks obj) {
        String hql = "FROM Marks obj where obj.studentRecordBs.recordBsId=? and obj.exams.examId=?";
        List<Marks> aList = new ArrayList();
        aList = (List<Marks>) hibernateTemplate.find(hql, obj.getStudentRecordBs().getRecordBsId(),obj.getExams().getExamId());
        MyUtil.print("isAttendanceExist", aList.size() + "");

        return (aList.size() > 0 && aList != null) ? false : true;
    } 
    
    @Override
    public Marks getByObject(Marks obj) {
        String hql = "FROM Marks obj where obj.studentRecordBs.recordBsId=? and obj.exams.examId=? and subjects.subjectId=?";
        List<Marks> aList = new ArrayList();
        aList = (List<Marks>) hibernateTemplate.find(hql, obj.getStudentRecordBs().getRecordBsId(),obj.getExams().getExamId(),obj.getSubjects().getSubjectId());
        MyUtil.print("isMarksExist", aList.size() + "");

        return (aList.size() > 0 && aList != null) ? aList.get(0) : null;
    } 
    
}
