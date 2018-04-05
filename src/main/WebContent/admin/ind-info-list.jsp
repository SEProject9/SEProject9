<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../WEB-INF/jsp/include/_meta.jsp"%>


<div class="pd-20">这是一个空白页</div>


<div style="width: 500px; margin: 0px auto; text-align: center">

	<c:forEach items="${info}" var="c" varStatus="st">
		<div style="margin-buttom: 3px; text-align: center">${c.title }
			${c.ind_data } ${c.source}</div>

	</c:forEach>


	<div style="text-align: center">
		<a href="?start=0">首 页</a> <a href="?start=${page.start-page.count}">上一页</a>
		<a href="?start=${page.start+page.count}">下一页</a> <a
			href="?start=${page.last}">末 页</a>
	</div>
</div>



<%@include file="../WEB-INF/jsp/include/_footer.jsp"%>
</body>
</html>