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
<title>销售退货</title>
<link rel="stylesheet" type="text/css" href="DateTimePicker/jquery.datetimepicker.css"/>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js" ></script>
<script src="DateTimePicker/jquery.js"></script>
<script src="DateTimePicker/jquery.datetimepicker.js"></script>

</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#" onclick="history.back()">出库管理</a></li>
		    <li><a href="#">销售退货</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    	<form id="for">
    		<input type="hidden" name="salesVo.id" value="${salesVo.id }">
	    	<input type="hidden" name="salesVo.goods.gid" value="${salesVo.goods.gid}">
		    <li><label>客户全称</label><label>${salesVo.customer.customername }</label></li>
		    <li><label>商品名称</label><label>${salesVo.goods.goodsname }</label></li>
		    
		    <!-- <li><label>操作员</label><input name="operateperson"  type="text" class="dfinput" /></li> -->
		    <li><label>退货时间</label><input name="salesbacktime" id="salesbacktime"  type="text" class="dfinput" /></li>
		    <li><label>退货数量</label><input name="number" id="number"  type="text" class="dfinput" placeholder="最大退货数量为${salesVo.number }"/><span id="prompt"></span></li>
		    <li><label>客户支付类型</label><cite>
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
 	
	
	
	//处理退货数量
	var isok = false;
	$("#number").blur(function(){
	var number = $(this).val();
	if(number > ${salesVo.number }){
		$("#prompt").append("<font color='#ff0033'>最大退货数量不得超过"+${salesVo.number }+"</font>");
		isok = false;
	}else{
		$("#prompt").empty();
		isok=true;
	}
	})
	
	
	// 初始化时间选择器
	$('#salesbacktime').datetimepicker({
		lang:'ch',
		timepicker:false,
		format:'Y-m-d',
	});
	
	
	
	//提交
		$("#sub").click(function(){
		if(isok){
			$.post("salesBack_add.action",	
				$("#for").serialize(),
				function(){//请求完成
						window.location.href="salesBack_query.action";
				}
			);
		}
	});
			
</script>
</html>
