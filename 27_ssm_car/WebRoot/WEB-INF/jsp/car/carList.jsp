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
  	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.2/datagrid-detailview.js"></script> 
	<table id="carListTable" pagination=true page=1 pageSize=10 class="easyui-datagrid" url='queryCar' toolbar="#carAdd" data-options="fitColumns:true,singleSelect:true" fit=true>   
	    <thead>   
	        <tr>   
	            <th data-options="field:'carnumber',width:100">车辆牌照</th>   
	            <th data-options="field:'cartype',width:100">汽车类型</th>   
	            <th data-options="field:'color',width:50">颜色</th>   
	            <th data-options="field:'price',width:50">价格</th>   
	            <th data-options="field:'rentprice',width:50">租金</th>   
	            <th data-options="field:'deposit',width:50">保证金</th>   
	            <th data-options="field:'isrenting',width:100">是否出租</th>   
	            <th data-options="field:'cardesc',width:200">描述</th>   
	        </tr>   
	    </thead>   
	</table>  
	<div id="carAdd">
		<a id="saveCar" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>&nbsp; &nbsp; &nbsp;  
		<a id="updateCar" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>&nbsp; &nbsp; &nbsp; 
		<a id="deleteCar" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
	</div>
	<div id="carShowUI" title="新建" style="width:600px;height:500px;display:none;" data-options="iconCls:'icon-save',modal:true">   
	   <div style="position: absolute;left: 320px;top:50px;width:200px;height:200px;border: 1px solid red">
	   		<img id="carImg" style="width:200px;height:200px;" src="">
	   </div>
	   <form id="carForm" style="margin-top: 20px;margin-left: 20px" method="post" data-options="novalidate:true">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="carnumber" name="carnumber" style="width:50%" data-options="label:'车牌号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="cartype" style="width:50%" data-options="label:'型号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="color" style="width:50%" data-options="label:'颜色:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="price" style="width:50%" data-options="label:'价格:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="rentprice" style="width:50%" data-options="label:'租金:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="deposit" style="width:50%" data-options="label:'押金:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="isrenting" style="width:90%" data-options="label:'是否出租:',required:true">
			</div>
			
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="cardesc" style="width:90%;height:60px" data-options="label:'备注:',required:true">
			</div>
			<input type="hidden" name="carimg" id="carimg">
		</form>
		<form id="carFormImg" style="margin-top: 20px;margin-left: 20px" method="post" data-options="novalidate:true">
			<div style="margin-bottom:20px">
				<input class="easyui-filebox" name="file" style="width:67%" data-options="label:'图片:',required:true">
				<input type="button" id="saveCarImg" value="上传图片">
			</div>
		</form>
		<div style="margin-left:150px;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
		</div>
	</div>
	 <!-- 如果写在最下面,按钮不能触发事件?? -->
  <script type="text/javascript">
  	//上传照片
  	$(function(){
  		$("#saveCarImg").click(function(){
  			//获取表单数据
  			var file = new FormData($("#carFormImg")[0]);
  			//ajax提交
  			$.ajax({
				url:'saveCarImg',
				type:'post',
				contentType:false,
				processData:false,
				data:file,
				success:function(obj){
					//设置图片回显
					$("#carImg").attr('src',"/pic/"+obj.path);	
					//设置图片名称
					$("#carimg").val(obj.path)
				}
  			});
  		});
  	});
  
  	//选择一行显示具体信息
	$(function(){
		$('#carListTable').datagrid({
			view: detailview, 
			detailFormatter: function(rowIndex, rowData){ 
			return '<table><tr>' + 
			'<td rowspan=2 style="border:0"><img src="/pic/' + rowData.carimg + '" style="height:50px;"></td>' + 
				'<td style="border:0">' + 
				'<p>车牌号: ' + rowData.carnumber + '</p>' + 
				'<p>颜色: ' + rowData.color + '</p>' + 
				'</td>' + 
				'</tr></table>'; 
			} 
		});
	}); 
  	
  	//定义全局的url
  	var _url = "";
  	
  	//点击新建按钮打开窗口界面
  	$(function(){
  		$("#saveCar").click(function(){
  			//打开窗口
			$('#carShowUI').window();
			//清除表单内容
			$('#carForm').form('clear');
			$('#carFormImg').form('clear');
			//给定访问链接
			_url = "saveCar";
  		});
  	});
  	
  	//点击修改按钮打开窗口
	$(function(){
		$("#updateCar").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#carListTable').datagrid('getSelected');
			if(obj != null) {
				//清除提交照片表单
				$('#carFormImg').form('clear');
				//读取记录填充到表单中
				$('#carForm').form('load',obj);
				//打开窗口
				$('#carShowUI').window();
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
		$('#carForm').form('submit',{
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
				$('#carShowUI').window('close');
				//刷新数据
				$('#carListTable').datagrid('reload')
				
				$.messager.alert('提示','操作完成')
			}
		});
	}
  	
  	//删除汽车信息
	$(function(){
		$("#deleteCar").click(function(){
			//获取当前表格内选中的数据对象
			var obj = $('#carListTable').datagrid('getSelected');
			if(obj != null) {
				//删除
				$.post('deleteCar','carnumber='+obj.carnumber,function(){
					$.messager.alert('提示','操作成功!')
					//刷新数据
					$('#carListTable').datagrid('reload')
				});
			}else{
				$.messager.alert('提示','请选择一行数据!')
			}
		});
	});
  	
  </script> 
  </body>
</html>
