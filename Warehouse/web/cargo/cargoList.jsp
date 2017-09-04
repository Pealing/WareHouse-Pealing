<%@ page import="java.util.List" %>
<%@ page import="com.entity.CargoEntity" %><%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/9/1
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/npm.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/Chkcargoname.js"></script>

    <title>管理员登录</title>
</head>
<body>
<jap:include value="../components/banner.jsp"/>
<s:action name="cargoList" namespace="/cargo"/>
    <div id="carboList" style="position: absolute;left: 12.5%;top: 24%;width: 75%;height: 43%;">
        <table id="cargoListTable" class="table table-striped">
            <tr>
                <td><strong>序号</strong></td>
                <td><strong>货物名称</strong></td>
                <td><strong>当前库存</strong></td>
                <td><strong>单价</strong></td>
                <td><strong>最小库存</strong></td>
                <td><strong>删除</strong></td>
                <td></td>
                <td></td>
            </tr>
            <%
                int index = 0;
                String s;
                List<?> cargoList = (List<?>) request.getAttribute("cargoList");
                if(cargoList == null)
                {
                    out.println("<tr><td colspan='7'  style=\"text-align: center;\"><strong>货物列表为空</strong></td></tr>");
                }
                else
                {
                    for(Object cargoObj : cargoList)
                    {
                        s = "" + (index++);
                        CargoEntity cargoEntity = (CargoEntity) cargoObj;
                        out.println("<form action=\"\" name=\"form1\">");
                        if(cargoEntity.getStock()<cargoEntity.getMinstock())
                        {
                            out.println("<tr class=\"danger\">");
                        }
                        else
                        {
                            out.println("<tr>");
                        }
                        out.println("<td>" + s + "</td>");
                        out.println("<td>" + cargoEntity.getName() + "</td>");
                        out.println("<input type=\'text\' name=\'cargoname\' value=\'" + cargoEntity.getName() + "\' style=\"display:none\" />");
                        out.println("<td>" + cargoEntity.getStock() + "</td>");
                        out.println("<td>" + cargoEntity.getPrice() + "</td>");
                        out.println("<td>" + cargoEntity.getMinstock() + "</td>");
            %>
                        <td><button class="btn btn-danger" onclick="this.form.action='/cargo/CargoDelete';this.form.submit();">删除</button></td>
                        <td><input style="width: 50%;" type="text" name="newprice"/><button style="margin-left: 3%;" class="btn btn-warning" onclick="this.form .action='<s:url namespace="/cargo" action="setPrice"/>';this.form.submit();">修改单价</button></td>
                        <td><input style="width: 50%;" type="text" name="newminstock"/><button style="margin-left: 3%;" class="btn btn-warning" onclick="this.form.action='<s:url namespace="/cargo" action="setMinstock"/>';this.form.submit();">修改最小库存</button></td>
            <%
                        out.println("</tr>");
                        out.println("</form>");
                    }
                }
            %>
        </table>

        <form action="<s:url namespace="/cargo" action="cargoCreate"/>" method="post">
            <table class="table table-bordered" style="margin-top: 10%">
                <tr>
                    <td><strong>货物名称</strong></td>
                    <td><strong>单价</strong></td>
                    <td><strong>当前库存</strong></td>
                    <td><strong>最小库存</strong></td>
                </tr>
                <tr>
                    <td>
                        <input id = "create_cargoname" name="name" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                               class="form-control input-block" tabindex="1" type="text"/>
                    </td>
                    <td>
                        <input id="create_cargoprice" name="price" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                               class="form-control input-block" tabindex="1" type="text" value="0"/>
                    </td>
                    <td>
                        <input id="create_cargostock" name="stock" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                               class="form-control input-block" xtabindex="1" type="text" value="0"/>
                    </td>
                    <td>
                        <input id="create_cargominstock" name="minstock" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                               class="form-control input-block" xtabindex="1" type="text" value="0"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="margin-top: 3%; color: palevioletred; font-size: 15px;"
                             id="CheckName"></div>
                    </td>
                    <td colspan="3">
                        <input id = "create_cargoSubmit" class="btn btn-primary btn-block" data-disable-with="Signing in…" name="commit" tabindex="3"
                               type="submit" value="添加货物" disabled="true" style="margin:auto 33.3%;width: 33.3%;"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>


</body>
</html>
