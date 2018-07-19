/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.TeacherClasses;
import com.school.domain.support.CommonSupport;
import com.school.service.support.ITeacherClassesService;
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
@RequestMapping("/teacherclassesinfo")
public class TeacherClassesController {

    @Autowired
    private ITeacherClassesService<TeacherClasses> iTeacherClassesService;
   

    @RequestMapping("/home")
    public String home() {
        return "teacherclasses";
    }


    @RequestMapping(value = "/teacherclasseslist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<TeacherClasses>> getAllTeacherClasses() {
        List<TeacherClasses> list = iTeacherClassesService.getAll();
        return new ResponseEntity<List<TeacherClasses>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iTeacherClassesService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/teacherclasses/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeacherClasses> getUser(@PathVariable("id") Integer id) {
        TeacherClasses obj = iTeacherClassesService.getById(id);
        return new ResponseEntity<TeacherClasses>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/teacherclasses", method = RequestMethod.POST)
    public ResponseEntity<Void> addTeacherClasses(@RequestBody TeacherClasses obj, UriComponentsBuilder builder) {
        boolean flag = iTeacherClassesService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/teacherclasses/{id}").buildAndExpand(obj.getTeacherClassesId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/teacherclasses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TeacherClasses> updateUser(@RequestBody TeacherClasses obj) {
        iTeacherClassesService.update(obj);
        return new ResponseEntity<TeacherClasses>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/teacherclasses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iTeacherClassesService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
