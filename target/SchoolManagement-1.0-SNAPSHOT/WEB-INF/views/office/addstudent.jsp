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


            <!--User Registration Form-->
            <div ng-controller="StudentInfoController as studentCtrl" id="container">
                {{studentCtrl.test}}

                <form name="studentInfoForm" method="POST">
                    <h3> Register {{studentCtrl.user}}</h3>

                    <%@include file="studentform.jsp" %>

                    <div class="alert alert-danger" role="alert" data-ng-if="selectQuestion[2].alreadySelected">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span> {{questionSelectedError}}
                    </div>
                    <input id="save" class="save btn btn-success" type="submit" ng-click="studentCtrl.addStudentInfo()"  value="Save User"/> 
                    <input id="reset" type="button" class="reset btn btn-warning" ng-click="studentCtrl.reset()" value="Reset"/>

                </form>

            </div>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/js/app.js"></script>

            <script src="${pageContext.request.contextPath}/static/js/controller/student_info_controller.js" type="text/javascript"></script>


        </div>
    </div>

</div>

<%@include file="../home/footer.jsp" %>
