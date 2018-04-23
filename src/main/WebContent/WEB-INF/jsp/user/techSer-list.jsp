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
	<div class="cl pd-5 bg-1 bk-gray ">
		<c:if
			test="${session.user.ent_id!=null&&session.user.ent_id.equals(ent_id)}">判断是否查看自己企业&是否登录
			<span class="l"><a class="btn btn-primary radius"
				data-title="添加" href="javascript:;"
				onclick="techSer_add('发布需求','/sys_edu/user/techSerReq-add')"><i
					class="Hui-iconfont">&#xe600;</i> 发布需求</a>&nbsp&nbsp&nbsp<a
				class="btn btn-primary radius" data-title="添加" href="javascript:;"
				onclick="techSer_add('发布供应','/sys_edu/user/techSerSup-add')"><i
					class="Hui-iconfont">&#xe600;</i> 发布供应</a></span>
		</c:if>

		<div class="text-c">
			<span class="select-box inline"> <select name="state"
				id="selectState">
					<option value="">全部</option>
					<option value="1">已通过审核</option>
					<option value="2">已匹配</option>
					<option value="0">审核未通过</option>
					<option value="3">待审核</option>
			</select> <select name="type" id="selectType">
					<option value="1">发布的提供</option>
					<option value="2">发布的需求</option>
			</select>
			</span>
		</div>
	</div>


	<div style="width: 500px; margin: 10px auto; text-align: center">
		<c:choose>
			<c:when test="${null==type||1==type}">
				<c:forEach items="${info}" var="c" varStatus="st">
					<div style="margin-buttom: 1px">
						<a href="/sys_edu/list/techSerSup-show?id=${c.sup_id}">
							${c.sup_title }</a><br />
						<p>${c.sup_date }</p>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach items="${info}" var="c" varStatus="st">
					<div style="margin-buttom: 1px">
						<a href="/sys_edu/list/techSerReq-show?id=${c.req_id}">
							${c.req_title }</a><br />
						<p>${c.req_date }</p>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>

		<div style="text-align: center; margin-top: 20px">
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
		$(function() {
			type = "${type}";
			state = "${state}";

			/* 	匹配不上默认第一个 */
			$("#selectState>option").each(function() {
				if ($(this).val() == state) {
					this.selected = "selected";
				}
			});
			$("#selectType>option").each(function() {
				if ($(this).val() == type) {
					this.selected = "selected";
				}
			});

		});
		function techSer_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url,
				area : [ '1000px', '550px' ]
			});
		}
		$("#selectState,#selectType").change(
				function() {
					var state = $("#selectState>option:selected").val();
					var type = $("#selectType>option:selected").val();
					console.info(state);
					var url = "/sys_edu/list/techSer-list?state=" + state
							+ "&type=" + type + "&ent_id=" + "${ent_id}";
					$(location).attr('href', url);
				})
	</script>
</body>
</html>