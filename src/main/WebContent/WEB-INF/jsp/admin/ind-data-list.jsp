<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>




<div style="width: 500px; margin: 2px auto; text-align: center">

	<c:forEach items="${info}" var="c" varStatus="st">
		<div style="margin-buttom: 1px">
			<%-- <a href="">${c.title }</a> --%>
			${c.title }<br /> ${c.ind_date }<br /> source:${c.source}<br />
		</div>

	</c:forEach>


	<div style="text-align: center">
		<a href="?start=0">首 页</a> <a href="?start=${page.start-page.count}">上一页</a>
		<a href="?start=${page.start+page.count}">下一页</a> <a
			href="?start=${page.last}">末 页</a>
	</div>
</div>



<%@include file="../include/_footer.jsp"%>
</body>
</html>