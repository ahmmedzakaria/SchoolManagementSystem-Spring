/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('.left_sidebar').css('background-color', 'var(--left-sidebar-bg-color-for-menu)');
    $("#btn_navigate").click(function () {
        $("#btn_navigate").toggleClass('min');
        $("#btn_navigate").hide();
    });

    $("body").on("mousemove", function (event) {
        if ($('#sidebar').is(':hidden')) {
            if (event.pageX < 50) {
                $("#btn_navigate").show();
                setTimeout(function () {
                    $("#btn_navigate")
                            .on("mouseleave", function () {
                                $("#btn_navigate").hide();
                            });
                }, 1500);
            }
        }

    });

//    $("#sidebar").on("mousemove", function () {
//        setTimeout(function () {
//            $("#btn_navigate").mouseout(function () {
//                toggoleButton();
//            });
//        }, 1500);
//
//    });

    if ($('#sidebar').is(':visible')) {

        $("#btn_navigate").mouseout(function () {

            toggoleButton();
        });

    }

    function toggoleButton() {
        $("#sidebar")
                .on("mouseenter", function () {
                    $("#btn_navigate").show();
                })
                .on("mouseleave", function () {
                    setTimeout(function () {
                        $("#btn_navigate").hide();
                    }, 1500);
                });

    }

});