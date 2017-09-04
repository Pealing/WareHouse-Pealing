<%@ page import="java.util.List" %>
<%@ page import="com.entity.CustomerEntity" %>
<%@ page import="com.entity.DiscountEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/9/3
  Time: 15:03
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

    <script src="${pageContext.request.contextPath}/static/js/Chkcustomername.js"></script>

    <title>客户列表</title>
</head>
<body>
<jap:include value="../components/banner.jsp"/>
<s:action name="customerList" namespace="/customer"/>
<s:action name="discountEntity" namespace="/discount"/>
<div id="carboList" style="position: absolute;left: 7.5%;top: 24%;width: 85%;height: 43%;">
    <form action="/discount/setSetting" name="setDiscouny" id="setSettingForm">
        <table class="table table-bordered">
            <tr>
                <td><strong>等级1</strong></td>
                <td><strong>等级2</strong></td>
                <td><strong>等级3</strong></td>
            </tr>
            <%
                DiscountEntity discountEntity = (DiscountEntity) request.getAttribute("discountEntity");
            %>
            <tr>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon">年消费金额</span>
                        <%
                            out.println("<input id=\'setTotalFirst\' type=\"text\" class=\"form-control\" name=\"TotalFirst\" value=\'" + Double.toString(discountEntity.getTotalFirst()) + "\'>");
                        %>
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon">年消费金额</span>
                        <%
                            out.println("<input id=\"setTotalSecond\" type=\"text\" class=\"form-control\" name=\"TotalSecond\" value=\"" + Double.toString(discountEntity.getTotalSecond()) + "\">\n");
                        %>
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon">年消费金额</span>
                        <%
                            out.println("<input id=\"setTotalThird\" type=\"text\" class=\"form-control\" name=\"TotalThird\" value=\"" + Double.toString(discountEntity.getTotalThird()) + "\">\n");
                        %>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon">折扣</span>
                        <%
                            out.println("<input id=\"setDiscountFirst\" type=\"text\" class=\"form-control\" name=\"DiscountFirst\" value=\"" + Double.toString(discountEntity.getDiscountFirst()) + "\">\n");
                        %>
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon">折扣</span>
                        <%
                            out.println("<input id=\"setDiscountSecond\" type=\"text\" class=\"form-control\" name=\"DiscountSecond\" value=\""+ Double.toString(discountEntity.getDiscountSecond())+"\">\n");
                        %>
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon">折扣</span>
                        <%
                            out.println("<input id=\"setDiscountThird\" type=\"text\" class=\"form-control\" name=\"DiscountThird\" value=\"" + Double.toString(discountEntity.getDiscountThird())+"\">\n");
                        %>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="button" id="setSubmit" class="btn btn-primary" style="margin: auto 33.3%;width: 30%;" value="更新设置"/>
                </td>
            </tr>
        </table>
    </form>
    <table id="cargoListTable" class="table table-hover">
        <tr>
            <td><strong>序号</strong></td>
            <td><strong>客户名称</strong></td>
            <td><strong>客户电话</strong></td>
            <td><strong>年消费金额</strong></td>
            <td><strong>客户等级</strong></td>
            <td><strong>删除</strong></td>
            <td></td>
            <td></td>
        </tr>
        <%
            int index = 0;
            String s;
            List<?> customerList = (List<?>) request.getAttribute("customerList");
            if(customerList == null)
            {
                out.println("<tr><td colspan='7'  style=\"text-align: center;\"><strong>客户列表为空</strong></td></tr>");
            }
            else
            {
                for(Object customerObj : customerList)
                {
                    s = "" + (index++);
                    CustomerEntity customerEntity = (CustomerEntity) customerObj;
                    out.println("<form action=\"\" name=\"form1\">");
                    out.println("<tr>");
                    out.println("<td>" + s + "</td>");
                    out.println("<td>" + customerEntity.getName() + "</td>");
                    out.println("<input type=\'text\' name=\'customername\' value=\'" + customerEntity.getName() + "\' style=\"display:none\" />");
                    out.println("<td>" + customerEntity.getPhone() + "</td>");
                    out.println("<td>" + customerEntity.getYearTotal() + "</td>");
                    if(customerEntity.getFirstlevel() != -1)
                    {
                        out.println("<td>" + customerEntity.getFirstlevel() + "</td>");
                    }
                    else
                    {
                        out.println("<td>" + customerEntity.getLevel1() + "</td>");
                    }
        %>
        <td><button class="btn btn-danger" onclick="this.form.action='/customer/customerDelete';this.form.submit();">删除</button></td>
        <td><input style="width: 50%;" type="text" name="newlevel"/><button style="margin-left: 3%;" class="btn btn-warning" onclick="this.form .action='<s:url namespace="/customer" action="setLevel"/>';this.form.submit();">修改等级</button></td>
        <%
                    out.println("<td><input style=\"width: 50%;\" type=\"text\" name=\"newphone\" value=\"" + customerEntity.getPhone() + "\"/><button style=\"margin-left: 3%;\" class=\"btn btn-warning\" onclick=\"this.form.action='/customer/setPhone';this.form.submit();\">修改电话</button></td>\n");
                    out.println("</tr>");
                    out.println("</form>");
                }
            }
        %>
    </table>

    <form action="<s:url namespace="/customer" action="customerCreate"/>" method="post">
        <table class="table table-bordered" style="margin-top: 10%">
            <tr>
                <td><strong>客户名称</strong></td>
                <td><strong>客户电话</strong></td>
                <td><strong>年消费金额</strong></td>
            </tr>
            <tr>
                <td>
                    <input id = "create_customername" name="name" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                           class="form-control input-block" tabindex="1" type="text"/>
                </td>
                <td>
                    <input id = "creat_cutomerphone" name="phone" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                           class="form-control input-block" tabindex="1" type="text"/>
                </td>
                <td>
                    <input id="create_yearTotal" name="yearTotal" autocapitalize="off" autocorrect="off" autofocus="autofocus"
                           class="form-control input-block" tabindex="1" type="text" value="0"/>
                </td>
            </tr>
            <tr>
                <td>
                    <div style="margin-top: 3%; color: palevioletred; font-size: 15px;"
                         id="CheckName"></div>
                </td>
                <td colspan="2">
                    <input id = "create_customerSubmit" class="btn btn-primary btn-block" data-disable-with="Signing in…" name="commit" tabindex="3"
                           type="submit" value="创建客户" disabled="true" style="margin:auto 33.3%;width: 33%;"/>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
