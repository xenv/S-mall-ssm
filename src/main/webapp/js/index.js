$(function () {
    function show(cid) {

    }
    $(".m-menu li").mouseenter(function () {
        var cid = $(this).attr("cid");
        $(".d-menu[cid=" + cid + "]").show();
        $(this).find("a,span").css("color", "#FF0036");

    });
    $(".m-menu li").mouseleave(function () {
        var cid = $(this).attr("cid");
        $(".d-menu[cid=" + cid + "]").hide();
        $(this).find("a,span").css("color", "");
    });
    $(".d-menu").mouseenter(function () {
        $(this).show();
        var cid = $(this).attr("cid");
        $(".m-menu li[cid="+cid+"]").css("background", "white");
        $(".m-menu li[cid="+cid+"]").find("a,span").css("color", "#FF0036");
    });
    $(".d-menu").mouseleave(function () {
        $(this).hide();
        var cid = $(this).attr("cid");
        $(".m-menu li[cid="+cid+"]").css("background", "");
        $(".m-menu li[cid="+cid+"]").find("a,span").css("color", "");
    });
    $(".product-items .item").mouseenter(function(){
        $(this).css("border-color","#FF0036");
    });
    $(".product-items .item").mouseleave(function(){
        $(this).css("border-color","");
    })
});