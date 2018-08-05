
<%@include file="../home/header.jsp" %>
<div class="content"  ng-controller="MarksController as marksCtrl">

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
                    <select ng-change="marksCtrl.getStudentsBySesssion()" class="form-control" id="studentSession"  ng-model="marksCtrl.studentSession" ng-options="studentSession.sessionName for studentSession in marksCtrl.commonSupport.studentSessionsList">
                        <option value="" disabled selected>{{marksCtrl.studentSession.sessionName}}</option>
                    </select>
                </div>
                <div ng-show="marksCtrl.classFlag" class="p-2 bg-warning flex-fill">
                    <label for="class" class="lbl"><b>Class</b></label>
                    <select ng-change="marksCtrl.getStudentsBySesssionAndClass()"  class="form-control" id="class"  ng-model="marksCtrl.classes" ng-options="classes.className for classes in marksCtrl.commonSupport.classList">
                        <option value="" disabled selected>{{marksCtrl.classes.className}}</option>
                    </select>
                </div>
                <div ng-show="marksCtrl.sectionFlag" class="p-2 bg-primary flex-fill">
                    <label for="section" class="lbl"><b>Section</b></label>
                    <select ng-change="marksCtrl.getStudentsBySesssionClassAndSection()" class="form-control" id="section"  ng-model="marksCtrl.section" ng-options="section.sectionName for section in marksCtrl.commonSupport.sectionList">
                        <option value="" disabled selected>{{marksCtrl.section.sectionName}}</option>
                    </select>
                </div>
                <div ng-show="marksCtrl.groupFlag" class="p-2 bg-success flex-fill">
                    <label for="groups" class="lbl"><b>Group</b></label>
                    <select ng-change="marksCtrl.getStudentsBySesssionClassSectionAndGroup()" class="form-control" id="groups"  ng-model="marksCtrl.groups" ng-options="groups.groupName for groups in marksCtrl.commonSupport.groupsList">
                        <option value="" disabled selected>{{marksCtrl.groups.groupName}}</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="d-flex">
                <div class="p-2 bg-info flex-fill">
                    <label for="subjects" class="lbl"><b>Subjects</b></label>
                    <select ng-change="marksCtrl.subjectSelected()" class="form-control" id="subjects"  ng-model="marksCtrl.subjects" ng-options="subjects.subjectName for subjects in marksCtrl.commonSupport.subjectsList">
                        <option value="" disabled selected>{{marksCtrl.subjects.subjectName}}</option>
                    </select>
                </div>
                <div ng-show="marksCtrl.examFlag" class="p-2 bg-light flex-fill">
                    <label for="class" class="lbl"><b>Exams</b></label>
                    <select ng-change="marksCtrl.getStudentsBySesssionAndClass()"  class="form-control" id="exams"  ng-model="marksCtrl.exams" ng-options="exams.examName for exams in marksCtrl.commonSupport.examList">
                        <option value="" disabled selected>{{marksCtrl.exams.examName}}</option>
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
                            <th scope="col">Written</th>
                            <th scope="col">MCQ</th>
                            <th scope="col">Practical</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="row in marksCtrl.markList">
                            <th scope="row">{{$index + 1}}</th>
                            <td><a ng-click="marksCtrl.viewAttendance(row)" href="viewMarks"><span ng-bind="row.studentRecordBs.users.firstName"></span></a></td>
                            <td><span ng-bind="row.studentRecordBs.rollNumber"></span></td>
                            <td><input type='text'  class="checkbox-inline" ng-model='row.writtenMarks' placeholder='Written'> </td>
                            <td><input type='text'  class="checkbox-inline" ng-model='row.mcqMarks' placeholder='MCQ'> </td>
                            <td><input type='text'  class="checkbox-inline" ng-model='row.practicalMarks' placeholder='Practical'> </td>

                        </tr>

                    </tbody>
                </table>
                <br>
                <button type="button" ng-click="marksCtrl.addMarks()" class="btn btn-outline-success">Save Attendance</button>
                
            </div>





            <!-- The Modal -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Register {{marksCtrl.user}}</h4>
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
                            <input type="button" ng-click="marksCtrl.deleteStudentInfo(row.users.userId)" class="btn btn-danger"   data-dismiss="modal"   value="Delete"/>
                            <input type="button" class="btn btn-primary" data-dismiss="modal" value="Cancle">
                        </div>

                    </div>
                </div>
            </div>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/app.js"></script>

            <script src="${pageContext.request.contextPath}/static/js/controller/marks_controller.js" type="text/javascript"></script>

            <!--        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                    <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>-->
        </div>
    </div>

</div>

<%@include file="../home/footer.jsp" %>
