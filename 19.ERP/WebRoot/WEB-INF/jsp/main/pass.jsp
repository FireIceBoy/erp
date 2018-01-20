<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
<link rel="stylesheet" type="text/css" href="css/pintuer.css">
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/pintuer.js" ></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="" id="for">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号:</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
           ${operator.username}
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <label><input type="password" class="input w50" id="mpass" name=""  size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" /></label>     
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" id="passTwo"  class="input w50" name="password" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
        	
          <button class="button bg-main icon-check-square-o" type="button" id="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>

</body>
<script type="text/javascript">

	// 原始密码
	var oldPass = ${operator.password}
	// 输入的原始密码
	
	//var old = document.getElementById("mpass").value
	// 确认的新密码
	var passTwo = $("#passTwo").val();
	
	
	
	
	var isok = false;
	$("#mpass").blur(function() {
		var oldPassInput = $("#mpass").val();
		if (oldPass == oldPassInput) {
			// alert();
			isok = true;
		}
	});
	
		$("#submit").click(function() {
			if (isok) {
				$.post("operator_update.action",$("#for").serialize(),
						function() {
						// 请求完成
						window.location.href="operator_jump.action";
				});
			 
			} else {
				alert("原始密码输入不正确");
			}
		});
	
</script>
</html>