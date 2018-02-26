$(function () {
    var stock = $("#inventory").attr("stock");
    $("#button-1").click(function () {
        $(this).addClass("selected");
        $("#button-2").removeClass("selected");
        $("#main-2").hide();
        $("#main-1").show();
    });
    $("#button-2").click(function () {
        $(this).addClass("selected");
        $("#button-1").removeClass("selected");
        $("#main-1").hide();
        $("#main-2").show();
    });
    $("#buy-button").click(function () {
        var page= "checkLogin";
        $.get(page,function (result) {
            if(result === "success"){
                var num = $("#buy-number").val();
                location.href= $("#buy-link").attr("href")+"&num="+num;
            }else{
                $("#loginModal").modal('show');
            }
        });
        return false;
    });
    $("#cart-button").click(function () {
        var page= "checkLogin";
        $.get(page,function (result) {
            if(result === "success"){
                var num = $("#buy-number").val();
                var cartLink = $("#cart-link").attr("href")+"&num="+num;
                $.get(cartLink,function (result) {
                    if(result === "success"){
                        $("#cart-button").text("已加入购物车");
                        $("#cart-button").attr("disabled","disabled");
                        $("#cart-button").css({"background":"lightgray","border-color":"lightgray","color":"black"});
                        return true;
                    }
                    if(result==="OutOfStock"){
                        alert("库存不足");
                        return false;
                    }
                    alert("添加购物车失败，可能是后台出错了");
                    return false;

                });

            }else{
                $("#loginModal").modal('show');
            }
        });
        return false;
    });
    $("img.sm-image").mouseenter(function () {
        var bigImage = $(this).attr("big-image");
        $("#big-show").attr("src", bigImage);
        $("img.sm-image").removeClass("selected");
        $(this).addClass("selected")
    });
    $("#buy-number").keyup(function(){
        var num = $(this).val();
        num = parseInt(num);
        if(isNaN(num) || num<=0 ){
            num = 1;
        }else if(num>stock){
            num = stock;
        }
        $(this).val(num);
    });
    $("#decrease-number").click(function(){
        var num = Number($("#buy-number").val());
        if(num>1){
            $("#buy-number").val(num-1);
        }
    });
    $("#increase-number").click(function(){
        var num = Number($("#buy-number").val());
        if(num<stock){
            $("#buy-number").val(num+1);
        }
    });
});