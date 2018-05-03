<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<div class="cl pd-5 bg-1 bk-gray">
		<span class="l"> <c:if
				test="${sessionScope.user.ent_id.equals(info.ent_id)}">
				<a class="btn btn-primary radius" data-title="编辑"
					href="javascript:;"
					onclick="entInfo_edit('编辑','/sys_edu/user/entInfo-add/${null==sessionScope.user?0:sessionScope.user.ent_id}')"><i
					class="Hui-iconfont">&#xe6df;</i> 编辑</a>
			</c:if></span>
	</div>
	<div style="width: 100%; margin: 2px auto; text-align: center">

		<h1>${info.ent_name }</h1>
		${info.ent_add}&nbsp&nbsp${info.ent_phone}<br /> <br />
		${info.ent_text }<br /> <a
			href="/sys_edu/list/techSer-list?ent_id=${info.ent_id}">该企业发布技术服务供应与需求</a>

	</div>





	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
	<script type="text/javascript">
	function entInfo_edit(title, url) {
		var index = layer.open({
			type : 2,
			title : title,
			content : url,
			area : [ '1000px', '580px' ],
			end: function () {		//!!!只要弹窗销毁就会执行
                location.reload();
            }
		});
	}
	</script>
</body>
</html>