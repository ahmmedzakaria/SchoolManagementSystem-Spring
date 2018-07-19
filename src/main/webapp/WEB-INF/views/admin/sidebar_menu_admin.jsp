

<div class="list-group border-0 card text-center text-md-left">
<!--     {{studentCtrl.test}}-->
    <a href="home" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">Admin</span>
    </a>
    <a href="#menu1" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false">
        <span class="d-none d-md-inline">Add Users</span>
    </a>
    <div class="collapse" id="menu1" data-parent="#sidebar">
        <a href="adduser" class="list-group-item" ng-click="studentCtrl.addAdmin()">Admin</a>                    
        <a href="adduser" class="list-group-item" ng-click="studentCtrl.addTeacher()">Teacher</a>              
        <a href="adduser" class="list-group-item" ng-click="studentCtrl.addOfficeStuff()">Office Stuff</a>
    </div>

    <a href="viewusers" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">View Users</span>
    </a>

    <a href="access" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">Access Control</span>
    </a>

    <a href="#menu3" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false">
        <span class="d-none d-md-inline">Item 3 </span>
    </a>
    <div class="collapse" id="menu3" data-parent="#sidebar">
        <a href="#" class="list-group-item" data-parent="#menu3">3.1</a>
        <a href="#menu3sub2" class="list-group-item" data-toggle="collapse" aria-expanded="false">3.2 </a>	
        <div class="collapse" id="menu3sub2">
            <a href="#" class="list-group-item" data-parent="#menu3sub2">3.2 a</a>
            <a href="#" class="list-group-item" data-parent="#menu3sub2">3.2 b</a>
            <a href="#" class="list-group-item" data-parent="#menu3sub2">3.2 c</a>
        </div>
        <a href="#" class="list-group-item" data-parent="#menu3">3.3</a>
    </div>

</div>