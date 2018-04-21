<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>


	<c:if test="null!=${msg}">
	${msg}
	</c:if>
	<div style="width: 100%; margin: 2px auto; text-align: center">

		<h1>${info.ent_name }</h1>
		${info.ent_add}&nbsp&nbsp${info.ent_phone}<br /> <br />
		${info.ent_text }<br /> <a href="techSer-list?ent_id=${info.ent_id}">该企业发布技术服务供应与需求</a>
	
	</div>





	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
	<script type="text/javascript">
		
	</script>
</body>
</html>