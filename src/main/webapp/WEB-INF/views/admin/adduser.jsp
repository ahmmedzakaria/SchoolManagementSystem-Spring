<%@include file="../home/header.jsp" %>
<div class="content"  ng-controller="UserInfoController as userCtrl">

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


            <!--User Registration Form-->
            <div id="container">
                {{userCtrl.test}}

                <!--<div ng-if="$root.displayAlert(userCtrl.flag,userCtrl.msg,userCtrl.title,userCtrl.className) === true"></div>-->
                <!--                <span ng-if="userCtrl.flag == 'failed'" class="msg-val">Users already exists.</span> -->

                <form name="studentInfoForm" method="POST">
                    <h3> Register {{userCtrl.user}}</h3>



                    <label for="firstName" class="lbl"><b>First Name</b></label>
                    <input type="text" name="firstName" ng-model="userCtrl.studentInfo.users.firstName"  placeholder="Your First Name" required /> 
                    <p><p><span ng-show="studentInfoForm.firstName.$error.required" class="msg-val">Name is required.</span></p> </p> 


                    <label for="lastName" class="lbl"><b>Last Name</b></label>
                    <input type="text" name="lastName" ng-model="userCtrl.studentInfo.users.lastName"  placeholder="Your Last Name" required/> 
                    <p><span ng-show="studentInfoForm.lastName.$error.required" class="msg-val">Location is required.</span></p>  

                    <label for="userName" class="lbl"><b>User Name</b></label>
                    <input type="text" name="userName" ng-model="userCtrl.studentInfo.users.userName"  placeholder="Your User Name" required/> 
                    <p><span ng-show="studentInfoForm.userName.$error.required" class="msg-val">Phone No is required.</span></p>  

                    <label for="userPassword" class="lbl"><b>Password</b></label>
                    <input type="text" name="userPassword" ng-model="userCtrl.studentInfo.users.userPassword"  placeholder="Your Password" required/> 
                    <p><span ng-show="studentInfoForm.userPassword.$error.required" class="msg-val">Mobile No is required.</span></p>  

                    <label for="email" class="lbl"><b>Email</b></label>
                    <input type="text" name="email" ng-model="userCtrl.studentInfo.users.email"  placeholder="Your Email" required/> 
                    <p><span ng-show="studentInfoForm.email.$error.required" class="msg-val">Email is required.</span></p>  

                    <p><span  ng-if="userCtrl.flag == 'created'" class="msg-success">Users successfully added.</span></p> 
                    <!--<p><span  ng-if="showAlert(userCtrl.flag)" class="msg-success">Users successfully added.</span></p>--> 

                    <div ng-if="$root.displayAlert(userCtrl.flag) === true"></div>
                    <span ng-if="userCtrl.flag == 'failed'" class="msg-val">Users already exists.</span> 

                    <label for="gender">Gender</label></br>
                    <input type="radio" name="gender" id="gender"  ng-model='userCtrl.studentInfo.users.gender.genderId' ng-value='"1"' value="male"> Male<br>
                    <input type="radio" name="gender" id="gender" ng-model='userCtrl.studentInfo.users.gender.genderId' ng-value='"2"' value="female"> Female<br>

                    <!--File Upload-->
                    <input type="file" custom-on-change="uploadFile" id="fileSelected">

                    <br>

                    <input id="save" class="save btn btn-success" type="submit" ng-click="userCtrl.addStudentInfo()"  value="Save User"/> 
                    <input id="reset" type="button" class="reset btn btn-warning" ng-click="userCtrl.reset()" value="Reset"/>



                </form>
                <br>

            </div>




            <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>


            <script src="${pageContext.request.contextPath}/static/js/controller/user_info_controller.js" type="text/javascript"></script>
            <!--<script src="${pageContext.request.contextPath}/static/js/controller/student_info_controller.js" type="text/javascript"></script>-->




        </div>
    </div>

</div>

<%@include file="../home/footer.jsp" %>
