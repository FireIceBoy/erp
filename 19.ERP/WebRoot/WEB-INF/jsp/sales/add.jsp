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

<title>商品销售</title>
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
		    <li><a href="#">商品销售</a></li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    	<form id="for">
		    <li><label>商品信息</label>
		    	<select name="goods.gid" id="gid" class="dfinput">
		    		<option value="">点击选择商品</option>
		    		<c:forEach items="${goodsList }" var="sn">
		    			<option value=${sn.gid}>编号:${sn.gid }&nbsp;&nbsp;名称:${sn.goodsname}&nbsp;&nbsp;库存:${sn.number}</option>
		    		</c:forEach>
		    	</select>
		    </li>
		    <li><label>客户信息</label>
		    	<select name="customer.cid" id="cid" class="dfinput">
		    		<option value="">点击选择客户</option>
		    		<c:forEach items="${customerList }" var="sn">
		    			<option value=${sn.cid}>编号:${sn.cid }&nbsp;&nbsp;名称:${sn.customername }</option>
		    		</c:forEach>
		    	</select>
		    </li>
		    
		    
		    <!-- <li><label>操作员</label><input name="operateperson"  type="text" class="dfinput" /></li> -->
		    <li><label>销售时间</label><input name="salestime" id="salestime"  type="text" class="dfinput" /></li>
		    <li><label>销售数量</label><input name="number"  type="number" min=0 id="number"  class="dfinput" /></li>
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
 	
	

		// 选中时，得到商品数量
		var goodsNumber = "";
		$("#gid").blur(function() {
			var number = $("#gid").val(); // 编号
			$.post("goodsName_queryGoods.action",{'goodsVo.gid':number},function(data) {
				goodsNumber = data.goodsVo.number;
			});
		});
		
		var isok = false;
		// 处理销售数量
		$("#number").blur(function() {
			var va = $("#number").val();
			//alert(va);
			if (va <= 0 || va > goodsNumber ) {
				alert("请填写正确的销售数量");
			} else {
				isok = true;
			};
		});
	
	
	// 初始化时间选择器
	$('#salestime').datetimepicker({
		lang:'ch',
		timepicker:false,
		format:'Y-m-d',
	});
	
	
	
	//提交
		$("#sub").click(function(){
			if (isok) {
				$.post("sales_add.action",	
					$("#for").serialize(),
					function(){//请求完成
						if(confirm("是否继续添加?")){
							window.location.href="sales_toAdd.action";
						}else{
							window.location.href="sales_query.action";
						}
					 }
				);
			} else {
				alert("请填写正确的商品销售数量");
			}	
			});
			
</script>
</html>
