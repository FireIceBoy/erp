<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>商品进货记录</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="DateTimePicker/jquery.datetimepicker.css"/>
<script src="DateTimePicker/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script src="DateTimePicker/jquery.datetimepicker.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	  $(".click").click(function(){
	  	$(".tip").fadeIn(200);
	  });
	  
	  $(".tiptop a").click(function(){
	  	$(".tip").fadeOut(200);
	  });
	
	  $(".sure").click(function(){
	  	$(".tip").fadeOut(100);
	  });
	
	  $(".cancel").click(function(){
	  	$(".tip").fadeOut(100);
	  });
	  
	});
</script>


</head>


<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="admin_index.action">首页</a></li>
    <li><a href="#">入库管理</a></li>
    <li><a href="#">进货记录</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools">
    	<ul class="toolbar">
	      <a href="inport_toAdd.action">  <li class="click"><span><img src="images/t01.png" /></span>商品入库</li></a>
        </ul>
        <div align="center">
          <form id="for">
	        <ul class="seachform1">
			    <li><input name="keywords" id="keywords" value="${inportVo.keywords }" type="text" class="scinput1" placeholder="供应商/操作员/商品名称" /></li>
			    <li>
			    	<div class="vocation" align="left">
			    	<input name="begintime" id="beginTime" value="${inportVo.begintime }" type="text" class="scinput1" placeholder="起始时间"/>
			    	</div>
			    </li>
			    <li><input name="endtime" id="endTime" value="${inportVo.endtime }" type="text" class="scinput1" placeholder="截止时间" /></li>
			    <li><input name="" type="button" class="scbtn" id="sub" onclick="changePage(1)" value="查询"/></li>  
		    </ul>
		   </form>
        </div>
    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th>编号</th>
	        <th>供应商全称</th>
	        <th>商品名称</th>
	        <th>操作员</th>
	        <th>支付类型</th>
	        <th>进货时间</th>
	        <th>数量</th>
	        <th>注释</th>
	        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
        	<c:when test="${empty list}">
        		<tr align="center"><td colspan="50">未查询到数据</td> </tr>
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${list }" var="sn">
        			 <tr>
				        <td>${sn.id }</td>
				        <td>${sn.provider.providername }</td>
				        <td>${sn.goods.goodsname }</td>
				        <td>${sn.operateperson }</td>
				        <td>
							<c:choose>
								<c:when test="${sn.paytype ==1 }">微信</c:when>
								<c:when test="${sn.paytype ==2 }">支付宝</c:when>
								<c:otherwise>银行</c:otherwise>
							</c:choose> 
						</td>
				        <%-- <td><fmt:formatDate value="${sn.inporttime}" pattern="yyyy-MM-dd HH:mm" /></td> --%>
				        <td>${sn.inporttime}</td>
				        <td>${sn.number }</td>
				        <td>${sn.comment }</td>
				        <td>
				        	<a href="outport_toAdd.action?outportId=${sn.id }" class="tablelink"> 退货</a>&nbsp&nbsp&nbsp&nbsp&nbsp
				        	<a href="inport_del.action?id=${sn.id }" class="tablelink"> 删除</a>
				        </td>
			        </tr> 
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
       </tbody>
    </table>
   
   <div class="pagin">
    	<div class="message">共<i class="blue">${pageBean.totalCount }</i>条记录，当前显示第&nbsp;<i class="blue">${pageBean.currentPage }&nbsp;</i>页</div>
        <ul class="paginList">
	        <li class="paginItem"><a href="javascript:void(0)" onclick="changePage(${pageBean.currentPage-1})"><span class="pagepre"></span></a></li>
	        <c:forEach begin="1" end="${pageBean.totalPage }" var="sn">
	      	  <li class="paginItem"><a href="javascript:void(0)" onclick="changePage(${sn })">${sn }</a></li>
	        </c:forEach>
	        <li class="paginItem"><a href="javascript:void(0)" onclick="changePage(${pageBean.currentPage+1})"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    </div>
    <script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		
		$('#beginTime').datetimepicker({
			lang:'ch',
			timepicker:false,
			format:'Y-m-d',
		});
		$('#endTime').datetimepicker({
			lang:'ch',
			timepicker:false,
			format:'Y-m-d',
		});
		
		function changePage(currentPage) {
			if(currentPage >= ${pageBean.totalPage }){
				currentPage = ${pageBean.totalPage }
			}
			var keywords = $("#keywords").val();
			var beginTime = $("#beginTime").val();
			var endTime = $("#endTime").val();
	        window.location.href="inport_query.action?pageBean.currentPage="+currentPage+"&keywords="+keywords+"&beginTime="+beginTime+"&endTime="+endTime;
	    }

	</script>

</body>

</html>
