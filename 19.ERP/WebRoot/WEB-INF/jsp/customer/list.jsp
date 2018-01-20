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
<title>客户列表</title>
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
			<li><a href="#">客户管理</a></li>
			<li><a href="#">客户列表</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<a href="customer_toAdd.action">
					<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				</a>
			</ul>

			<div align="center">
				<form id="for">
					<ul class="seachform1">
						<li><input name="customername" id="customername"
							value="${customerVo.customername }" type="text" class="scinput1"
							placeholder="按客户全称查找" /></li>
						<li><input name="keywords" id="keywords"
							value="${customerVo.keywords }" type="text" class="scinput1"
							placeholder="按联系人或电话查找" /></li>
						<li>
							<div class="vocation" align="left">
								<select class="select3" name="available" id="available">
									<option value="8">选择状态</option>
									<option value="1">可用</option>
									<option value="0">不可用</option>
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
					<th>客户全称</th>
					<th>客户邮编</th>
					<th>客户公司地址</th>
					<th>客户公司电话</th>
					<th>联系人</th>
					<th>联系人电话</th>
					<th>开户银行</th>
					<th>银行账号</th>
					<th>联系人邮箱</th>
					<th>公司传真</th>
					<th>状态</th>
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
								<td>${sn.cid }</td>
								<td>${sn.customername }</td>
								<td>${sn.zip }</td>
								<td>${sn.address }</td>
								<td>${sn.telephone }</td>
								<td>${sn.connectionperson }</td>
								<td>${sn.phone }</td>
								<td>${sn.bank }</td>
								<td>${sn.account }</td>
								<td>${sn.email }</td>
								<td>${sn.fax }</td>
								<td><c:choose>
										<c:when test="${sn.available == 1}">可用</c:when>
										<c:otherwise>不可用</c:otherwise>
									</c:choose></td>
								<td><a href="customer_toUpdate.action?cid=${sn.cid }"
									class="tablelink">修改</a> <a
									href="customer_del.action?cid=${sn.cid }" class="tablelink">
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
		
	        var customername=$("#customername").val();
			var keywords=$("#keywords").val();
			var available=$("#available").val();
	        window.location.href="customer_query.action?pageBean.currentPage="+currentPage+"&customername="+customername+"&keywords="+keywords+"&available="+available;;
	    }
	</script>

</body>

</html>
