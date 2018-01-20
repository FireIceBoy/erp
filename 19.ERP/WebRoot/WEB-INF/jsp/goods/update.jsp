<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改商品信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">商品管理</a></li>
			<li><a href="#">修改商品信息</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>

		<ul class="forminfo">
			<form id="for">
				<input type="hidden" name="gid" value="${goodsVo.gid }">
				<li><label>商品名称</label><input name="goodsname"
					value="${goodsVo.goodsname }" type="text" class="dfinput" /></li>
				<li><label>产地</label><input name="produceplace"
					value="${goodsVo.produceplace }" type="text" class="dfinput" /></li>
				<li><label>规格</label><input name="size"
					value="${goodsVo.size }" type="text" class="dfinput" /></li>
				<li><label>包装</label><input name="gpackage"
					value="${goodsVo.gpackage }" type="text" class="dfinput" /></li>
				<li><label>生产批号</label><input name="productcode"
					value="${goodsVo.productcode }" type="text" class="dfinput" /></li>
				<li><label>批准文号</label><input name="promitcode"
					value="${goodsVo.promitcode }" type="text" class="dfinput" /></li>
				<li><label>描述</label><input name="description"
					value="${goodsVo.description }" type="text" class="dfinput" /></li>
				<li><label>价格</label><input name="price"
					value="${goodsVo.price }" type="text" class="dfinput" /></li>
				<li><label>供应商编号</label><select name="provider.pid"
					class="dfinput">
						<c:forEach var="sn" items="${list2}">
							<option value="${sn.pid}">${sn.pid}</option>
						</c:forEach>
				</select></li>

				<li><label>状态</label><cite> <input name="available"
						type="radio" value="1" />可用&nbsp;&nbsp;&nbsp;&nbsp; <input
						name="available" type="radio" value="0" />不可用
				</cite></li>
				<li><label>&nbsp;</label><input type="button" class="btn"
					value="确认保存" id="sub" /></li>
			</form>
		</ul>
	</div>
</body>
<script type="text/javascript">
	//处理状态
	var ava = document.getElementsByName("available");
	var val = ${goodsVo.available};
	for (var i = 0; i < ava.length; i++) {
		if (val == ava[i].value) {
			ava[i].setAttribute("checked", true);
		}
	}

	//提交
	$("#sub").click(function() {
		$.post("goods_update.action", $("#for").serialize(), function() {//请求完成
			window.location.href = "goods_query.action";
		});
	});
</script>
</html>
