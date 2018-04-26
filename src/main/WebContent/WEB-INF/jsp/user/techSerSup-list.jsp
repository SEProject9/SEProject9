<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
<style type="text/css">
a {
	font-size: 16px;
	font-weight: normal;
}

p {
	font-size: 10px;
}
</style>
</head>
<body>

	<div class="cl pd-5 bg-1 bk-gray">
		<span class="l">
		<c:if test="${null!=sessionScope.user }">
		<a class="btn btn-primary radius"
			data-title="添加" href="javascript:;"
			onclick="techSer_add('添加客户','/sys_edu/user/techSerSup-add')"><i
				class="Hui-iconfont">&#xe600;</i> 添加</a></c:if></span>
		<div class="text-c">
			<form action="/sys_edu/list/techSerSup-search">
				<span class="select-box inline"> <select name="ind_id">
						<option value="">所有行业</option>
						<c:forEach items="${ind}" var="c" varStatus="st">
							<option value="${c.ind_id}">${c.ind_name}</option>
						</c:forEach>
				</select>
				</span> <input type="text" name="sup_title" id="" value=""
					placeholder=" 标题" style="width: 250px" class="input-text">
				<button name="" id="" class="btn btn-success" type="submit">
					<i class="Hui-iconfont">&#xe665;</i> 搜索
				</button>
			</form>
		</div>
	</div>




	<div style="clear: both; margin-top: 10px; text-align: center">
		<c:forEach items="${info}" var="c" varStatus="st">
			<div style="margin-buttom: 1px">
				<a href="/sys_edu/list/techSerSup-show?id=${c.sup_id}">
					${c.sup_title }</a><br />
				<p>${c.sup_date }</p>
			</div>

		</c:forEach>
		<div style="text-align: center">
			<c:if test="${page.start!=0}">
				<a href="?start=0">首 页</a>
				<a href="?start=${page.start-page.count}">上一页</a>
			</c:if>
			<c:if test="${page.start!=page.last}">
				<a href="?start=${page.start+page.count}">下一页</a>
				<a href="?start=${page.last}">末 页</a>
			</c:if>
		</div>
	</div>



	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
	<script type="text/javascript">
		function techSer_add(title, url) {
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