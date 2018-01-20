<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改供应商</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js" ></script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">供应商管理</a></li>
		    <li><a href="#">修改供应商</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    	<form id="for">
    		<input type="hidden" name="pid"  value="${providerVo.pid }">
		    <li><label>供应商全称</label><input name="providername" value="${providerVo.providername }" type="text" class="dfinput" /></li>
		    <li><label>供应商邮编</label><input name="zip" value="${providerVo.zip }" type="text" class="dfinput" /></li>
		    <li><label>公司地址</label><input name="address" value="${providerVo.address }" type="text" class="dfinput" /></li>
		    <li><label>公司电话</label><input name="telephone" value="${providerVo.telephone }" type="text" class="dfinput" /></li>
		    <li><label>联系人</label><input name="connectionperson" value="${providerVo.connectionperson }" type="text" class="dfinput" /></li>
		    <li><label>联系人电话</label><input name="phone" value="${providerVo.phone }" type="text" class="dfinput" /></li>
		    <li><label>开户银行</label><input name="bank" value="${providerVo.bank }" type="text" class="dfinput" /></li>
		    <li><label>银行账号</label><input name="account" value="${providerVo.account }" type="text" class="dfinput" /></li>
		    <li><label>联系人邮箱</label><input name="email" value="${providerVo.email }" type="text" class="dfinput" /></li>
		    <li><label>公司传真</label><input name="fax" value="${providerVo.fax }" type="text" class="dfinput" /></li>
		    <li><label>状态</label><cite>
		    	<input name="available" type="radio" value="1" />可用&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input name="available" type="radio" value="0" />不可用
		    	</cite></li>
		    <li><label>&nbsp;</label><input type="button" class="btn" value="确认保存" id="sub"/></li>
    	</form>
    </ul>
    </div>
</body>
<script type="text/javascript">
	//处理状态
	var ava = document.getElementsByName("available");
	var val = ${providerVo.available};
	for(var i=0;i<ava.length;i++){
		if(val==ava[i].value){
			ava[i].setAttribute("checked",true);
		}
	}
	
	//提交
	$("#sub").click(function(){
		$.post("provider_update.action",	
			$("#for").serialize(),
			function(){//请求完成
				window.location.href="provider_query.action";
			 }
		);
	});
</script>
</html>
