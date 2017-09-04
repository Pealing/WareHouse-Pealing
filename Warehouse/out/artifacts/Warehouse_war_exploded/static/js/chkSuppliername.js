/**
 * Created by Pealing on 2017/9/3.
 */
$(document).ready(function ($) {
    //登录时判断用户名是否存在
    $('#create_suppliername').blur(function () {
        var a = $(this).val();
        if (a == "")
            return;
        $.ajax({
            url: '/supplier/ChkSupplierName',
            type: 'get',
            data: {suppliername: a},
            dataType: 'json',
            success: function (data, result) {
                if (data) {
                    var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>该供货商已经存在，请勿重复创建</label>');
                    $("#CheckName").append(x);
                    $("#create_supplierSubmit").attr('disabled', true);
                }
                else {
                    $("#create_supplierSubmit").attr('disabled', false);
                }
            },
            error:function () {
                alert("error");
            }
        });
    });


    $("#create_suppliername").focus(function () {
        $("#CheckName").empty();
    });

    $('#supplier_setphone').click(function () {
        var a = $('#supplier_phone').val()
        if(a == "")
        {
            alert("请输入正确内容");
        }
        else
        {
            this.form .action='/supplier/supplierSetPhone';
            this.form.submit();
        }
    });

    function setremarks() {
        var a = $('#supplier_remarks').val()
        if(a == "")
        {
            alert("请输入正确内容");
        }
        else
        {
            this.form .action='/supplier/supplierSetRemarks';
            this.form.submit();
        }
    };


});
