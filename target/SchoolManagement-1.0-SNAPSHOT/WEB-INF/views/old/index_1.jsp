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
                <button data-target="#sidebar" data-toggle="collapse" class="btn" ng-class="{min: min}" ng-click="toggle()" data-active-icon='&#xf104;' data-inactive-icon='&#xf105;'></button>
                <!--<a href="#" data-target="#sidebar" data-toggle="collapse"><i class="fa fa-navicon fa-2x py-2 p-1"></i></a>-->           
            </main>
        </div>

        <div class="p-2 right_sidebar">
            Right
        </div>
    </div>

</div>


<%@include file="footer.jsp" %>

<script>
    $(document).ready(function () {
        $('.left_sidebar').css('background-color', 'var(--left-sidebar-bg-color-for-menu)');
        $("button").click(function () {
            $("button").toggleClass('min');
            $("button").hide();
        });
        $("body").on("mousemove", function (event) {
            if (event.pageX < 50) {
                $("button").show();
                setTimeout(function () {
                    $("button").hide();
                }, 1000);
            }
        });

        $("#sidebar")
                .on("mouseenter", function () {
                    $("button").show();
                })
                .on("mouseleave", function () {
                    setTimeout(function () {
                        $("button").hide();
                    }, 1500);
                    //$("button").hide();
                });
    });
</script>

