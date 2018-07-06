/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.Guardian;
import com.school.service.IGuardianService;
import com.school.support.ISupportService;
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
@RequestMapping("/guardian")
public class GuardianController {

    @Autowired
    private ISupportService<Guardian> iSupportService;

    @RequestMapping("/home")
    public String home() {
        return "guardian";
    }
    @RequestMapping(value = "/guardianlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Guardian>> getAllGuardian() {
        List<Guardian> list = iSupportService.getAll();
        return new ResponseEntity<List<Guardian>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/guardianlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Guardian> getTspById(@PathVariable("id") Integer id) {
        Guardian guardian = iSupportService.getById(id);
        return new ResponseEntity<Guardian>(guardian, HttpStatus.OK);
    }

    @RequestMapping(value = "/guardianlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addGuardian(@RequestBody Guardian guardian, UriComponentsBuilder builder) {
        boolean flag = iSupportService.add(guardian);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/guardianlist/{id}").buildAndExpand(guardian.getGuardianId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/guardianlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Guardian> updateTsp(@RequestBody Guardian guardian) {
        iSupportService.update(guardian);
        return new ResponseEntity<Guardian>(guardian, HttpStatus.OK);
    }

    @RequestMapping(value = "/guardianlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTsp(@PathVariable("id") Integer id) {
        iSupportService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
