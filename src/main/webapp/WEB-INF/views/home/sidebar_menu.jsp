

<div class="list-group border-0 card text-center text-md-left">
    <a href="#menu1" class="list-group-item d-inline-block collapsed" data-toggle="collapse" aria-expanded="false">
        <span class="d-none d-md-inline">Item 1</span>
    </a>
    <div class="collapse" id="menu1" data-parent="#sidebar">
        <a href="#menu1sub1" class="list-group-item">Subitem 1 </a>                    
        <a href="#menu1sub2" class="list-group-item">Subitem 2</a>              
        <a href="#" class="list-group-item">Subitem 3</a>
    </div>

    <a href="#" class="list-group-item d-inline-block collapsed">
        <span class="d-none d-md-inline">Item 2</span>
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