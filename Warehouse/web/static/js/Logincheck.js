/**
 * Created by Pealing on 2017/9/1.
 */
$(document).ready(function ($) {

    $('#login_username').blur(function () {
        var a = $(this).val();
        if(a != "cpx")
        {
            var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>用户名错误</label>');
            $("#CheckUser").append(x);
            $("#login_submit").attr('disabled', true);
        }
        else {
            $("#login_submit").attr('disabled', false);
        }
    })
    $("#login_username").focus(function () {
        $("#CheckUser").empty();
    });
});
