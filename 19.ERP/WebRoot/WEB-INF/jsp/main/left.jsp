<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(function() {
				//导航切换
				$(".menuson .header").click(function() {
					var $parent = $(this).parent();
					$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();

					$parent.addClass("active");
					if(!!$(this).next('.sub-menus').size()) {
						if($parent.hasClass("open")) {
							$parent.removeClass("open").find('.sub-menus').hide();
						} else {
							$parent.addClass("open").find('.sub-menus').show();
						}

					}
				});

				// 三级菜单点击
				$('.sub-menus li').click(function(e) {
					$(".sub-menus li.active").removeClass("active")
					$(this).addClass("active");
				});

				$('.title').click(function() {
					var $ul = $(this).next('ul');
					$('dd').find('.menuson').slideUp();
					if($ul.is(':visible')) {
						$(this).next('.menuson').slideUp();
					} else {
						$(this).next('.menuson').slideDown();
					}
				});
			});
		</script>
	</head>

	<body style="background:#f0f9fd;">
		<div class="lefttop"><span></span>导航菜单</div>

		<dl class="leftmenu">
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /></span>基本管理
				</div>
				<ul class="menuson">

					<li class="active">
						<div class="header">
							<cite></cite>
							<a href="customer_query.action" target="bottomFrame">客户管理</a>
							<i></i>
						</div>
					</li>

					<li>
						<div class="header">
							<cite></cite>
							<a href="provider_query.action" target="bottomFrame">供应商管理</a>
							<i></i>
						</div>
					</li>

					<li>
						<div class="header"><cite></cite>
							<a href="goods_query.action" target="bottomFrame">商品管理</a><i></i></div>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" /></span>入库管理
				</div>
				<ul class="menuson">
					<li>
						<div class="header"><cite></cite>
							<a href="inport_query.action" target="bottomFrame">入库记录</a><i></i></div>
					</li>
					<li>
						<div class="header"><cite></cite>
							<a href="outport_query.action" target="bottomFrame">退货记录</a><i></i></div>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title"><span><img src="images/leftico03.png" /></span>出库管理</div>
				<ul class="menuson">
					<li>
						<div class="header"><cite></cite>
							<a href="sales_query.action" target="bottomFrame" >销售记录</a><i></i></div>
					</li>
					<li>
						<div class="header"><cite></cite>
							<a href="salesBack_query.action" target="bottomFrame">销售退货</a><i></i></div>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title"><span><img src="images/leftico04.png" /></span>系统管理</div>
				<ul class="menuson">
					<li>
						<div class="header"><cite></cite>
							<a href="operator_toUpdate.action" target="bottomFrame">密码修改</a><i></i></div>
					</li>
				</ul>

			</dd>
			<dd>
				<div class="title"><span><img src="images/t04.png" width="16" height="16" /></span>统计分析</div>
				<ul class="menuson">
					<li>
						<div class="header"><cite></cite>
							<a href="admin_inport.action" target="bottomFrame">入库统计</a><i></i></div>
					</li>
					<li>
						<div class="header"><cite></cite>
							<a href="admin_outport.action" target="bottomFrame">供应商退货统计</a><i></i></div>
					</li>
					<li>
						<div class="header"><cite></cite>
							<a href="#">销售统计</a><i></i></div>
					</li>
					<li>
						<div class="header"><cite></cite>
							<a href="#">销售退货统计</a><i></i></div>
					</li>
				</ul>

			</dd>
		</dl>
	</body>

</html>