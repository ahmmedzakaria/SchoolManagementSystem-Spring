<%-- 
    Document   : index
    Created on : Jan 23, 2018, 2:37:11 AM
    Author     : Faculty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <!--<script src="<c:url value='/static/js/service/user_service.js' />"></script>-->
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
        <!--<link href="<c:url value='/static/css/layout.css' />" rel="stylesheet"></link>-->
        <link href='https://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row main_container">
                <div class="col-md-12">
                    <div class="d-flex flex-column mb-3">
                        <div class="header">
                            <section style="background: #34495e; color: rgba(255, 255, 255, 0.5);">
                                <nav class="circle">
                                    <ul>
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Result</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                        <li><a href="#">About</a></li>
                                        <li><a href="#">Notice</a></li>
                                    </ul>
                                </nav>
                            </section>
                        </div>

