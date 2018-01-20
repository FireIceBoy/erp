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
<title>商品列表</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});
		
		$(document).ready(function(e) {
			$(".select3").uedSelect({
				width : 152
			});
		});

	});
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="admin_index.action">首页</a></li>
			<li><a href="#">商品管理</a></li>
			<li><a href="#">商品列表</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<a href="goods_toAdd.action">
					<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				</a>
			</ul>

			<div align="center">
				<form id="for">
					<ul class="seachform1">
						<li><input name="goodsname" id="goodsname"
							value="${goodsVo.goodsname}" type="text" class="scinput1"
							placeholder="按商品名称查找" /></li>
						<li><input name="produceplace" id="produceplace"
							value="${goodsVo.produceplace}" type="text" class="scinput1"
							placeholder="按商品产地查找" /></li>
						<li>
							<div class="vocation" align="left">
								<select class="select3" name="available" id="available">
									<option value="8">选择状态</option>
									<option value="1">在售</option>
									<option value="0">下架</option>
								</select>
							</div>
						</li>
						<li><input name="" type="button" class="scbtn" id="sub"
							onclick="changePage(1)" value="查询" /></li>
					</ul>
				</form>
			</div>

		</div>


		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
					<th>商品名称</th>
					<th>产地</th>
					<th>规格</th>
					<th>包装</th>
					<th>生产批号</th>
					<th>批准文号</th>
					<th>描述</th>
					<th>价格</th>
					<th>供应商编号</th>
					<th>供应商全称</th>
					<th>状态</th>
					<th>库存数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:choose>
					<c:when test="${empty list}">
						<tr align="center">
							<td colspan="50">未查询到数据</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list }" var="sn">
							<tr>
								<td><input name="" type="checkbox" value="" /></td>
								<td>${sn.gid }</td>
								<td>${sn.goodsname }</td>
								<td>${sn.produceplace }</td>
								<td>${sn.size }</td>
								<td>${sn.gpackage }</td>
								<td>${sn.productcode }</td>
								<td>${sn.promitcode }</td>
								<td>${sn.description }</td>
								<td>${sn.price }</td>
								<td>${sn.provider.pid }</td>
								<td>${sn.provider.providername }</td>


								<td><c:choose>
										<c:when test="${sn.available == 1}">在售</c:when>
										<c:otherwise>下架</c:otherwise>
									</c:choose></td>
								<td>${sn.number }</td>
								<td><a href="goods_toUpdate.action?gid=${sn.gid }"
									class="tablelink">修改</a> <a
									href="goods_del.action?gid=${sn.gid }" class="tablelink">
										删除</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>


			</tbody>
		</table>


		<div class="pagin">
			<div class="message">
				共<i class="blue">${pageBean.totalCount }</i>条记录，当前显示第&nbsp;<i
					class="blue">${pageBean.currentPage }&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:void(0)"
					onclick="changePage(${pageBean.currentPage-1})"><span
						class="pagepre"></span></a></li>
				<c:forEach begin="1" end="${pageBean.totalPage }" var="sn">
					<li class="paginItem"><a href="javascript:void(0)"
						onclick="changePage(${sn })">${sn }</a></li>
				</c:forEach>
				<li class="paginItem"><a href="javascript:void(0)"
					onclick="changePage(${pageBean.currentPage+1})"><span class="pagenxt"></span></a></li>
        </ul>
    </div>

    </div>
    
    <script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		
		function changePage(currentPage) {
			
			if(currentPage >= ${pageBean.totalPage }){
				currentPage = ${pageBean.totalPage };
			}
		
	        var goodsname=$("#goodsname").val();
			var produceplace=$("#produceplace").val();
			var available=$("#available").val();
	        window.location.href="goods_query.action?goodsname="+goodsname+"&produceplace="+produceplace+"&available="+available+"&pageBean.currentPage="+currentPage;
	    }
	</script>

</body>

</html>
