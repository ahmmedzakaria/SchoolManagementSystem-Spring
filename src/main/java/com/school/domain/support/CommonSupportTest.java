/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.domain.support;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User2
 */
public class CommonSupportTest implements java.io.Serializable {

    private Integer classId = 1;
    private String className = "zakaria";
    private List<String> nameList = new ArrayList();

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
    
}
