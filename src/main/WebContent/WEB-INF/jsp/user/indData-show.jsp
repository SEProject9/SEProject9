<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<div style="display:none;width: 100%; margin: 2px auto; text-align: center">


		<h1>${info.title }</h1>

		<c:if test="null!=${entInfo.ent_name}">
	${entInfo.ent_name}
	</c:if>
		 <a href="${info.url}">${info.source}</a>&nbsp&nbsp${info.ind_date}<br />
		<br /> ${info.text }<br />

	</div>
	
<iframe src="list/displayPDF"
        width="100%" height="800"></iframe>

	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>
	<script type="text/javascript">
		
	</script>
</body>
</html>