/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Religion;
import com.school.domain.entity.Role;
import com.school.domain.entity.Users;

import com.school.domain.support.CommonSupport;

import com.school.service.support.IUserService;
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
@RequestMapping("/student")
public class StudentController {

//    @Qualifier(value = "studentService")
//    @Autowired
//    private IUserService<Users> iUserService;
//    
////    @Qualifier(value = "studentRecordBsService")
////     @Autowired
////    private IStudentRecordBsService<StudentRecordBs> iStudentRecordBsService;
//   
//
//    @RequestMapping("/home")
//    public String home() {
//        return "office/student";
//    }
//
//
//    @RequestMapping(value = "/studentlist", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<List<Users>> getAllUsers() {
//        List<Users> list = iUserService.getAll();
//        return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/service", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<CommonSupport> getCommonSupportService() {
//        CommonSupport service = iUserService.getCommonSupportService();
//        List<Role> roleList=service.getRoleList();
//        roleList.forEach(System.out::println);
//        List<Religion> religionList=service.getReligionList();
//        religionList.forEach(System.out::println);
//        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/studentlist/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Users> getStudent(@PathVariable("id") Integer id) {
//        Users obj = iUserService.getById(id);
//        return new ResponseEntity<Users>(obj, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/studentlist", method = RequestMethod.POST)
//    public ResponseEntity<Void> addUsers(@RequestBody Users obj, UriComponentsBuilder builder) {
//        boolean flag = iUserService.add(obj);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/studentlist/{id}").buildAndExpand(obj.getUserId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/studentlist/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Users> updateStudent(@RequestBody Users obj) {
//        iUserService.update(obj);
//        return new ResponseEntity<Users>(obj, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/studentlist/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
//        iUserService.delete(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

}
