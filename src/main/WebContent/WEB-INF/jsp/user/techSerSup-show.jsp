<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>


<div style="width: 500px; margin: 2px auto; text-align: center">
	<h1>${info.sup_title }</h1>

	<c:if test="null!=${entInfo.ent_name}">
	${entInfo.ent_name}
	</c:if>
	${info.sup_date }<br /> ${info.sup_text }<br />




</div>





<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
<script type="text/javascript">
	
</script>
</body>
</html>