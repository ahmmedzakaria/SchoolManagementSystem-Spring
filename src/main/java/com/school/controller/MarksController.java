/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Marks;
import com.school.domain.support.CommonSupport;
import com.school.service.support.IMarksService;
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
@RequestMapping("/marksinfo")
public class MarksController {

    @Autowired
    private IMarksService<Marks> iMarksService;
   

    @RequestMapping("/home")
    public String home() {
        return "marks";
    }


    @RequestMapping(value = "/markslist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Marks>> getAllMarks() {
        List<Marks> list = iMarksService.getAll();
        return new ResponseEntity<List<Marks>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iMarksService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/marks/{id}", method = RequestMethod.GET)
    public ResponseEntity<Marks> getUser(@PathVariable("id") Integer id) {
        Marks obj = iMarksService.getById(id);
        return new ResponseEntity<Marks>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/marks", method = RequestMethod.POST)
    public ResponseEntity<Void> addMarks(@RequestBody Marks obj, UriComponentsBuilder builder) {
        boolean flag = iMarksService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/marks/{id}").buildAndExpand(obj.getMarksId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/marks/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Marks> updateUser(@RequestBody Marks obj) {
        iMarksService.update(obj);
        return new ResponseEntity<Marks>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/marks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iMarksService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
