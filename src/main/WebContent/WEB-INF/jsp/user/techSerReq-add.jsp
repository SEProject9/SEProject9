<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<article class="page-container">
		<form action="/sys_edu/user/techSerReq-save" method="post"
			class="form form-horizontal" id="form-bill-add">
			<input type="hidden" name="idName" value="bill_id" />
			<!-- <div class="row cl" style="display: none">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>账单ID：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="hidden" class="input-text" value="" placeholder=""
						id="roleName" name="ID">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>主叫号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="input-text" value="" placeholder="" id="roleName"
						name="user_phone">
				</div>
			</div> -->
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">行业：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select name="ind_id">
						<c:forEach items="${info}" var="c" varStatus="st">
							<option value="${c.ind_id}">${c.ind_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">标题：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="title" name="req_title">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">需求描述：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea name="req_text" rows="16" cols="100" id="text"
						value="aaa"></textarea>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button type="submit" class="btn btn-success radius" id="bill-save"
						name="bill-save">
						<i class="icon-ok"></i> 确定
					</button>
				</div>
			</div>
		</form>
	</article>
	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>

	<!--请在下方写此页面业务相关的脚本-->
	<!-- 	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script> -->
	<script type="text/javascript">
		$(function() {
			var techSer = ${techSer};
			/* var techSer = JSON.parse("${techSer}"); */
			if (null == techSer)
				return;

			console.info(techSer);

			$("indSelect>option").each(function() {
				if ($(this).val() == techSer.ind_id)
					$(this).selected = "selected";
			});
			$("#title").attr("value", techSer.req_title);
			$("#text").html(techSer.req_text);
		});
		/* 	$(function() {
				$("#form-bill-add").validate({
					rules : {
						roleName : {
							required : true,
						},
					},
					onkeyup : false,
					focusCleanup : true,
					success : "valid",
					submitHandler : function(form) {
						$(form).ajaxSubmit();
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					}
				});
			}); */
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>