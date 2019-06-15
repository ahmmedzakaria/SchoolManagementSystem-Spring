
<%@include file="../home/header.jsp" %>
<div class="content"  ng-controller="StudentInfoController as studentCtrl">

    <!--Side Bar-->    
    <div class="d-flex">
        <div class="left_sidebar wrapper d-flex" id="parentDiv" >
            <div class="float-left collapse width show align-self-stretch" id="sidebar">
                <%@include file="sidebar_menu_office.jsp" %>
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
                    <select ng-change="studentCtrl.getStudentsBySesssion()" class="form-control" id="studentSession"  ng-model="studentCtrl.studentSession" ng-options="studentSession.sessionName for studentSession in studentCtrl.commonSupport.studentSessionsList">
                        <option value="" disabled selected>{{studentCtrl.studentSession.sessionName}}</option>
                    </select>
                </div>
                <div class="p-2 bg-warning flex-fill">
                    <label for="class" class="lbl"><b>Class</b></label>
                    <select ng-change="studentCtrl.getStudentsBySesssionAndClass()"  class="form-control" id="class"  ng-model="studentCtrl.classes" ng-options="classes.className for classes in studentCtrl.commonSupport.classList">
                        <option value="" disabled selected>{{studentCtrl.classes.className}}</option>
                    </select>
                </div>
                <div class="p-2 bg-primary flex-fill">
                    <label for="section" class="lbl"><b>Section</b></label>
                    <select ng-change="studentCtrl.getStudentsBySesssionClassAndSection()" class="form-control" id="section"  ng-model="studentCtrl.section" ng-options="section.sectionName for section in studentCtrl.commonSupport.sectionList">
                        <option value="" disabled selected>{{studentCtrl.section.sectionName}}</option>
                    </select>
                </div>
                <div class="p-2 bg-primary flex-fill">
                    <label for="groups" class="lbl"><b>Group</b></label>
                    <select ng-change="studentCtrl.getStudentsBySesssionClassSectionAndGroup()" class="form-control" id="groups"  ng-model="studentCtrl.groups" ng-options="groups.groupName for groups in studentCtrl.commonSupport.groupsList">
                        <option value="" disabled selected>{{studentCtrl.groups.groupName}}</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="border border-primary border-top-0">
                <table class="table table-hover table-striped ">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Index</th>
                            <th scope="col">Name</th>
                            <th scope="col">Roll Number</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="row in studentCtrl.studentRecordBsList">
                            <th scope="row">{{$index + 1}}</th>
                            <td><span ng-bind="row.users.firstName"></span></td>
                            <td><span ng-bind="row.rollNumber"></span></td>
                            <td>

                                <input type="button" ng-click="studentCtrl.editStudentInfo(row.users.userId)"  class="btn btn-outline-primary" data-toggle="modal" data-target="#myModal" value="Edit"/>
                                <!--<input type="button" ng-click="studentCtrl.deleteStudentInfo(row.users.userId)" value="Delete"/>-->
                                <input type="button" ng-click="studentCtrl.prepareDelete(row)" class="btn btn-outline-danger" data-toggle="modal" data-target="#myModalDelete" value="Delete"/>
                            </td> 
                        </tr>

                    </tbody>
                </table>

            </div>





            <!-- The Modal -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Register {{studentCtrl.user}}</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form name="studentInfoForm" method="POST">
                                <%@include file="studentform.jsp" %>
                                <br>

                                <input  type="submit" ng-click="studentCtrl.updateStudentInfoDetail()" class="update btn btn-success"  data-dismiss="modal" value="Update Student"/> 


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
                            <input type="button" ng-click="studentCtrl.deleteStudentInfo(row.users.userId)" class="btn btn-danger"   data-dismiss="modal"   value="Delete"/>
                            <input type="button" class="btn btn-primary" data-dismiss="modal" value="Cancle">
                        </div>

                    </div>
                </div>
            </div>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/app.js"></script>

            <script src="${pageContext.request.contextPath}/static/js/controller/student_info_controller.js" type="text/javascript"></script>

            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
            <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
        </div>
    </div>

</div>

<%@include file="../home/footer.jsp" %>
