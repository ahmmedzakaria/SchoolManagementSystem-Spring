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


           
        </div>
    </div>

</div>
<script>
    function showAlert(massage){
    console.log(massage);
    if (massage == 'created'){
    birdAlert.notify({
    msg: 'Facilisis pellentesque dictumst dignissim, mauris et tincidunt tincidunt',
            title: 'Success',
            className: 'success'
    });
    }
    }



</script>
<%@include file="../home/footer.jsp" %>
