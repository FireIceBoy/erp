<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品入库</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="DateTimePicker/jquery.datetimepicker.css"/>
<script type="text/javascript" src="js/jquery.js" ></script>
<script src="DateTimePicker/jquery.js"></script>
<script src="DateTimePicker/jquery.datetimepicker.js"></script>

</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#" onclick="history.back()">入库管理</a></li>
		    <li><a href="#">商品入库</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    	<form id="for">
		    <li><label>供应商全称</label>
		    	<select name="provider.pid" id="pid" class="dfinput">
		    		<option value="">点击选择进货供应商</option>
		    		<c:forEach items="${providerList }" var="sn">
		    			<option value="${sn.pid}">${sn.providername }</option>
		    		</c:forEach>
		    	</select>
		    </li>
		    <li><label>商品名称</label>
		    	<select name="goods.gid" id="gid" class="dfinput">
		    	</select>
		    </li>
		    <!-- <li><label>操作员</label><input name="operateperson"  type="text" class="dfinput" /></li> -->
		    <li><label>进货时间</label><input name="inporttime" id="inporttime"  type="text" class="dfinput" /></li>
		    <li><label>数量</label><input name="number"  type="text" class="dfinput" /></li>
		    <li><label>支付类型</label><cite>
		    	<input name="paytype" type="radio" value="1" />支付宝&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input name="paytype" type="radio" value="2" />微信&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input name="paytype" type="radio" value="3" />现金
		    	</cite></li>
		    <li><label>注释</label><input name="comment" type="text" class="dfinput" /></li>
		    <li><label>&nbsp;</label><input type="button" class="btn" value="提交" id="sub"/></li>
    	</form>
    </ul>
    </div>

</body>
<script type="text/javascript">
	$("#gid").append("<option value=''>请选择供应商</option>");
	//当选择供应商后,返回该供应商的商品集合,并处理为下拉框
	$("#pid").blur(function(){
		$("#gid").empty();
		$("#gid").append("<option value=''>点击选择商品名称</option>");
		var pid = $(this).val();
		$.post("goodsName_query.action",{'pid': pid},function(data){
			var goodsList = data.list;
			for(var i = 0; i<goodsList.length; i++){
				var code = "<option value="+goodsList[i].gid +">"+goodsList[i].goodsname+"</option>";
				$("#gid").append(code);
			}
		});
	});
	
	//初始化时间选择器
	$('#inporttime').datetimepicker({
		lang:'ch',
		timepicker:false,
		format:'Y-m-d',
	});
	
	//提交
	$("#sub").click(function(){
		$.post("inport_add.action",	
			$("#for").serialize(),
			function(){//请求完成
				if(confirm("是否继续添加?")){
					window.location.href="inport_toAdd.action";
				}else{
					window.location.href="inport_query.action";
				}
			 }
		);
	});
</script>
</html>
