$(function(){
    var showItem2 = function(){
        var low = $("input#low_price").val();
        if(isNaN(low) || low<=0 || low === ""){
            low = 0
        }
        var high = $("input#high_price").val();
        if(isNaN(high) || high===""){
            high =  Number.MAX_VALUE;
        }
        $("div.border").show();
        $("div.border").each(function(){
            var price = $(this).attr("price");
            price = Number(price);
            if(price<low || price>high){
                $(this).hide();
            }
        });
    };
    $("input").keyup(showItem2);
});