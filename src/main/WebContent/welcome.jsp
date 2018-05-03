<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
<%@ page import="java.util.*"%>
<script language="javascript"> 
function realSysTime(clock){ 
var now=new Date(); //创建Date对象 
var year=now.getFullYear(); //获取年份 
var month=now.getMonth(); //获取月份 
var date=now.getDate(); //获取日期 
var day=now.getDay(); //获取星期 
var hour=now.getHours(); //获取小时 
var minu=now.getMinutes(); //获取分钟 
var sec=now.getSeconds(); //获取秒钟 
month=month+1; 
var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
var week=arr_week[day]; //获取中文的星期 
var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间 
clock.innerHTML=time; //显示系统时间 
} 
window.onload=function(){ 
window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间 
} 
</script> 
</head>
<body>
	<div class="page-container">
		<p class="f-20 text-success">
			<c:if test="${null!=sessionScope.user}">${sessionScope.entInfo.ent_name}</c:if>
			<span class="f-14">欢迎使用我</span>
		</p>
		<c:if test="${null!=sessionScope.user}">
			<p>登录次数：${sessionScope.count}</p>
		</c:if>

		<p>上次登录IP：202.35.131.79.1 上次登录时间：2018-5-1 11:19:55</p>
		<table style="display: none"
			class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th colspan="7" scope="col">信息统计</th>
				</tr>
				<tr class="text-c">
					<th>统计</th>
					<th>资讯库</th>
					<th>图片库</th>
					<th>产品库</th>
					<th>用户</th>
					<th>管理员</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>总数</td>
					<td>92</td>
					<td>9</td>
					<td>0</td>
					<td>8</td>
					<td>20</td>
				</tr>
				<tr class="text-c">
					<td>今日</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="text-c">
					<td>昨日</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="text-c">
					<td>本周</td>
					<td>2</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
				<tr class="text-c">
					<td>本月</td>
					<td>2</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-border table-bordered table-bg mt-20">
			<thead>
				<tr>
					<th colspan="2" scope="col">服务器信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="30%">服务器计算机名</th>
					<td><span id="lbServerName">http://47.106.137.93/</span></td>
				</tr>
				<tr>
					<td>服务器IP地址</td>
					<td>47.106.137.93</td>
				</tr>
				<tr>
					<td>服务器端口</td>
					<td>8080</td>
				</tr>
				<tr>
					<td>本文件所在文件夹</td>
					<td>/home/admin/apache-tomcat-9.0.7</td>
				</tr>
				<tr>
					<td>服务器操作系统</td>
					<td>Debian 8.9</td>
				</tr>
				<tr>
					<td>系统所在文件夹</td>
					<td>/</td>
				</tr>
				<tr>
					<td>服务器脚本超时时间</td>
					<td>30000秒</td>
				</tr>
				<tr>
					<td>服务器的语言种类</td>
					<td>Chinese (People's Republic of China)</td>
				</tr>
				<tr>
					<td>服务器当前时间</td>
					<td id="clock" />
				</tr>
				<tr>
					<td>服务器上次启动到现在已运行</td>
					<td>7210分钟</td>
				</tr>
				<tr>
					<td>逻辑驱动器</td>
					<td>/</td>
				</tr>
				<tr>
					<td>CPU 总数</td>
					<td>1</td>
				</tr>
				<tr>
					<td>CPU 类型</td>
					<td>Intel(R) Xeon(R) CPU E5-2430 0 @ 2.20GHz</td>
				</tr>
				<tr>
					<td>虚拟内存</td>
					<td>2048M</td>
				</tr>
				<tr>
					<td>当前程序占用内存</td>
					<td>3.29M</td>
				</tr>
				<tr>
					<td>Asp.net所占内存</td>
					<td>51.46M</td>
				</tr>
				<tr>
					<td>当前Session数量</td>
					<td>8</td>
				</tr>
				<tr>
					<td>当前SessionID</td>
					<td>gznhpwmp34004345jz2q3l45</td>
				</tr>
				<tr>
					<td>当前系统用户名</td>
					<td>admin</td>
				</tr>
			</tbody>
		</table>
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p>
				感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br>
				Copyright &copy;2015-2017 H-ui.admin v3.1 All Rights Reserved.<br>
				本后台系统由<a href="http://www.h-ui.net/" target="_blank"
					title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持
			</p>
		</div>
	</footer>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
</body>
</html>