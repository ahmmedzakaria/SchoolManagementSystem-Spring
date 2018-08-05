

<label for="firstName" class="lbl"><b>First Name</b></label>
<input type="text" name="firstName" ng-model="studentCtrl.studentInfo.users.firstName"  placeholder="Your First Name" required /> 
<p><p><span ng-show="studentInfoForm.firstName.$error.required" class="msg-val">Name is required.</span></p> </p> 


<label for="lastName" class="lbl"><b>Last Name</b></label>
<input type="text" name="lastName" ng-model="studentCtrl.studentInfo.users.lastName"  placeholder="Your Last Name" required/> 
<p><span ng-show="studentInfoForm.lastName.$error.required" class="msg-val">Location is required.</span></p>  

<label for="studentSession" class="lbl"><b>Session</b></label>
<select class="form-control" id="studentSession"  ng-model="studentCtrl.studentRecordBs.studentSession" ng-options="studentSession.sessionName for studentSession in studentCtrl.commonSupport.studentSessionsList">
<option value="" disabled selected>{{studentCtrl.studentSession.sessionName}}</option>
</select>

<label for="class" class="lbl"><b>Class</b></label>
<select ng-change="studentCtrl.showGroup()" class="form-control" id="class"  ng-model="studentCtrl.studentRecordBs.classes" ng-options="classes.className for classes in studentCtrl.commonSupport.classList">
<option value="" disabled selected>{{studentCtrl.classes.className}}</option>
</select>

<label for="section" class="lbl"><b>Section</b></label>
<select ng-change="studentCtrl.setGroupIfNeed()" class="form-control" id="section"  ng-model="studentCtrl.studentRecordBs.section" ng-options="section.sectionName for section in studentCtrl.commonSupport.sectionList">
<option value="" disabled selected>{{studentCtrl.section.sectionName}}</option>
</select>

<label ng-hide="studentCtrl.groupFlag" for="groups" class="lbl"><b>Group</b></label>
<select ng-hide="studentCtrl.groupFlag" ng-change="studentCtrl.getMaxRoll()" class="form-control" id="groups"  ng-model="studentCtrl.studentRecordBs.groups" ng-options="groups.groupName for groups in studentCtrl.commonSupport.groupsList">
<option value="" disabled selected>{{studentCtrl.groups.groupName}}</option>
</select>


<label for="roll" class="lbl"><b>Student Roll</b></label>
<input type="text" name="rollNumber" ng-model="studentCtrl.studentRecordBs.rollNumber" placeholder="Your Roll" required/> 
<p><span ng-show="studentInfoForm.rollNumber.$error.required" class="msg-val">Roll Number is required.</span></p>  

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