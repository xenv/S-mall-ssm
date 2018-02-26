function checkEmpty(form){
    var flag = true;
    $(form).find("input[type=text]").each(function () {
        var value = $(this).val();
        if(value.length===0){
            alert("表格不能为空");
            $(this).focus();
            flag = false;
            return flag;
        }
    });
    return flag;
}
$(function(){
    $("#add-form").submit(function () {
        if(!checkEmpty(this)){
            return false;
        }
    });
    $(".delete-button").click(function () {
        return !!confirm("确实删除？");
    });
    $(".detail-btn").click(function () {
       $(this).parents("tr").next().toggle();
    });
});
