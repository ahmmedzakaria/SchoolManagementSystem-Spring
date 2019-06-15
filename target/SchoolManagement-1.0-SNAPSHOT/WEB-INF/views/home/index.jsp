<%@include file="header.jsp" %>

<div id="demo" class="carousel slide" data-ride="carousel">
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath}/static/img/school1.jpg" alt="Los Angeles" width="1100" height="500">
                        <div class="carousel-caption">
                            <h3>Know Thyself</h3>
                            <p>We had such a great time in LA!</p>
                        </div>   
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/static/img/school1.jpg" alt="Chicago" width="1100" height="500">
                        <div class="carousel-caption">
                            <h3>Learn Till Death</h3>
                            <p>Thank you</p>
                        </div>   
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/static/img/school1.jpg" alt="New York" width="1100" height="500">
                        <div class="carousel-caption">
                            <h3>Happy School</h3>
                            <p>We love the Our School!</p>
                        </div>   
                    </div>
                </div>
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>


<div class="content" >
    <div class="d-flex p-3">
        <div class="d-flex">
            <!--        <div class="left_sidebar wrapper d-flex" id="parentDiv" >
                        <div class="float-left collapse width show align-self-stretch" id="sidebar">
            <%@include file="sidebar_menu.jsp" %>
        </div>
    </div>-->

            <div class="p-2 main_content flex-grow-1">
                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. </p>
                <br></br>

                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

                </p>

                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. </p>
                <br>
            </div>

            <div class="p-2 right_sidebar">
                <img class="img-responsive"  src="${pageContext.request.contextPath}/static/img/Notice.jpg" alt="Image" height="400">
            </div>
        </div>
    </div>



</div>


<%@include file="footer.jsp" %>

