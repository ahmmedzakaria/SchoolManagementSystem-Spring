/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.Users;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ISupportService<Users> iSupportService;

    @RequestMapping("/home")
    public String home() {
        return "user";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> list = iSupportService.getAll();
        return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> getTspById(@PathVariable("id") Integer id) {
        Users user = iSupportService.getById(id);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addUsers(@RequestBody Users user, UriComponentsBuilder builder) {
        boolean flag = iSupportService.add(user);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/userlist/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateTsp(@RequestBody Users user) {
        iSupportService.update(user);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/userlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTsp(@PathVariable("id") Integer id) {
        iSupportService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
