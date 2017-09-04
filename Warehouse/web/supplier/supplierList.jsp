<%@ page import="java.util.List" %>
<%@ page import="com.entity.SupplierEntity" %><%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/9/3
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <script src="${pageContext.request.contextPath}/static/js/chkSuppliername.js"></script>

    <title>供货商列表</title>
</head>
<body>
<jap:include value="../components/banner.jsp"/>
<s:action name="supplierList" namespace="/supplier"/>
<div id="carboList" style="position: absolute;left: 12.5%;top: 24%;width: 75%;height: 43%;">
    <table id="cargoListTable" class="table table-striped">
        <tr>
            <td><strong>序号</strong></td>
            <td><strong>供货商名称</strong></td>
            <td><strong>供货商电话</strong></td>
            <td><strong>备注</strong></td>
            <td><strong>删除</strong></td>
            <td></td>
            <td></td>
        </tr>
        <%
            int index = 0;
            String s;
            List<?> supplierList = (List<?>) request.getAttribute("supplierList");
            if(supplierList == null)
            {
                out.println("<tr><td colspan='7'  style=\"text-align: center;\"><strong>供货商列表为空</strong></td></tr>");
            }
            else
            {
                for(Object supplierObj : supplierList)
                {
                    s = "" + (index++);
                    SupplierEntity supplierEntity = (SupplierEntity) supplierObj;
                    out.println("<form action=\"\" name=\"form1\">");
                    out.println("<tr>");
                    out.println("<td>" + s + "</td>");
                    out.println("<td>" + supplierEntity.getName() + "</td>");
                    out.println("<input type=\'text\' name=\'suppliername\' value=\'" + supplierEntity.getName() + "\' style=\"display:none\" />");
                    out.println("<td>" + supplierEntity.getPhone() + "</td>");
                    out.println("<td>" + supplierEntity.getRemarks() + "</td>");
        %>
        <td><button class="btn btn-danger" onclick="this.form.action='/supplier/supplierDelete';this.form.submit();">删除</button></td>
        <%
                    out.println("<td><input style=\"width: 50%;\" type=\"text\" name=\"newphone\" value=\"" + supplierEntity.getPhone() + "\"/><button style=\"margin-left: 3%;\" class=\"btn btn-warning\" onclick=\"this.form.action='/supplier/supplierSetPhone';this.form.submit();\">修改电话</button></td>\n");
                    out.println("<td><input style=\"width: 50%;\" type=\"text\" name=\"newremarks\" value=\"" + supplierEntity.getRemarks() + "\"/><button style=\"margin-left: 3%;\" class=\"btn btn-warning\" onclick=\"this.form.action='/supplier/supplierSetRemarks';this.form.submit();\">提交备注</button></td>\n");
                    out.println("</tr>");
                    out.println("</form>");
                }
            }
        %>
    </table>

    <form action="<s:url namespace="/supplier" action="supplierCreate"/>" method="post">
        <table class="table table-bordered" style="margin-top: 10%">
            <tr>
                <td><strong>供货商名称</strong></td>
                <td><strong>电话</strong></td>
                <td><strong>备注</strong></td>
            </tr>
            <tr>
                <td>
                    <input id = "create_suppliername" name="name" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                           class="form-control input-block" tabindex="1" type="text"/>
                </td>
                <td>
                    <input id="create_supplierphone" name="phone" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                           class="form-control input-block" tabindex="1" type="text" />
                </td>
                <td>
                    <input id="create_supplierremark" name="remarks" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                           class="form-control input-block" xtabindex="1" type="text" value="无"/>
                </td>
            </tr>
            <tr>
                <td>
                    <div style="margin-top: 3%; color: palevioletred; font-size: 15px;"
                         id="CheckName"></div>
                </td>
                <td colspan="2">
                    <input id = "create_supplierSubmit" class="btn btn-primary btn-block" data-disable-with="Signing in…" name="commit" tabindex="3"
                           type="submit" value="添加供货商" disabled="true" style="margin:auto 25%;width: 50%;"/>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
