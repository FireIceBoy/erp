<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.5.2/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.5.2/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.2/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.2/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script> 
  </head>
  
  <body>
  	<div style="display:none;" id="_table">
		<table id="customerListTable" pagination=true page=1 pageSize=10 
			class="easyui-datagrid" url='' toolbar="#customerAdd" 
			data-options="fitColumns:true,singleSelect:true">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'identity',width:50">身份证号</th>   
		            <th data-options="field:'custname',width:50">姓名</th>   
		            <th data-options="field:'sex',width:50">性别</th>   
		            <th data-options="field:'address',width:50">住址</th>   
		            <th data-options="field:'phone',width:50">电话</th>   
		            <th data-options="field:'career',width:50">职位</th>   
		            <th data-options="field:'custpwd',width:50">密码</th>   
		        </tr>   
		    </thead>   
		</table>  
		<div id="customerAdd">
			<a id="toSaveCustomer" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>&nbsp; &nbsp; &nbsp;  
			<a id="updateCustomer" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>&nbsp; &nbsp; &nbsp; 
			<a id="deleteCustomer" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
		</div>
	</div>
	<div id="_form" style="width: 40%;margin-left: 50px;margin-top: 50px">
	   <form id="customerForm" style="margin-top: 20px;margin-left: 20px" method="post">
		    <div>   
		        <label>身份证:</label>&nbsp;&nbsp;&nbsp;&nbsp;    
		        <input class="easyui-textbox" id="identity" name="identity" style="width:50%">
		    </div><br>   
		    <div>   
		        <label>姓名:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
		        <input class="easyui-textbox" name="custname" style="width:50%">
		    </div><br>    
		    <div>   
		        <label>性别:</label>&nbsp; &nbsp;    
		        <span style="margin-left: 20px">
					<input name="sex" type="radio" value="男">男
					<input name="sex" type="radio" value="女">女
				</span>
		    </div><br>    
		    <div>   
		        <label>住址:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
				<input class="easyui-textbox" name="address" style="width:50%">
		    </div><br>    
		    <div>   
		        <label>联系电话:</label>   
				<input class="easyui-textbox" name="phone" style="width:50%">
		    </div><br>    
		    <div>   
		        <label>职业:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
				<input class="easyui-textbox" name="career" style="width:50%">
		    </div>
		    <div style="display: none;">   
		        <label>密码:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
				<input class="easyui-textbox" name="custpwd" style="width:50%">
		    </div>   
		</form>
		<div style="margin-left:150px;padding:5px 0">
			<input type="button" onclick="submitForm()" value="查询">
		</div>
	</div>
	 <!-- 如果写在最下面,按钮不能触发事件?? -->
  <script type="text/javascript">
  	//定义全局的url
  	var _url = "queryCustomer";
  	
  	//点击新建按钮打开窗口界面
  	$(function(){
  		$("#saveCustomer").click(function(){
  			
  		});
  	});
  	
  	//点击修改按钮打开窗口
	$(function(){
		$("#updateCustomer").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#customerListTable').datagrid('getSelected');
			if(obj != null) {
				//清除提交照片表单
				$('#customerFormImg').form('clear');
				//读取记录填充到表单中
				$('#customerForm').form('load',obj);
				//打开窗口
				$('#customerShowUI').window();
				//将牌照设置为只读模式(主键不能更改)
				$('#carnumber').textbox('readonly');
				//设置url为提交连接
				_url = "updateCar";
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	}); 
  	
  	//提交表单
	function submitForm(){
		$('#customerForm').form('submit',{
			url: _url,
			success: function(data){
				//隐藏查询栏
				$("#_form").css("display","none");
				//加载查询列表
				$("#_table").css("display","block");
				//将json字符串转换为json对象
				var obj = JSON.parse(data);
				//表格加载数据
				$('#customerListTable').datagrid({data:obj.rows});
			}
		});
	}
  	
  	//删除汽车信息
	$(function(){
		$("#deleteCustomer").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#customerListTable').datagrid('getSelected');
			if(obj != null) {
				//删除
				$.post('deleteCar','carnumber='+obj.carnumber,function(){
					$.messager.alert('提示','操作成功!')
					//刷新数据
					$('#customerListTable').datagrid('reload')
				});
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	});
  	
  </script> 
  </body>
</html>
