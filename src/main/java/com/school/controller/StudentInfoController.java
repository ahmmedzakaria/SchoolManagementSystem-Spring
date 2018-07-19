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
import com.school.domain.support.StudentInfo;
import com.school.service.support.IStudentInfoService;
import com.school.support.MyUtil;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/studentinfo")
public class StudentInfoController {

    @Qualifier(value = "studentInfoService")
    @Autowired
    private IStudentInfoService<StudentInfo> iStudentInfoService;
    
//    @Qualifier(value = "studentRecordBsService")
//     @Autowired
//    private IStudentRecordBsService<StudentRecordBs> iStudentRecordBsService;
   

//    @RequestMapping("/office/home")
//    public String officeHome() {
//        return "office/student_info";
//    }
//    
//    @RequestMapping("/admin/home")
//    public String adminHome() {
//        return "admin/index";
//    }
//    
//    @RequestMapping("/admin/adduser")
//    public String addUser() {
//        return "admin/adduser";
//    }
//    
//    @RequestMapping("/admin/viewuser")
//    public String viewUser() {
//        return "admin/viewuser";
//    }


    @RequestMapping(value = "/studentinfolist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<StudentInfo>> getAllStudentInfo() {
        List<StudentInfo> list = iStudentInfoService.getAll();
        return new ResponseEntity<List<StudentInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService(@PathVariable("id") Integer id) {
        CommonSupport service = iStudentInfoService.getCommonSupportService();
        
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/studentinfolist/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentInfo> getStudentinfo(@PathVariable("id") Integer id) {
        StudentInfo obj = iStudentInfoService.getById(id);
        return new ResponseEntity<StudentInfo>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/studentinfolist", method = RequestMethod.POST)
    public ResponseEntity<Void> addStudentInfo(@RequestBody StudentInfo obj, UriComponentsBuilder builder) {
        StudentRecordBs rbs=obj.getStudentRecordBsList().get(0);
        MyUtil.print("Roll", ""+rbs.getRollNumber());
        
        boolean flag = iStudentInfoService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(obj.getUsers().getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/studentinfolist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StudentInfo> updateStudent(@RequestBody StudentInfo obj) {
        System.out.println("updateStudentInfo Called...........");
        iStudentInfoService.update(obj);
        return new ResponseEntity<StudentInfo>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/studentinfolist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
        iStudentInfoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
