/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Attendance;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IAttendanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IAttendanceService<Attendance> iAttendanceService;
   

    @RequestMapping("/home")
    public String home() {
        return "attendance";
    }


    @RequestMapping(value = "/attendancelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> list = iAttendanceService.getAll();
        return new ResponseEntity<List<Attendance>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iAttendanceService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.GET)
    public ResponseEntity<Attendance> getUser(@PathVariable("id") Integer id) {
        Attendance obj = iAttendanceService.getById(id);
        return new ResponseEntity<Attendance>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/attendance", method = RequestMethod.POST)
    public ResponseEntity<Void> addAttendance(@RequestBody Attendance obj, UriComponentsBuilder builder) {
        boolean flag = iAttendanceService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/attendance/{id}").buildAndExpand(obj.getAttendanceId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Attendance> updateUser(@RequestBody Attendance obj) {
        iAttendanceService.update(obj);
        return new ResponseEntity<Attendance>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iAttendanceService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
