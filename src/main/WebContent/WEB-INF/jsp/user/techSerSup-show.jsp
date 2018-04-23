<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<div class="cl pd-5 bg-1 bk-gray">
		<span class="l"><a class="btn btn-primary radius"
			data-title="删除" data-href="techSer-del?type=sup"
			href="/sys_edu/user/techSer-del?type=sup&id=${info.sup_id}"><i
				class="Hui-iconfont">&#xe6a1;</i> 删除</a>&nbsp&nbsp<a
			class="btn btn-primary radius" data-title="编辑" href="javascript:;"
			onclick="techSer_edit('编辑','/sys_edu/user/techSerSup-add?type=sup&id=${info.sup_id}')"><i
				class="Hui-iconfont">&#xe6df;</i> 编辑</a></span>
	</div>
	msg:${msg}
	<div style="width: 500px; margin: auto; text-align: center">
		<h1>${info.sup_title }</h1>

		<c:if test="null!=${entInfo.ent_name}">
	${entInfo.ent_name}
	</c:if>
		${info.sup_date }<br /> ${info.sup_text }<br />

	</div>





	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
	<script type="text/javascript">
		function techSer_edit(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url,
				area : [ '1000px', '550px' ]
			});
		}
	</script>
</body>
</html>