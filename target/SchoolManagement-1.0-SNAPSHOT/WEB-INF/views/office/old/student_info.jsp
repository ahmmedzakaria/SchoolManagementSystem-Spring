<%-- 
    Document   : home
    Created on : Jan 24, 2018, 4:40:48 PM
    Author     : Faculty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="StudentInfoController as studentCtrl">
            <h1> Spring MVC 4 REST + AngularJS </h1>{{studentCtrl.test}}
            <form name="studentInfoForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="studentCtrl.flag != 'edit'">
                                <h3> Add New Users </h3> 
                            </div>
                            <div ng-if="studentCtrl.flag == 'edit'">
                                <h3> Update Users for ID: {{ studentCtrl.studentInfo.users.userId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>First Name: </td> <td><input type="text" name="firstName" ng-model="studentCtrl.studentInfo.users.firstName" required/> 
                            <span ng-show="studentInfoForm.firstName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Last Name </td> <td> <input type="text" name="lastName" ng-model="studentCtrl.studentInfo.users.lastName" required/> 
                            <span ng-show="studentInfoForm.lastName.$error.required" class="msg-val">Location is required.</span> </td>
                    </tr>
                    <tr>
                        <td>User Name </td> <td> <input type="text" name="phone" ng-model="studentCtrl.studentInfo.users.userName" required/> 
                            <span ng-show="studentInfoForm.phone.$error.required" class="msg-val">Phone No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Password</td> <td> <input type="text" name="mobile" ng-model="studentCtrl.studentInfo.users.userPassword" required/> 
                            <span ng-show="studentInfoForm.mobile.$error.required" class="msg-val">Mobile No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Email </td> <td> <input type="text" name="email" ng-model="studentCtrl.studentInfo.users.email" required/> 
                            <span ng-show="studentInfoForm.email.$error.required" class="msg-val">Email is required.</span> </td>
                    </tr>
                    
                    <!--Student Basic Info-->
                    <tr>
                        <td>Roll </td> <td> <input type="text" name="rollNumber" ng-model="studentCtrl.studentRecordBs.rollNumber" required/> 
                            <span ng-show="studentInfoForm.rollNumber.$error.required" class="msg-val">Roll Number is required.</span> </td>
                    </tr>
                    
                    
                    <tr>
                        <td colspan="2"> <span ng-if="studentCtrl.flag == 'created'" class="msg-success">Users successfully added.</span>
                            <span ng-if="studentCtrl.flag == 'failed'" class="msg-val">Users already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="personCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="studentCtrl.addStudentInfo()" value="Add Users"/> 
                                <input type="button" ng-click="studentCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="studentCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="studentCtrl.updateStudentInfoDetail()" value="Update Users"/> 	
                                <input type="button" ng-click="studentCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="studentCtrl.flag == 'deleted'" class="msg-success">Users successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Location</th></tr>
                <tr ng-repeat="row in studentCtrl.studentInfos">
                    <td><span ng-bind="row.users.userId"></span></td>
                    <td><span ng-bind="row.users.firstName"></span></td>
                    <td><span ng-bind="row.users.lastName"></span></td>
                    <td>
                        <input type="button" ng-click="studentCtrl.deleteStudentInfo(row.users.userId)" value="Delete"/>
                        <input type="button" ng-click="studentCtrl.editStudentInfo(row.users.userId)" value="Edit"/>
                        <span ng-if="studentCtrl.flag == 'updated' && row.users.userId == studentCtrl.updatedId" class="msg-success">Users successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/student_info_controller.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 

