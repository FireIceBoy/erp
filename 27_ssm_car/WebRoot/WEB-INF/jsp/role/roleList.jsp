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
	<table id="_tab" class="easyui-datagrid" pagination=true page=1 pageSize=10 url='queryRoleForMap' toolbar="#roleAdd" data-options="fitColumns:true,singleSelect:true" fit=true>   
	    <thead>   
	        <tr>   
	            <th data-options="field:'roleid',width:100">ID</th>   
	            <th data-options="field:'rolename',width:100">职位</th>   
	            <th data-options="field:'roledesc',width:100">备注</th>   
	        </tr>   
	    </thead>   
	</table>  
	<div id="roleAdd">
		<a id="btn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>&nbsp; &nbsp; &nbsp;  
		<a id="_update" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>&nbsp; &nbsp; &nbsp; 
		<a id="_update" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改角色权限</a>&nbsp; &nbsp; &nbsp; 
		<a id="_delete" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
	</div>
	<div id="win" title="新建" style="width:430px;height:240px;display:none;" data-options="iconCls:'icon-save',modal:true">   
	   <form id="ff" style="margin-top: 20px;margin-left: 20px" method="post" data-options="novalidate:true">
			<div style="margin-bottom:20px">
				<input name="roleid" type="hidden">
				<input class="easyui-textbox" name="rolename" style="width:80%" data-options="label:'职位:',required:true,validType:'length[2,10]'">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="roledesc" style="width:80%" data-options="label:'备注:',required:true,validType:'length[5,100]'">
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
		$("#btn").click(function(){
			//打开窗口
			$('#win').window();
			//清除表单内容
			$('#ff').form('clear');
			//设置url为提交连接
			_url = 'saveRole';
		});
	});
	
	//点击修改
	$(function(){
		$("#_update").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#_tab').datagrid('getSelected');
			if(obj != null) {
				//读取记录填充到表单中
				$('#ff').form('load',obj);
				//打开窗口
				$('#win').window();
				//设置url为提交连接
				_url = 'updateRole';
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	}); 
	
	//删除
	$(function(){
		$("#_delete").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#_tab').datagrid('getSelected');
			if(obj != null) {
				//删除
				$.post('deleteRole','roleid='+obj.roleid,function(){
					$.messager.alert('提示','操作成功!')
					//刷新数据
					$('#_tab').datagrid('reload')
				});
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	});
	
	
	//提交表单
	function submitForm(){
		$('#ff').form('submit',{
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
				$('#win').window('close');
				//刷新数据
				$('#_tab').datagrid('reload')
				
				$.messager.alert('提示','操作完成')
			}
		});
	}
  </script> 
  </body>
  
</html>
