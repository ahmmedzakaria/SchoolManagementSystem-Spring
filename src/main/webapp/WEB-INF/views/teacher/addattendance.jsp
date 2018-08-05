
<%@include file="../home/header.jsp" %>
<div class="content"  ng-controller="AttendanceController as attendanceCtrl">

    <!--Side Bar-->    
    <div class="d-flex">
        <div class="left_sidebar wrapper d-flex" id="parentDiv" >
            <div class="float-left collapse width show align-self-stretch" id="sidebar">
                <%@include file="sidebar_menu_teacher.jsp" %>
            </div>
        </div>

        <div class="p-2 main_content flex-grow-1">

            <!--Navigator Button--> 
            <main class="float-left main">
                <button id ="btn_navigate" data-target="#sidebar" data-toggle="collapse" class="btn" ng-class="{min: min}" ng-click="toggle()" data-active-icon='&#xf104;' data-inactive-icon='&#xf105;'></button>
                <!--<a href="#" data-target="#sidebar" data-toggle="collapse"><i class="fa fa-navicon fa-2x py-2 p-1"></i></a>-->           
            </main><br><br>

            <div class="d-flex">
                <div class="p-2 bg-info flex-fill">
                    <label for="studentSession" class="lbl"><b>Session</b></label>
                    <select ng-change="attendanceCtrl.getStudentsBySesssion()" class="form-control" id="studentSession"  ng-model="attendanceCtrl.studentSession" ng-options="studentSession.sessionName for studentSession in attendanceCtrl.commonSupport.studentSessionsList">
                        <option value="" disabled selected>{{attendanceCtrl.studentSession.sessionName}}</option>
                    </select>
                </div>
                <div ng-show="attendanceCtrl.classFlag" class="p-2 bg-warning flex-fill">
                    <label for="class" class="lbl"><b>Class</b></label>
                    <select ng-change="attendanceCtrl.getStudentsBySesssionAndClass()"  class="form-control" id="class"  ng-model="attendanceCtrl.classes" ng-options="classes.className for classes in attendanceCtrl.commonSupport.classList">
                        <option value="" disabled selected>{{attendanceCtrl.classes.className}}</option>
                    </select>
                </div>
                <div ng-show="attendanceCtrl.sectionFlag" class="p-2 bg-primary flex-fill">
                    <label for="section" class="lbl"><b>Section</b></label>
                    <select ng-change="attendanceCtrl.getStudentsBySesssionClassAndSection()" class="form-control" id="section"  ng-model="attendanceCtrl.section" ng-options="section.sectionName for section in attendanceCtrl.commonSupport.sectionList">
                        <option value="" disabled selected>{{attendanceCtrl.section.sectionName}}</option>
                    </select>
                </div>
                <div ng-show="attendanceCtrl.groupFlag" class="p-2 bg-success flex-fill">
                    <label for="groups" class="lbl"><b>Group</b></label>
                    <select ng-change="attendanceCtrl.getStudentsBySesssionClassSectionAndGroup()" class="form-control" id="groups"  ng-model="attendanceCtrl.groups" ng-options="groups.groupName for groups in attendanceCtrl.commonSupport.groupsList">
                        <option value="" disabled selected>{{attendanceCtrl.groups.groupName}}</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="border border-primary border p-2">
                <table class="table table-hover table-striped ">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Index</th>
                            <th scope="col">Name</th>
                            <th scope="col">Roll Number</th>
                            <th scope="col">Attendance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="row in attendanceCtrl.attendanceList">
                            <th scope="row">{{$index + 1}}</th>
                            <td><a ng-click="attendanceCtrl.viewAttendance(row)" href="viewattendance"><span ng-bind="row.studentRecordBs.users.firstName"></span></a></td>
                            <td><span ng-bind="row.studentRecordBs.rollNumber"></span></td>
                            <td><input ng-disabled="attendanceCtrl.disablity" type='checkbox' value="lasd" class="checkbox-inline" ng-model='row.attendanceStatus' placeholder='Field:'> {{attendanceStatus(row.attendanceStatus)}}</td>
                        </tr>

                    </tbody>
                </table>
                <br>
                <button ng-disabled="attendanceCtrl.disablity" type="button" ng-click="attendanceCtrl.addAttendance()" class="btn btn-outline-success">Save Attendance</button>
                
            </div>





            <!-- The Modal -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Register {{attendanceCtrl.user}}</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form name="studentInfoForm" method="POST">
                               

                               
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!--Delete Modal-->
            <div class="modal fade" id="myModalDelete">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Delete User</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            Do You Want to Delete ?
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <input type="button" ng-click="attendanceCtrl.deleteStudentInfo(row.users.userId)" class="btn btn-danger"   data-dismiss="modal"   value="Delete"/>
                            <input type="button" class="btn btn-primary" data-dismiss="modal" value="Cancle">
                        </div>

                    </div>
                </div>
            </div>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/app.js"></script>

            <script src="${pageContext.request.contextPath}/static/js/controller/attendance_controller.js" type="text/javascript"></script>

            <!--        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                    <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>-->
        </div>
    </div>

</div>

<%@include file="../home/footer.jsp" %>
