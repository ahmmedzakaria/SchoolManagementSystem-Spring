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
        <div ng-controller="UsersController as usersCtrl">
            <h1> Spring MVC 4 REST + AngularJS </h1>{{usersCtrl.test}}
            <form name="usersForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="usersCtrl.flag != 'edit'">
                                <h3> Add New Users </h3> 
                            </div>
                            <div ng-if="usersCtrl.flag == 'edit'">
                                <h3> Update Users for ID: {{ usersCtrl.users.userId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>First Name: </td> <td><input type="text" name="firstName" ng-model="usersCtrl.users.firstName" required/> 
                            <span ng-show="usersForm.firstName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Last Name </td> <td> <input type="text" name="lastName" ng-model="usersCtrl.users.lastName" required/> 
                            <span ng-show="usersForm.lastName.$error.required" class="msg-val">Location is required.</span> </td>
                    </tr>
                    <tr>
                        <td>User Name </td> <td> <input type="text" name="phone" ng-model="usersCtrl.users.userName" required/> 
                            <span ng-show="usersForm.phone.$error.required" class="msg-val">Phone No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Password</td> <td> <input type="text" name="mobile" ng-model="usersCtrl.users.userPassword" required/> 
                            <span ng-show="usersForm.mobile.$error.required" class="msg-val">Mobile No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Email </td> <td> <input type="text" name="email" ng-model="usersCtrl.users.email" required/> 
                            <span ng-show="usersForm.email.$error.required" class="msg-val">Email is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="usersCtrl.flag == 'created'" class="msg-success">Users successfully added.</span>
                            <span ng-if="usersCtrl.flag == 'failed'" class="msg-val">Users already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="personCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="usersCtrl.addUsers()" value="Add Users"/> 
                                <input type="button" ng-click="usersCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="usersCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="usersCtrl.updateUsersDetail()" value="Update Users"/> 	
                                <input type="button" ng-click="usersCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="usersCtrl.flag == 'deleted'" class="msg-success">Users successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Location</th></tr>
                <tr ng-repeat="row in usersCtrl.userss">
                    <td><span ng-bind="row.userId"></span></td>
                    <td><span ng-bind="row.firstName"></span></td>
                    <td><span ng-bind="row.lastName"></span></td>
                    <td>
                        <input type="button" ng-click="usersCtrl.deleteUsers(row.userId)" value="Delete"/>
                        <input type="button" ng-click="usersCtrl.editUsers(row.userId)" value="Edit"/>
                        <span ng-if="usersCtrl.flag == 'updated' && row.userId == usersCtrl.updatedId" class="msg-success">Users successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/user_controller.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 

