/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.domain.entity.Payment;
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
@RequestMapping("/paymentinfo")
public class PaymentController {

    @Qualifier(value = "paymentService")
    @Autowired
    private ISupportService<Payment> iPaymentService;
   

    @RequestMapping("/home")
    public String home() {
        return "payment";
    }


    @RequestMapping(value = "/paymentlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> list = iPaymentService.getAll();
        return new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<CommonSupport> getCommonSupportService() {
        CommonSupport service = iPaymentService.getCommonSupportService();
        return new ResponseEntity<CommonSupport>(service, HttpStatus.OK);
    }
    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getUser(@PathVariable("id") Integer id) {
        Payment obj = iPaymentService.getById(id);
        return new ResponseEntity<Payment>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<Void> addPayment(@RequestBody Payment obj, UriComponentsBuilder builder) {
        boolean flag = iPaymentService.add(obj);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/payment/{id}").buildAndExpand(obj.getPaymentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Payment> updateUser(@RequestBody Payment obj) {
        iPaymentService.update(obj);
        return new ResponseEntity<Payment>(obj, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        iPaymentService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
