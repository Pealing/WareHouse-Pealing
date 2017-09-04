/**
 * Created by Pealing on 2017/5/29.
 */
$(document).ready(function ($) {
    $('#setSubmit').click(function () {
        var a = $('#setTotalFirst').val();
        var b = $('#setTotalSecond').val();
        var c = $('#setTotalThird').val();
        var d = $('#setDiscountFirst').val();
        var e = $('#setDiscountSecond').val();
        var f = $('#setDiscountThird').val();

        if(isNaN(a) || isNaN(b) || isNaN(c) || isNaN(d) || isNaN(e) || isNaN(f) || a== ""　|| b==""||c==""||d==""||e==""||f=="" ||d>1 || e>1|| f>1)
        {
            if(d>1 || e>1|| f>1)
            {
                alert("折扣请勿大于1");
            }
            else
            {
                alert("请输入数字");
            }
        }
        else
        {
            $('#setSettingForm').submit();
        }
    });


    //创建时判断客户是否存在
    $('#create_customername').blur(function () {
        var a = $(this).val();
        if (a == "")
            return;
        $.ajax({
            url: '/customer/ChkCustomerName',
            type: 'get',
            data: {customername: a},
            dataType: 'json',
            success: function (data, result) {
                if (data) {
                    var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>该客户已经存在，请勿重复创建</label>');
                    $("#CheckName").append(x);
                    $("#create_customerSubmit").attr('disabled', true);
                }
                else {
                    $("#create_customerSubmit").attr('disabled', false);
                }
            },
            error:function () {
                alert("error");
            }
        });
    });

    $('#create_yearTotal').blur(function ()
    {
        var a = $(this).val();
        if(isNaN(a))
        {
            var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>请正确输入</label>');
            $("#CheckName").append(x);
            $("#create_customerSubmit").attr('disabled', true);
        }
        else {
            $("#create_customerSubmit").attr('disabled', false);
        }
    });


    $("#create_customername").focus(function () {
        $("#CheckName").empty();
    });
    $("#create_yearTotal").focus(function () {
        $("#CheckName").empty();
    });

    $('#customer_setlevel').click(function () {
        var a = $('#customer_level').val()
        if(isNaN(a) || a > 3 || a == "")
        {
            alert("请输入正确客户等级");
        }
        else
        {
            this.form .action='/customer/setLevel';
            this.form.submit();
        }
    });

    $('#customer_setphone').click(function () {
        var a = $('#customer_phone').val()
        if(a == "")
        {
            alert("请输入正确内容");
        }
        else
        {
            this.form .action='/customer/setPhone';
            this.form.submit();
        }
    });

});
