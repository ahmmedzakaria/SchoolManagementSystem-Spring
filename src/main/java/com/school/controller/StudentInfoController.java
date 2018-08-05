/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.domain.entity.StudentRecordBs;


import com.school.domain.support.CommonSupport;
import com.school.domain.support.StudentInfo;
import com.school.support.ISupportService;
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
    private ISupportService<StudentInfo> iStudentInfoService;

    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService(@PathVariable("id") Integer id) {
        CommonSupport service = iStudentInfoService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/studentfilter/{sessionId}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentInfo> getAllBySession(@PathVariable("sessionId") Integer sessionId) {
        StudentInfo studentInfo = iStudentInfoService.getAllBySessionInfo(sessionId);
        return new ResponseEntity<StudentInfo>(studentInfo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/studentfilter/{sessionId}/{classId}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentInfo> getAllByClass(@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId) {
        StudentInfo studentInfo = iStudentInfoService.getAllByClassInfo(sessionId,classId);
        return new ResponseEntity<StudentInfo>(studentInfo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/studentfilter/{sessionId}/{classId}/{sectionId}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentInfo> getAllByClassAndSection(@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId, @PathVariable("sectionId") Integer sectionId) {
        System.out.println("getAllByClassAndSection in StudentinfoControlelr");
        StudentInfo studentInfo = iStudentInfoService.getAllByClassAndSectionInfo(sessionId,classId,sectionId);
        return new ResponseEntity<StudentInfo>(studentInfo, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/studentfilter/{sessionId}/{classId}/{sectionId}/{groupId}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentInfo> getAllByClassSectionGroup(@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId) {
        StudentInfo StudentInfo = iStudentInfoService.getAllByClassSectionGroupInfo(sessionId,classId,sectionId,groupId);
        return new ResponseEntity<StudentInfo>(StudentInfo, HttpStatus.OK);
    }
    
//     @RequestMapping(value = "/maxroll/{sessionId}/{classId}/{sectionId}/{groupId}", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<Integer> getMaxRoll(@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId) {
//        int maxRoll = iStudentInfoService.getMaxRoll(sessionId,classId,sectionId,groupId);
//        MyUtil.print("Max Roll", maxRoll+"");
//        return new ResponseEntity<Integer>(maxRoll, HttpStatus.OK);
//    }
    
     @RequestMapping(value = "/maxroll/{sessionId}/{classId}/{sectionId}/{groupId}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentRecordBs> getMaxRoll(@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId) {
        int maxRoll = iStudentInfoService.getMaxRoll(sessionId,classId,sectionId,groupId);
        MyUtil.print("Max Roll", maxRoll+"");
        StudentRecordBs rbs=new StudentRecordBs();
        rbs.setRollNumber(maxRoll);
        return new ResponseEntity<StudentRecordBs>(rbs, HttpStatus.OK);
    }

    @RequestMapping(value = "/studentinfolist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<StudentInfo>> getAllStudentInfo() {
        List<StudentInfo> list = iStudentInfoService.getAll();
        return new ResponseEntity<List<StudentInfo>>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<StudentInfo>> getAllRoleInfo() {
        List<StudentInfo> list = iStudentInfoService.getAllWithoutStudent();
        return new ResponseEntity<List<StudentInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/studentinfolist/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentInfo> getStudentinfo(@PathVariable("id") Integer id) {
        ObjectMapper mapper = new ObjectMapper();
    
        StudentInfo obj = iStudentInfoService.getById(id);
        return new ResponseEntity<StudentInfo>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/studentinfolist", method = RequestMethod.POST)
    public ResponseEntity<Void> addStudentInfo(@RequestBody StudentInfo obj, UriComponentsBuilder builder) {
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
