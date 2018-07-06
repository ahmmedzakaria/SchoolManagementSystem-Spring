<%@include file="header.jsp" %>


<div class="content" >
    <div class="d-flex">
        <div class="left_sidebar wrapper d-flex" id="parentDiv" >
            <div class="float-left collapse width show align-self-stretch" id="sidebar">
                <%@include file="sidebar_menu.jsp" %>
            </div>
        </div>

        <div class="p-2 main_content flex-grow-1">
            <main class="float-left main">
                <button id ="btn_navigate" data-target="#sidebar" data-toggle="collapse" class="btn" ng-class="{min: min}" ng-click="toggle()" data-active-icon='&#xf104;' data-inactive-icon='&#xf105;'></button>
                <!--<a href="#" data-target="#sidebar" data-toggle="collapse"><i class="fa fa-navicon fa-2x py-2 p-1"></i></a>-->           
            </main>
            <div class="col">
                <br>
                <br>
                <br>
                <h4>param.className</h4>
                <button type="button" class="btn btn-success" id="btnSuccess">Success</button>
                <button type="button" class="btn btn-warning" id="btnWarning">Warning</button>
                <button type="button" class="btn btn-info" id="btnInfo">Info</button>
                <button type="button" class="btn btn-danger" id="btnError">Error</button>
            </div>
        </div>

        <div class="p-2 right_sidebar">
            Right
        </div>
    </div>

</div>


<%@include file="footer.jsp" %>

