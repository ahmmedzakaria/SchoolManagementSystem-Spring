/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Religion;
import com.school.domain.entity.Role;
import com.school.domain.entity.StudentRecordBs;


import com.school.domain.support.CommonSupport;
import com.school.domain.support.CommonSupportTest;

import com.school.support.MyUtil;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Faculty
 */
@Controller
@RequestMapping("/test")
public class TestController {

  
//    @RequestMapping(value = "/testlist", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<List<CommonSupportTest>> getAllCommonSupportTest() {
//        List<CommonSupportTest> list = iCommonSupportTestService.getAll();
//        return new ResponseEntity<List<CommonSupportTest>>(list, HttpStatus.OK);
//    }

    
    @RequestMapping(value = "/testlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<CommonSupportTest> getCommonSupportTest(@PathVariable("id") Integer id) {
        CommonSupportTest obj = new CommonSupportTest();
        obj.setClassId(1);
        obj.setClassName("Class One");
        return new ResponseEntity<CommonSupportTest>(obj, HttpStatus.OK);
    }

//    @RequestMapping(value = "/testlist", method = RequestMethod.POST)
//    public ResponseEntity<Void> addCommonSupportTest(@RequestBody CommonSupportTest obj, UriComponentsBuilder builder) {
//        StudentRecordBs rbs=obj.getStudentRecordBsList().get(0);
//        MyUtil.print("Roll", ""+rbs.getRollNumber());
//        
//        boolean flag = iCommonSupportTestService.add(obj);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/user/{id}").buildAndExpand(obj.getUsers().getUserId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/testlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonSupportTest> updateStudent(@RequestBody CommonSupportTest obj) {
        System.out.println("updateCommonSupportTest Called...........");
        MyUtil.print("id", ""+obj.getClass());
        MyUtil.print("getClassName", ""+obj.getClassName());

        return new ResponseEntity<CommonSupportTest>(obj, HttpStatus.OK);
    }

//    @RequestMapping(value = "/testlist/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
//        iCommonSupportTestService.delete(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

}
