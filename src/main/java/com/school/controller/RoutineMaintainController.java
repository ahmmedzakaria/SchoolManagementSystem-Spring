/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.RoutineMaintainer;
import com.school.domain.support.CommonSupport;
import com.school.support.ISupportService;
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
@RequestMapping("/routineinfo")
public class RoutineMaintainController {

    @Qualifier(value = "routineMaintainerService")
    @Autowired
    private ISupportService<RoutineMaintainer> iRoutineMaintainerService;
   

    @RequestMapping("/home")
    public String home() {
        return "routine";
    }


    @RequestMapping(value = "/routinelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<RoutineMaintainer>> getAllRoutineMaintainer() {
        List<RoutineMaintainer> list = iRoutineMaintainerService.getAll();
        return new ResponseEntity<List<RoutineMaintainer>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iRoutineMaintainerService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/routine/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoutineMaintainer> getUser(@PathVariable("id") Integer id) {
        RoutineMaintainer obj = iRoutineMaintainerService.getById(id);
        return new ResponseEntity<RoutineMaintainer>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/routine", method = RequestMethod.POST)
    public ResponseEntity<Void> addRoutineMaintainer(@RequestBody RoutineMaintainer obj, UriComponentsBuilder builder) {
        boolean flag = iRoutineMaintainerService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/routine/{id}").buildAndExpand(obj.getRoutineMaintainId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/routine/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RoutineMaintainer> updateUser(@RequestBody RoutineMaintainer obj) {
        iRoutineMaintainerService.update(obj);
        return new ResponseEntity<RoutineMaintainer>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/routine/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iRoutineMaintainerService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
