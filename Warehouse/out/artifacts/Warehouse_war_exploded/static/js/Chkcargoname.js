/**
 * Created by Pealing on 2017/5/29.
 */
$(document).ready(function ($) {
    //登录时判断用户名是否存在
    $('#create_cargoname').blur(function () {
        var a = $(this).val();
        if (a == "")
            return;
        $.ajax({
            url: '/cargo/checkCargoname',
            type: 'get',
            data: {cargoname: a},
            dataType: 'json',
            success: function (data, result) {
                if (data) {
                    var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>该货物已经存在，请勿重复创建</label>');
                    $("#CheckName").append(x);
                    $("#create_cargoSubmit").attr('disabled', true);
                }
                else {
                    $("#create_cargoSubmit").attr('disabled', false);
                }
            }
        });
    });

    $('#create_cargoprice').blur(function ()
    {
        var a = $(this).val();
        if(isNaN(a))
        {
            var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>请输入整数</label>');
            $("#CheckName").append(x);
            $("#create_cargoSubmit").attr('disabled', true);
        }
        else {
            $("#create_cargoSubmit").attr('disabled', false);
        }
    });

    $('#create_cargostock').blur(function ()
    {
        var a = $(this).val();
        if(isNaN(a))
        {
            var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>请输入整数</label>');
            $("#CheckName").append(x);
            $("#create_cargoSubmit").attr('disabled', true);
        }
        else {
            $("#create_cargoSubmit").attr('disabled', false);
        }
    });
    $('#create_cargominstock').blur(function ()
    {
        var a = $(this).val();
        if(isNaN(a))
        {
            var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>请输入整数</label>');
            $("#CheckName").append(x);
            $("#create_cargoSubmit").attr('disabled', true);
        }
        else {
            $("#create_cargoSubmit").attr('disabled', false);
        }
    });
    $("#create_cargoname").focus(function () {
        $("#CheckName").empty();
    });
    $("#create_cargoprice").focus(function () {
        $("#CheckName").empty();
    });
    $("#create_cargostock").focus(function () {
        $("#CheckName").empty();
    });
    $("#create_cargominstock").focus(function () {
        $("#CheckName").empty();
    });

});
