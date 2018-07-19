<div class="modal fade" id="lab-slide-bottom-popup" data-keyboard="false" data-backdrop="false">
    <div class="lab-modal-body"   ng-controller="StudentInfoController as studentCtrl">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>

        <form name="studentInfoForm" method="POST">
            <h3> Register {{studentCtrl.user}}</h3>



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

            <input  type="submit" ng-click="studentCtrl.addStudentInfo()"  value="Add Users"/> 
            <input type="button" ng-click="studentCtrl.reset()" value="Reset"/>

        </form>
    </div>
    <!-- /.modal-body -->
</div>
