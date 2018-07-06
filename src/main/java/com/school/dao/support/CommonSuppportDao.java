/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao.support;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.school.support.IGetAll;

@Repository
@Transactional
public class CommonSuppportDao implements IGetAll{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    public static final String CLASSES="Classes";
    public static final String EXAMS="Exams";
    public static final String GRADE="Grade";
    public static final String GENDER="Gender";
    public static final String MARK_PATTERN="MarksPattern";
    public static final String RELIGION="Religion";
    public static final String ROLE="Role";
    public static final String SECTION="Section";
    public static final String SUBJECT="Subject";
    public static final String STUDENT_PAYMENT_TYPE="StudentPaymentType";
    public static final String STUDENT_SESSION="StudentSession";
    
    
    List<?> get(Class<?> c){
        
    return null;
    }
    
    
    
//    void test(){
//        List<Grade> g=(List<Grade>) get(Grade.class);
//    }

    @Override
    public List<?> get(String className) {
        String hql = "FROM "+className;
        return (List<Object>) hibernateTemplate.find(hql);
    }
}
