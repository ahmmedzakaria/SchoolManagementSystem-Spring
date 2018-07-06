<div class="row d-flex d-md-block flex-nowrap wrapper">
    <div class="col-md-3 float-left col-1 pl-0 pr-0 collapse width show" id="sidebar">
        <div class="list-group border-0 card text-center text-md-left">
            <a href="#menu1" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><span class="d-none d-md-inline">Item 1</span> </a>
            <div class="collapse" id="menu1" data-parent="#sidebar">
                <a href="#menu1sub1" class="list-group-item">Subitem 1 </a>                    
                <a href="#menu1sub2" class="list-group-item">Subitem 2</a>              
                <a href="#" class="list-group-item">Subitem 3</a>
            </div>

            <a href="#" class="list-group-item d-inline-block collapsed"><i class="fa fa-film"></i> <span class="d-none d-md-inline">Item 2</span></a>
            <a href="#menu3" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false"><i class="fa fa-book"></i> <span class="d-none d-md-inline">Item 3 </span></a>
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
    </div>


    <main class="col-md-9 float-left col px-5 pl-md-2 pt-2 main">
        <a href="#" data-target="#sidebar" data-toggle="collapse"><i class="fa fa-navicon fa-2x py-2 p-1"></i></a>           
    </main>


</div>