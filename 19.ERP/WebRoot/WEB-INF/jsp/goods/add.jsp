<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
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
			<li><a href="#" onclick="history.back()">商品管理</a></li>
			<li><a href="#">添加商品</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<form id="for">
			<div id="show1">
				<ul class="forminfo">
						<li><label>商品名称</label><input name="goodsname" type="text" class="dfinput" /></li>
						<li><label>规格</label><input name="size" type="text" class="dfinput" /></li>
						<li><label>生产批号</label><input name="productcode" type="text" class="dfinput" /></li>
						<li><label>描述</label><input name="description" type="text" class="dfinput" /></li>
						<li><label>供应商编号</label>
							<select name="provider.pid" class="dfinput">
								<c:forEach var="sn" items="${list2}">
									<option value="${sn.pid}">${sn.pid}</option>
								</c:forEach>
							</select>
						</li>
						<li><label>数量</label><input name="number" type="text" readonly="readonly" value="0"
							class="dfinput" /></li>
						<li><label>&nbsp;</label><input type="button" class="btn" value="提交" id="sub" /></li></li>
				</ul>
			</div>
			<div id="show2">
				<ul class="forminfo">
						<li><label>产地</label><input name="produceplace" type="text" class="dfinput" /></li>
						<li><label>包装</label><input name="gpackage" type="text" class="dfinput" /></li>
						<li><label>批准文号</label><input name="promitcode" type="text" class="dfinput" /></li>
						<li><label>价格</label><input name="price" type="text" class="dfinput" /></li>
						<li><label>状态</label><cite> 
						<input name="available" type="radio" value="1" />上架&nbsp;&nbsp;&nbsp;&nbsp; 
						<input name="available" type="radio" value="0" />下架
						</cite></li>
				</ul>
		    </div>
	    </form>
	</div>
</body>
<script type="text/javascript">
	//提交
	$("#sub").click(function() {
		$.post("goods_add.action", $("#for").serialize(), function() {//请求完成
			if (confirm("是否继续添加?")) {
				window.location.href = "goods_toAdd.action";
			} else {
				window.location.href = "goods_query.action";
			}
		});
	});
</script>
</html>
