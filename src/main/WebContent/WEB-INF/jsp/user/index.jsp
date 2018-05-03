<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@include file="../include/_meta.jsp"%> --%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>



	<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl">
				<a class="logo navbar-logo f-l mr-10 hidden-xs"
					href=" /sys_edu/admin/login">H-ui.admin</a> <a
					class="logo navbar-logo-m f-l mr-10 visible-xs" href="index.html">H-ui</a>
				<span class="logo navbar-slogan f-l mr-10 hidden-xs">v3.1</span> <a
					aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
					href="javascript:;">&#xe667;</a>
				<nav class="nav navbar-nav">
					<ul class="cl">
						<li class="dropDown dropDown_hover"><a href="javascript:;"
							class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i
								class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;"
									onclick="techSer_add('添加','/sys_edu/user/techSerSup-add')"><i
										class="Hui-iconfont">&#xe613;</i> 技术服务供应</a></li>
								<li><a href="javascript:;"
									onclick="techSer_add('添加','/sys_edu/user/techSerReq-add')"><i
										class="Hui-iconfont">&#xe616;</i> 技术服务需求</a></li>
							</ul></li>
					</ul>
				</nav>
				<nav id="Hui-userbar"
					class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
						<li class="dropDown dropDown_hover"><a href="#"
							class="dropDown_A">
							<c:choose>
							<c:when test="${null!=sessionScope.user}">${sessionScope.user.ent_account}</c:when>
							<c:otherwise>游客</c:otherwise>
							</c:choose>
							<i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="/sys_edu/user/logout">切换账户</a></li>
								<li><a href="/sys_edu/user/logout">退出</a></li>
							</ul></li>
						<li id="Hui-msg"><a href="#" title="消息"><span
								class="badge badge-danger">1</span><i class="Hui-iconfont"
								style="font-size: 18px">&#xe68a;</i></a></li>
						<li id="Hui-skin" class="dropDown right dropDown_hover"><a
							href="javascript:;" class="dropDown_A" title="换肤"><i
								class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" data-val="default"
									title="默认（黑色）">默认（黑色）</a></li>
								<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
								<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
								<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
								<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
								<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<aside class="Hui-aside">
		<div class="menu_dropdown bk_2">
			<dl id="menu-account">
				<dt>
					<i class="Hui-iconfont">&#xe616;</i> 企业<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="/sys_edu/list/entInfo-list"
							data-title="其他企业" href="javascript:void(0);">其他企业</a></li>
						<li><a
							data-href="/sys_edu/list/entInfo-show/${null==sessionScope.user?0:sessionScope.user.ent_id}"
							data-title="我的企业" href="javascript:void(0)">我的企业</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-customer">
				<dt>
					<i class="Hui-iconfont">&#xe60d;</i> 行业<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="/sys_edu/list/indInfo-list"
							data-title="行业资讯" href="javascript:;">行业资讯</a></li>
						<li><a data-href="/sys_edu/list/indData-list"
							data-title="行业数据" href="javascript:void(0)">行业数据</a></li>
						<!-- 						<li><a data-href="/sys_edu/list/indData-list"
							data-title="行业数据" href="javascript:void(0)">行业数据</a></li> -->
					</ul>
				</dd>
			</dl>
			<dl id="menu-user">
				<dt>
					<i class="Hui-iconfont">&#xe60d;</i> 技术与服务<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="/sys_edu/list/techSerSup-list"
							data-title="技术与服务提供" href="javascript:void(0)">技术与服务提供</a></li>
						<li><a data-href="/sys_edu/list/techSerReq-list"
							data-title="技术与服务需求" href="javascript:;">技术与服务需求</a></li>
						<li><a data-href="/sys_edu/list/techSer-list"
							data-title="个人发布" href="javascript:void(0)">个人发布</a></li>
					</ul>
				</dd>
			</dl>
			<!-- <dl id="menu-supplier">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i> 供应商管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="supplier-list.html" data-title="供应商列表"
						href="javascript:void(0)">供应商列表</a></li>
					<li><a data-href="rate-list.html" data-title="供应商费率"
						href="javascript:void(0)">供应商费率</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-worker">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i> 员工管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="worker-list.html" data-title="管理员列表"
						href="javascript:void(0)">员工列表</a></li>
					<li><a data-href="diary-list.html" data-title="角色管理"
						href="javascript:void(0)">员工日志</a></li>
					<li><a data-href="post-list.html" data-title="权限管理"
						href="javascript:void(0)">职位管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt>
				<i class="Hui-iconfont">&#xe61a;</i> 系统统计<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="charts-1.html" data-title="折线图"
						href="javascript:void(0)">折线图</a></li>
					<li><a data-href="charts-2.html" data-title="时间轴折线图"
						href="javascript:void(0)">时间轴折线图</a></li>
					<li><a data-href="charts-3.html" data-title="区域图"
						href="javascript:void(0)">区域图</a></li>
					<li><a data-href="charts-4.html" data-title="柱状图"
						href="javascript:void(0)">柱状图</a></li>
					<li><a data-href="charts-5.html" data-title="饼状图"
						href="javascript:void(0)">饼状图</a></li>
					<li><a data-href="charts-6.html" data-title="3D柱状图"
						href="javascript:void(0)">3D柱状图</a></li>
					<li><a data-href="charts-7.html" data-title="3D饼状图"
						href="javascript:void(0)">3D饼状图</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt>
				<i class="Hui-iconfont">&#xe62e;</i> 系统管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="system-data.html" data-title="数据字典"
						href="javascript:void(0)">数据字典</a></li>
					<li><a data-href="system-log.html" data-title="系统日志"
						href="javascript:void(0)">系统日志</a></li>
				</ul>
			</dd>
		</dl> -->
		</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>

	<!--内置ifame -->
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="我的桌面" data-href="index.html">我的桌面</span>
						<em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
					id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="/sys_edu/welcome.jsp"></iframe>
			</div>
		</div>
	</section>

	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前</li>
			<li id="closeall">关闭全部</li>
		</ul>
	</div>

	<%-- <%@include file="../include/_footer.jsp"%> index从admin移出后错误--%>
	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>

	<script type="text/javascript">
		/*$(function() {
				$("#min_title_list li").contextMenu('Huiadminmenu', {
					bindings: {
						'closethis': function(t) {
							console.log(t);
							if(t.find("i")){
								t.find("i").trigger("click");
							}		
						},
						'closeall': function(t) {
							alert('Trigger was '+t.id+'\nAction was Email');
						},
					}
				});
			});*/
		/*个人信息*/
		/* 	function myselfinfo() {
				layer.open({
					type : 1,
					area : [ '300px', '200px' ],
					fix : false, //不固定
					maxmin : true,
					shade : 0.4,
					title : '查看信息',
					content : '<div>管理员信息</div>'
				});
			} */

		/*资讯-添加*/
		function techSer_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url,
				area : [ '1000px', '550px' ],
				end: function () {		//!!!只要弹窗销毁就会执行
	              /*   location.reload(); */
	                $(".show_iframe").each(function(){
	                    //判断每一个div，其css中display是否为block
	                    if($(this).css("display")=="block"){
	                    	/* alert($(this).children("iframe").attr("src")); */
	                    	var src=$(this).children("iframe").attr("src");
	                    	$(this).children("iframe").attr('src', src);
	                    	/*  $(this).location.reload(true);  */
	                    }
	                });
	               /*  document.getElementByTagName('iframe').contentWindow.location.reload(true); */
	            }
			});
		}
		/*图片-添加*/
		/* function picture_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		} */
		/*产品-添加*/
		/* 	function product_add(title, url) {
				var index = layer.open({
					type : 2,
					title : title,
					content : url
				});
				layer.full(index);
			} */
		/*用户-添加*/

		/* function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		} */
	</script>

</body>
</html>