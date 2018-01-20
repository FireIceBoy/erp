<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加客户</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js" ></script>
<style type="text/css">
	#show1{
		display:inline-block;
	}
	#show2{
		display:inline-block;
		position: absolute ;
		margin-left: 20px;
	}
</style>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#" onclick="history.back()">客户管理</a></li>
		    <li><a href="#">添加客户</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    	<div class="formtitle"><span>基本信息</span></div>
    	<form id="for">
	    	<div id="show1">
			    <ul class="forminfo">
					    <li><label>客户全称</label><input name="customername"  type="text" class="dfinput" /></li>
					    <li><label>客户公司地址</label><input name="address"  type="text" class="dfinput" /></li>
					    <li><label>联系人</label><input name="connectionperson"  type="text" class="dfinput" /></li>
					    <li><label>开户银行</label><input name="bank" type="text" class="dfinput" /></li>
					    <li><label>联系人邮箱</label><input name="email" type="text" class="dfinput" /></li>
					    <li><label>状态</label><cite>
					    	<input name="available" type="radio" value="1" />可用&nbsp;&nbsp;&nbsp;&nbsp;
					    	<input name="available" type="radio" value="0" />不可用
					    	</cite></li>
					    <li><label>&nbsp;</label><input type="button" class="btn" value="提交" id="sub"/></li>
			    </ul>
		    </div>
		    <div id="show2">
		    	 <ul class="forminfo">
					    <li><label>客户邮编</label><input name="zip"  type="text" class="dfinput" /></li>
					    <li><label>客户公司电话</label><input name="telephone"  type="text" class="dfinput" /></li>
					    <li><label>联系人电话</label><input name="phone" type="text" class="dfinput" /></li>
					    <li><label>银行账号</label><input name="account" type="text" class="dfinput" /></li>
					    <li><label>公司传真</label><input name="fax" type="text" class="dfinput" /></li>
			    </ul>
		    </div>
	    </form>
    </div>
</body>
<script type="text/javascript">
	
	//提交
	$("#sub").click(function(){
		$.post("customer_add.action",	
			$("#for").serialize(),
			function(){//请求完成
				if(confirm("是否继续添加?")){
					window.location.href="customer_toAdd.action";
				}else{
					window.location.href="customer_query.action";
				}
			 }
		);
	});
</script>
</html>
