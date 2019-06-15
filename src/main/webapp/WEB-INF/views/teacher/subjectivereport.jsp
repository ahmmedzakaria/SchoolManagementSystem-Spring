
<%@include file="../home/header.jsp" %>
<div class="content"  ng-controller="ReportController as reportCtrl">

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
                <h1 class="display-4 mx-auto text-primary">Subject Report</h1>
                <br>
            </div>

            <div class="d-flex">
                
                <div class="p-2 bg-info flex-fill">
                    <label for="studentSession" class="lbl"><b>Session</b></label>
                    <select ng-change="reportCtrl.getStudentsBySesssion()" class="form-control" id="studentSession"  ng-model="reportCtrl.studentSession" ng-options="studentSession.sessionName for studentSession in reportCtrl.commonSupport.studentSessionsList">
                        <option value="" disabled selected>{{reportCtrl.studentSession.sessionName}}</option>
                    </select>
                </div>
                <div ng-show="reportCtrl.classFlag" class="p-2 bg-warning flex-fill">
                    <label for="class" class="lbl"><b>Class</b></label>
                    <select ng-change="reportCtrl.getStudentsBySesssionAndClass()"  class="form-control" id="class"  ng-model="reportCtrl.classes" ng-options="classes.className for classes in reportCtrl.commonSupport.classList">
                        <option value="" disabled selected>{{reportCtrl.classes.className}}</option>
                    </select>
                </div>
                <div ng-show="reportCtrl.sectionFlag" class="p-2 bg-primary flex-fill">
                    <label for="section" class="lbl"><b>Section</b></label>
                    <select ng-change="reportCtrl.getStudentsBySesssionClassAndSection()" class="form-control" id="section"  ng-model="reportCtrl.section" ng-options="section.sectionName for section in reportCtrl.commonSupport.sectionList">
                        <option value="" disabled selected>{{reportCtrl.section.sectionName}}</option>
                    </select>
                </div>
                <div ng-show="reportCtrl.groupFlag" class="p-2 bg-success flex-fill">
                    <label for="groups" class="lbl"><b>Group</b></label>
                    <select ng-change="reportCtrl.getStudentsBySesssionClassSectionAndGroup()" class="form-control" id="groups"  ng-model="reportCtrl.groups" ng-options="groups.groupName for groups in reportCtrl.commonSupport.groupsList">
                        <option value="" disabled selected>{{reportCtrl.groups.groupName}}</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="d-flex">
                <div class="p-2 bg-info flex-fill">
                    <label for="subjects" class="lbl"><b>Subjects</b></label>
                    <select ng-change="reportCtrl.subjectSelected()" class="form-control" id="subjects"  ng-model="reportCtrl.subjects" ng-options="subjects.subjectName for subjects in reportCtrl.commonSupport.subjectsList">
                        <option value="" disabled selected>{{reportCtrl.subjects.subjectName}}</option>
                    </select>
                </div>
                <div ng-show="reportCtrl.examFlag" class="p-2 bg-primary flex-fill">
                    <label for="class" class="lbl"><b>Exams</b></label>
                    <select ng-change="reportCtrl.getStudentsBySesssionAndClass()"  class="form-control" id="exams"  ng-model="reportCtrl.exams" ng-options="exams.examName for exams in reportCtrl.commonSupport.examList">
                        <option value="" disabled selected>{{reportCtrl.exams.examName}}</option>
                    </select>
                </div> 
            </div>
            <br>
            
            <button type="button" ng-click="reportCtrl.getSubjectiveResult()" class="btn btn-outline-success">Generate Subjective Marks</button>
            <button type="button" ng-click="reportCtrl.attendanceReport()" class="btn btn-outline-success">Attendance Report</button>

            
            <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/app.js"></script>

            <script src="${pageContext.request.contextPath}/static/js/controller/report_controller.js" type="text/javascript"></script>

            <!--        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                    <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>-->
        </div>
    </div>

</div>

<%@include file="../home/footer.jsp" %>
