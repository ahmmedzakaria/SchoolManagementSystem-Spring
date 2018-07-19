/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Faculty
 */
//@RestController
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        //        return "Welcome to RestTemplate Example.";
        return "home/index";
    }
//    Admin
    
    @RequestMapping("/admin/home")
    public String admin() {//Welcome page, non-rest
        //        return "Welcome to RestTemplate Example.";
        return "admin/admin";
    }
    
    @RequestMapping("/admin/adduser")
    public String addUser() {
        return "admin/adduser";
    }
    
    @RequestMapping("/admin/viewusers")
    public String viewUser() {
        return "admin/viewusers";
    }
    
    @RequestMapping("/admin/access")
    public String userAccessControl() {
        return "admin/access";
    }
    
    //Office
       @RequestMapping("/office/home")
    public String officeHome() {
        return "office/office";
    }
    
    @RequestMapping("/office/addstudent")
    public String addStudent() {
        return "office/addstudent";
    }
    
    @RequestMapping("/office/viewstudents")
    public String viewStudent() {
        return "office/viewstudents";
    }
}
