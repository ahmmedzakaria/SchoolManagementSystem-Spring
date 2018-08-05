/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Notice;
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
@RequestMapping("/noticeinfo")
public class NoticeController {

    @Qualifier(value = "noticeService")
    @Autowired
    private ISupportService<Notice> iNoticeService;
   

    @RequestMapping("/home")
    public String home() {
        return "notice";
    }


    @RequestMapping(value = "/noticelist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Notice>> getAllNotice() {
        List<Notice> list = iNoticeService.getAll();
        return new ResponseEntity<List<Notice>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iNoticeService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/notice/{id}", method = RequestMethod.GET)
    public ResponseEntity<Notice> getUser(@PathVariable("id") Integer id) {
        Notice obj = iNoticeService.getById(id);
        return new ResponseEntity<Notice>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public ResponseEntity<Void> addNotice(@RequestBody Notice obj, UriComponentsBuilder builder) {
        boolean flag = iNoticeService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/notice/{id}").buildAndExpand(obj.getNoticeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/notice/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Notice> updateUser(@RequestBody Notice obj) {
        iNoticeService.update(obj);
        return new ResponseEntity<Notice>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/notice/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iNoticeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
