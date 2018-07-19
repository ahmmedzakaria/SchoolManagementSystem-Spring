
<%@include file="../home/header.jsp" %>
<div class="content"  ng-controller="StudentInfoController as studentCtrl">

    <!--Side Bar-->    
    <div class="d-flex">
        <div class="left_sidebar wrapper d-flex" id="parentDiv" >
            <div class="float-left collapse width show align-self-stretch" id="sidebar">
                <%@include file="sidebar_menu_admin.jsp" %>
            </div>
        </div>

        <div class="p-2 main_content flex-grow-1">

            <!--Navigator Button--> 
            <main class="float-left main">
                <button id ="btn_navigate" data-target="#sidebar" data-toggle="collapse" class="btn" ng-class="{min: min}" ng-click="toggle()" data-active-icon='&#xf104;' data-inactive-icon='&#xf105;'></button>
                <!--<a href="#" data-target="#sidebar" data-toggle="collapse"><i class="fa fa-navicon fa-2x py-2 p-1"></i></a>-->           
            </main><br><br>

            <div id="container">
                <table class="table table-striped table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Index</th>
                            <th scope="col">Name</th>
                            <th scope="col">Role</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="row in studentCtrl.studentInfos">
                            <th scope="row">{{$index + 1}}</th>
                            <td><span ng-bind="row.users.firstName"></span></td>
                            <td><span ng-bind="row.users.role.roleName"></span></td>
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

                                <label for="firstName" class="lbl"><b>First Name</b></label>
                                <input type="text" name="firstName" ng-model="studentCtrl.studentInfo.users.firstName"  placeholder="Your First Name" required /> 
                                <p><p><span ng-show="studentInfoForm.firstName.$error.required" class="msg-val">Name is required.</span></p> </p> 


                                <label for="lastName" class="lbl"><b>Last Name</b></label>
                                <input type="text" name="lastName" ng-model="studentCtrl.studentInfo.users.lastName"  placeholder="Your Last Name" required/> 
                                <p><span ng-show="studentInfoForm.lastName.$error.required" class="msg-val">Location is required.</span></p>  

                                <label for="userName" class="lbl"><b>User Name</b></label>
                                <input type="text" name="userName" ng-model="studentCtrl.studentInfo.users.userName"  placeholder="Your User Name" required/> 
                                <p><span ng-show="studentInfoForm.userName.$error.required" class="msg-val">Phone No is required.</span></p>  

                                <label for="userPassword" class="lbl"><b>Password</b></label>
                                <input type="text" name="userPassword" ng-model="studentCtrl.studentInfo.users.userPassword"  placeholder="Your Password" required/> 
                                <p><span ng-show="studentInfoForm.userPassword.$error.required" class="msg-val">Mobile No is required.</span></p>  

                                <label for="email" class="lbl"><b>Email</b></label>
                                <input type="text" name="email" ng-model="studentCtrl.studentInfo.users.email"  placeholder="Your Email" required/> 
                                <p><span ng-show="studentInfoForm.email.$error.required" class="msg-val">Email is required.</span></p>  

                                <p><span  ng-if="studentCtrl.flag == 'created'" class="msg-success">Users successfully added.</span></p> 
                                <!--<p><span  ng-if="showAlert(studentCtrl.flag)" class="msg-success">Users successfully added.</span></p>--> 

                                <div ng-if="$root.displayAlert(studentCtrl.flag) === true"></div>
                                <span ng-if="studentCtrl.flag == 'failed'" class="msg-val">Users already exists.</span> 

                                <label for="gender">Gender</label></br>
                                <input type="radio" name="gender" id="gender"  ng-model='studentCtrl.studentInfo.users.gender.genderId' ng-value='"1"' value="male"> Male<br>
                                <input type="radio" name="gender" id="gender" ng-model='studentCtrl.studentInfo.users.gender.genderId' ng-value='"2"' value="female"> Female<br>

                                <!--File Upload-->
                                <input type="file" custom-on-change="uploadFile" id="fileSelected">

                                <br>

                                <input  type="submit" ng-click="studentCtrl.updateStudentInfoDetail()" class="update btn btn-success"  data-dismiss="modal" value="Update User"/> 


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
