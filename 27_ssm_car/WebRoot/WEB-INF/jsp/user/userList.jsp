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
  	
	<table id="userListTable" pagination=true page=1 pageSize=10 class="easyui-datagrid" url='queryUserOfPage' toolbar="#userAdd" data-options="fitColumns:true,singleSelect:true" fit=true>   
	    <thead>   
	        <tr>   
	            <th data-options="field:'username',width:100">账户名</th>   
	            <th data-options="field:'identity',width:100">昵称</th>   
	            <th data-options="field:'fullname',width:100">姓名</th>   
	            <th data-options="field:'sex',width:100">性别</th>   
	            <th data-options="field:'address',width:100">住址</th>   
	            <th data-options="field:'phone',width:100">电话</th>   
	            <th data-options="field:'position',width:100">职位</th>   
	            <th data-options="field:'userlevel',width:100">员工级别</th>   
	            <th data-options="field:'userpwd',width:100">密码</th>   
	        </tr>   
	    </thead>   
	</table>  
	<div id="userAdd">
		<a id="saveUser" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>&nbsp; &nbsp; &nbsp;  
		<a id="updateUser" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>&nbsp; &nbsp; &nbsp; 
		<a id="deleteUser" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
	</div>
	<div id="UserShowUI" title="新建" style="width:430px;height:500px;display:none;" data-options="iconCls:'icon-save',modal:true">   
	   <form id="userForm" style="margin-top: 20px;margin-left: 20px" method="post" data-options="novalidate:true">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="username" name="username" style="width:80%" data-options="label:'账户名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="identity" style="width:80%" data-options="label:'昵称:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="fullname" style="width:80%" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				性别:<span style="margin-left: 50px">
					<input name="sex" type="radio" value="男">男
					<input name="sex" type="radio" value="女">女
				</span>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="address" style="width:80%" data-options="label:'地址:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="phone" style="width:80%" data-options="label:'联系电话:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="position" style="width:80%" data-options="label:'职位:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="userlevel" style="width:80%" data-options="label:'员工级别:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" name="userpwd" style="width:80%" data-options="label:'密码:',required:true">
			</div>
		</form>
		<div style="margin-left:150px;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
		</div>
	</div>  
	 <!-- 如果写在最下面,按钮不能触发事件?? -->
  <script type="text/javascript">
  	//定义全局的变量,用于提交数据
  	var _url = '';
	//点击新建
	$(function(){
		$("#saveUser").click(function(){
			//打开窗口
			$('#UserShowUI').window();
			//清除表单内容
			$('#userForm').form('clear');
			//设置url为提交连接
			_url = 'saveUser';
		});
	});
	
	//点击修改
	$(function(){
		$("#updateUser").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#userListTable').datagrid('getSelected');
			if(obj != null) {
				//读取记录填充到表单中
				$('#userForm').form('load',obj);
				//打开窗口
				$('#UserShowUI').window();
				//将用户名设置为只读模式
				$('#username').textbox('readonly');
				//设置url为提交连接
				_url = 'updateUser';
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	}); 
	
	//删除
	$(function(){
		$("#deleteUser").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#userListTable').datagrid('getSelected');
			if(obj != null) {
				//删除
				$.post('deleteUser','username='+obj.username,function(){
					$.messager.alert('提示','操作成功!')
					//刷新数据
					$('#userListTable').datagrid('reload')
				});
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	});
	
	
	//提交表单
	function submitForm(){
		$('#userForm').form('submit',{
			url: _url,
			onSubmit: function(){
				//获取表单验证是否符合要求
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.alert('警告','表单填写不符合要求')
				}
				return isValid;	// 返回false终止表单提交

			},
			success: function(){
				//关闭窗口
				$('#UserShowUI').window('close');
				//刷新数据
				$('#userListTable').datagrid('reload')
				
				$.messager.alert('提示','操作完成')
			}
		});
	}
  </script> 
  </body>
</html>
