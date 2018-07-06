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
        <div ng-controller="GuardianController as guardianCtrl">
            <h1> Spring MVC 4 REST + AngularJS </h1>{{guardianCtrl.test}}
            <form name="guardianForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="guardianCtrl.flag != 'edit'">
                                <h3> Add New Guardian </h3> 
                            </div>
                            <div ng-if="guardianCtrl.flag == 'edit'">
                                <h3> Update Guardian for ID: {{ guardianCtrl.guardian.guardianId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Name: </td> <td><input type="text" name="name" ng-model="guardianCtrl.guardian.guardianName" required/> 
                            <span ng-show="guardianForm.name.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Address </td> <td> <input type="text" name="address" ng-model="guardianCtrl.guardian.address" required/> 
                            <span ng-show="guardianForm.address.$error.required" class="msg-val">Location is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Phone No </td> <td> <input type="text" name="phone" ng-model="guardianCtrl.guardian.phoneNo" required/> 
                            <span ng-show="guardianForm.phone.$error.required" class="msg-val">Phone No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Mobile No </td> <td> <input type="text" name="mobile" ng-model="guardianCtrl.guardian.mobileNo" required/> 
                            <span ng-show="guardianForm.mobile.$error.required" class="msg-val">Mobile No is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Email </td> <td> <input type="text" name="email" ng-model="guardianCtrl.guardian.email" required/> 
                            <span ng-show="guardianForm.email.$error.required" class="msg-val">Email is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="guardianCtrl.flag == 'created'" class="msg-success">Guardian successfully added.</span>
                            <span ng-if="guardianCtrl.flag == 'failed'" class="msg-val">Guardian already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="personCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="guardianCtrl.addGuardian()" value="Add Guardian"/> 
                                <input type="button" ng-click="guardianCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="guardianCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="guardianCtrl.updateGuardianDetail()" value="Update Guardian"/> 	
                                <input type="button" ng-click="guardianCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="guardianCtrl.flag == 'deleted'" class="msg-success">Guardian successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Location</th></tr>
                <tr ng-repeat="row in guardianCtrl.guardians">
                    <td><span ng-bind="row.guardianId"></span></td>
                    <td><span ng-bind="row.guardianName"></span></td>
                    <td><span ng-bind="row.address"></span></td>
                    <td>
                        <input type="button" ng-click="guardianCtrl.deleteGuardian(row.guardianId)" value="Delete"/>
                        <input type="button" ng-click="guardianCtrl.editGuardian(row.guardianId)" value="Edit"/>
                        <span ng-if="guardianCtrl.flag == 'updated' && row.guardianId == guardianCtrl.updatedId" class="msg-success">Guardian successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/guardian_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 

