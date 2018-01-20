<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>出库统计分析</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="js/jquery.js"></script>
	<script src="ECharts/echarts.min.js"></script>

  </head>
  
  <body>
   <div class="formbody">
	  	<ul class="forminfo">
		  	<li><label>商品名称</label>
				 <select name="gid" id="gid" class="dfinput">
				 	<option value="0">选择需要查看的商品</option>
				  </select>
			</li>
		</ul>
	    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	    <div id="main" style="width: 900px;height:400px;"></div>
    </div>
    
    
    
    <script type="text/javascript">
    
    	//获取所有商品对象的json
	    $.post("goodsName_queryAllGoods.action",function(data){
			var goodsList = data.list;
			for(var i = 0; i<goodsList.length; i++){
				var code = "<option value="+goodsList[i].gid +">"+goodsList[i].goodsname+"</option>";
				$("#gid").append(code);
			}
		});
    	
    	
    	//获取商品的入库记录
	    $("#gid").change(function(){
	    	//存放进货数量
	    	var num =[];
	    	//存放进货日期
	    	var arr = [];
			var gid = $(this).val();
			$.post("goodsName_queryOutport.action",{'goodsVo.gid': gid},function(list){
				listOutports = list.listOutports;
				for(var i =0; i<listOutports.length; i++){
					var outputtime = listOutports[i].outputtime.substring(0,10)
					num[i]=listOutports[i].number;
					arr[i]=outputtime;
				}
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('main'));

		        option = {
		        	    title: {
		        	        text: '折线图堆叠'
		        	    },
		        	    tooltip: {
		        	        trigger: 'axis'
		        	    },
		        	    legend: {
		        	        data:['邮件营销','联盟广告']
		        	    },
		        	    grid: {
		        	        left: '3%',
		        	        right: '4%',
		        	        bottom: '3%',
		        	        containLabel: true
		        	    },
		        	    toolbox: {
		        	        feature: {
		        	            saveAsImage: {}
		        	        }
		        	    },
		        	    xAxis: {
		        	        type: 'category',
		        	        boundaryGap: false,
		        	        data: arr
		        	    },
		        	    yAxis: {
		        	        type: 'value'
		        	    },
		        	    series: [
		        	        {
		        	            name:'进货曲线',
		        	            type:'line',
		        	            stack: '单次进货数量',
		        	            data:num
		        	        },
		        	    ]
		        	};
		        
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			});
		});
    
        
  </script>
  </body>
</html>
