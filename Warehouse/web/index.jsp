<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/8/16
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <script src="static/js/jquery-1.10.2.min.js" type="text/javascript"></script>

  <!-- Bootstrap -->
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <script src="static/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="static/js/npm.js" type="text/javascript"></script>

  <script type="text/javascript" src="static/js/Logincheck.js"></script>

  <title>管理员登录</title>
</head>
<body>
<s:include value="/components/banner.jsp"/>
<div id="background" style="position:absolute; width: 100%;height: 100%;background-color: #E4E4E4; left: 0;top:0;">
  <nav>
    <div id="logo" style="position: absolute;left: 47.5%;top: 12%;width: 5%;height: 10%;border-radius: 5px;">
      <img src="${pageContext.request.contextPath}/static/image/shu.jpg" width="100%" height="100%"
           style="border-radius: 30px;">
    </div>
    <div id="logo_word" style="position: absolute;left: 37.5%;top: 22%;width: 25%;height: 10%;text-align: center;">
      <p class="create-account-callout mt-3" style="margin: 4% 5%;font-size: 25px;color: #6E6E6E">
        Warehouse Management
      </p>
    </div>
  </nav>

  <div id="concent" style="position: absolute;left: 37.5%;top: 34%;width: 25%;height: 43%;">
    <form id="form_login" action="<s:url namespace="/cargo" action="Login"/>" method="post">
      <div style="background-color: white; border-radius: 10px;border: 1px solid #C9C9C9">
        <label style="margin: 10%  10%  3%;">
          Username
        </label>
        <input name="username" autocapitalize="off" autocorrect="off" autofocus="autofocus"
               class="form-control input-block" id="login_username" tabindex="1" type="text"
               style="margin:0 10%;width: 80%;"/>
        <div style="margin-left:10%; margin-top: 2%; color: palevioletred; font-size: 15px;"
             id="CheckUser"></div>
        <label style="margin: 5%  10% 3%;">
          Password
          <a href="password-reset.jsp" class="label-link" style="margin-left: 60px;">Forgot password?</a>
        </label>
        <input name="password" class="form-control form-control input-block" id="login_password" tabindex="2"
               type="password" style="margin:0 10%;width: 80%;"/>

        <input class="btn btn-primary btn-block" data-disable-with="Signing in…" name="commit" tabindex="3"
               type="submit" value="Sign in" style="margin:5% 10%;width: 80%;"/>
      </div>
    </form>
    <div style="background-color: #E4E4E4;margin: 5% auto; height: 18%;border-radius: 10px;border: 1px solid #C9C9C9;text-align: center;">
      <p class="create-account-callout mt-3" style="margin: 4% 5%">
        This site is set up by Pealing.
      </p>
    </div>
  </div>
</div>
</body>
</html>
