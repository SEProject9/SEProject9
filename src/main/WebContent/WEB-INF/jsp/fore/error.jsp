<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
</head>
<body>

		
		<h1 align="center" style="margin-top: 100px; font-size: 70px">
		<c:choose>
		<c:when test="${msg.equals('请进行登录')}"><a style="text-decoration: none;color: black" href="/sys_edu/user/index">${msg}</a></c:when>
		<c:otherwise>${msg}</c:otherwise>
		</c:choose>
		</h1>
			<h3 align="center">error${type }</h3>
	<br /> 
	<br>

</body>
<!-- 听说是要大于1024个字节才可以跳转到此错误页面,现在可能才600字节不到;下面在复制几行
复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制
复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制
复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制
复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制
复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制
复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制复制
复制复制

复制复制

复制复制
复制复制 mmp假的-->
</html>