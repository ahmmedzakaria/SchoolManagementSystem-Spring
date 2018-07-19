/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Religion;
import com.school.domain.entity.Role;
import com.school.domain.entity.SubScholarship;
import com.school.domain.support.CommonSupport;
import com.school.service.support.ISubScholarshipService;
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
@RequestMapping("/subscholarshipinfo")
public class SubScholarshipController {

    @Autowired
    private ISubScholarshipService<SubScholarship> iSubScholarshipService;
   

    @RequestMapping("/home")
    public String home() {
        return "subscholarship";
    }


    @RequestMapping(value = "/subscholarshiplist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<SubScholarship>> getAllSubScholarship() {
        List<SubScholarship> list = iSubScholarshipService.getAll();
        return new ResponseEntity<List<SubScholarship>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iSubScholarshipService.getCommonSupportService();
        
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/subscholarship/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubScholarship> getSubScholarship(@PathVariable("id") Integer id) {
        SubScholarship obj = iSubScholarshipService.getById(id);
        return new ResponseEntity<SubScholarship>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/subscholarship", method = RequestMethod.POST)
    public ResponseEntity<Void> addSubScholarship(@RequestBody SubScholarship obj, UriComponentsBuilder builder) {
        boolean flag = iSubScholarshipService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/subscholarship/{id}").buildAndExpand(obj.getSubScholId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/subscholarship/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubScholarship> updateSubScholarship(@RequestBody SubScholarship obj) {
        iSubScholarshipService.update(obj);
        return new ResponseEntity<SubScholarship>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/subscholarship/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubScholarship(@PathVariable("id") Integer id) {
        iSubScholarshipService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
