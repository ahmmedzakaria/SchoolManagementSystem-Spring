/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.school.domain.entity.Attendance;
import com.school.domain.support.StudentInfo;
import com.school.support.ISupportService;
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
@RequestMapping("/attendanceinfo")
public class AttendanceController {

    @Qualifier(value = "attendanceService")
    @Autowired
    private ISupportService<StudentInfo> iSupportService;
   

    @RequestMapping("/home")
    public String home() {
        return "attendance";
    }


    @RequestMapping(value = "/attendancelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentInfo> getAllAttendance() {
        StudentInfo list = iSupportService.getAllAttendance();
        return new ResponseEntity<StudentInfo>(list, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/attendance/{sessionId}/{classId}/{sectionId}/{groupId}", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<StudentInfo> getAttendanceForClass(@PathVariable("sessionId") Integer sessionId,@PathVariable("classId") Integer classId,@PathVariable("sectionId") Integer sectionId,@PathVariable("groupId") Integer groupId) {
        StudentInfo studentInfo = iSupportService.getAttendanceForClass(sessionId,classId,sectionId,groupId);
       // MyUtil.print("Max Roll", maxRoll+"");
        
        return new ResponseEntity<StudentInfo>(studentInfo, HttpStatus.OK);
    }
    
//     @RequestMapping(value = "/filterstudent", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<List<StudentInfo>> getAllStudentForSession() {
//        List<StudentInfo> list = iSupportService.getAllBySession(1);
//        return new ResponseEntity<List<StudentInfo>>(list, HttpStatus.OK);
//    }

//    @RequestMapping(value = "/service", method = RequestMethod.GET)
//    @JsonIgnore
//    public ResponseEntity<CommonSupport> getCommonSupportService() {
//        CommonSupport service = iSupportService.getCommonSupportService();
//        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
//    }
    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentInfo> getUser(@PathVariable("id") Integer id) {
        StudentInfo obj=iSupportService.getListById(id);
        
        //StudentInfo obj = iSupportService.getById(id);
        return new ResponseEntity<StudentInfo>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/attendance", method = RequestMethod.POST)
    public ResponseEntity<Void> addAttendance(@RequestBody StudentInfo obj, UriComponentsBuilder builder) {
        boolean flag = iSupportService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        Attendance attendance=obj.getAttendancesList().get(0);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/attendance/{id}").buildAndExpand(attendance.getAttendanceId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//    @RequestMapping(value = "/attendance", method = RequestMethod.POST)
//    public ResponseEntity<Void> addAttendance(@RequestBody List<Attendance> list, UriComponentsBuilder builder) {
//        System.out.println("called.....................");
//        StudentInfo obj=new StudentInfo();
//        obj.setAttendancesList(list);
//        boolean flag = iSupportService.add(obj);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        Attendance attendance=obj.getAttendancesList().get(0);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/attendance/{id}").buildAndExpand(attendance.getAttendanceId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

//    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<StudentInfo> updateUser(@RequestBody StudentInfo obj) {
//        iSupportService.update(obj);
//        return new ResponseEntity<StudentInfo>(obj, HttpStatus.OK);
//    }

    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iSupportService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
