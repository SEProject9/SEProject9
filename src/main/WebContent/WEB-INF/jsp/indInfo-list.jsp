<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
<style type="text/css">
a {
	font-size: 16px;
	font-weight: normal;
}

p, p>a {
	font-size: 10px;
}
</style>
</head>
<body>

	<div class="cl pd-5 bg-1 bk-gray text-c">
		<form action="/sys_edu/list/indInfo-search">
			<span class="select-box inline"> <select name="ind_id">
					<option value="">所有行业</option>
					<c:forEach items="${ind}" var="c" varStatus="st">
						<option value="${c.ind_id}">${c.ind_name}</option>
					</c:forEach>
			</select>
			</span> <input type="text" name="title" id="" value="" placeholder=" 标题"
				style="width: 250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit">
				<i class="Hui-iconfont">&#xe665;</i> 搜索
			</button>
		</form>
	</div>
	<div style="width: 500px; margin: 4px auto; text-align: center">

		<c:forEach items="${info}" var="c" varStatus="st">
			<div style="margin: 1px, 0px, 1px, 0px">
				<a href="/sys_edu/list/indInfo-show?id=${c.ind_info_id}">${c.title }</a>
				<p>${c.ind_date }&nbsp&nbsp&nbsp&nbsp<a href="${c.url}">${c.source}</a>
				</p>
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
</body>
</html>