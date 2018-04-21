<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<div class="cl pd-5 bg-1 bk-gray">
		<span class="l"><a class="btn btn-primary radius"
			data-title="删除" data-href="techSerSup-del"
			href="/sys_edu/user/techSer-del?type=req&id=${info.req_id}"><i
				class="Hui-iconfont">&#xe6a1;</i> 删除</a>&nbsp&nbsp<a
			class="btn btn-primary radius" data-title="编辑"
			data-href="techSerReq-add"
			href="/sys_edu/user/techSerReq-add?type=req&id=${info.req_id}"><i
				class="Hui-iconfont">&#xe6df;</i> 编辑</a></span>
	</div>
	msg:${msg}
	<c:if test="null!=${msg}">
	${msg}
	</c:if>
	<div style="width: 500px; margin: auto; text-align: center">


		<h1>${info.req_title }</h1>

		<c:if test="null!=${entInfo.ent_name}">
	${entInfo.ent_name}
	</c:if>
		${info.req_date }<br /> ${info.req_text }<br />




	</div>





	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
	<script type="text/javascript">
		
	</script>
</body>
</html>