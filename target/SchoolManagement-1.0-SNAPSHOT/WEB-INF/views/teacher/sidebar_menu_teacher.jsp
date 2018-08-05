

<div class="list-group border-0 card text-center text-md-left">
     <!--{{attendanceCtrl.test}}-->
    <a href="home" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">Teacher</span>
    </a>
    
<a href="addattendance" ng-click="" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">Give Attendance</span>
</a>
<a href="addmarks" ng-click="" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">Add Marks</span>
</a>

    <a href="viewstudents" ng-click="" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">View Students</span>
    </a>


    <a href="#menu3" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false">
        <span class="d-none d-md-inline">Something More </span>
    </a>
    <div class="collapse" id="menu3" data-parent="#sidebar">
        <a href="#" class="list-group-item" data-parent="#menu3">1.1</a>
        <a href="#menu3sub2" class="list-group-item" data-toggle="collapse" aria-expanded="false">3.2 </a>	
        <div class="collapse" id="menu3sub2">
            <a href="#" ng-click="attendanceCtrl.addTeacher()" class="list-group-item" data-parent="#menu3sub2">3.2 a</a>
            <a href="#" class="list-group-item" data-parent="#menu3sub2">1.2 b</a>
            <a href="#" class="list-group-item" data-parent="#menu3sub2">1.2 c</a>
        </div>
        <a href="#" class="list-group-item" data-parent="#menu3">1.3</a>
    </div>

</div>