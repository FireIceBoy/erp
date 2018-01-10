<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>汽车租赁管理系统欢迎您</title>
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
  
    <body class="easyui-layout" >   
	    <div data-options="region:'north',title:'汽车租赁管理系统',split:true" style="height:100px;">
	    	<img src="${pageContext.request.contextPath }/images/top.png" width="99.99%" onclick="exit()">
	    </div>   
	    <div data-options="region:'west',title:'系统菜单',split:true" style="width:180px;" >
	    	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;" fit=true>   
			    <div title="汽车租赁管理系统" selected=true style="overflow:auto;padding:10px;" >   
			       <ul id="_tree" ></ul>  
			    </div>   
			    <div title="自动化办公系统"  style="padding:10px;">   
			        content2    
			    </div>   
			    <div title="网上商城管理系统">   
			        content3    
			    </div>   
			</div>
	    </div>   
	    <div data-options="region:'center',title:'数据中心'" style="padding:5px;background:#eee;">
	    	<div id="_tabs" class="easyui-tabs" fit="true">   
			    <div title="首页" style="padding:20px;display:none;" align="center">   
			        <img src="${pageContext.request.contextPath }/images/welcome.jpg"> 
			    </div>   
			</div>  
	    </div>   
	    <div data-options="region:'south',title:'关于我们|联系我们|联系客服|合作招商|商家帮助|营销中心|手机京东|友情链接|销售联盟|京东社区|风险监测|隐私政策|京东公益|English Site|Media & IR',split:true" style="height:0;" align="center"></div>   
	</body> 
	<script type="text/javascript">
	
		//加载树
		$(function(){
			$('#_tree').tree({    
			    url:'queryMenuByUserVo'   
			});  
		});
		
		//单击树触发事件
		$('#_tree').tree({
			onClick: function(node){
				//判断当前树是否为叶子节点
				var isLeaf = $('#_tree').tree("isLeaf",node.target);
				if(isLeaf){//如果是叶子节点
					//判断当前是否已经存在该选项卡
					var exists = $('#_tabs').tabs("exists",node.text);
					if(exists){//如果存在该选项卡,选中该选项卡
						 $('#_tabs').tabs("select",node.text)
						
					}else{//如果不存在该选项卡,则创建新选项卡
						$('#_tabs').tabs('add',{    
						    title:node.text,  
						    //node.url:获取树节点的url
						    href:node.url,    
						    closable:true,    
						}); 
					}
				}
			}
		});
		
		//退出
		function exit(){
			$.post("exit",function(){
				window.parent.location.href="${pageContext.request.contextPath}/toLogin"
			});
		}
	</script> 
</html>
