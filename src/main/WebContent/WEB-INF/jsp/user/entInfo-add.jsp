<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<article class="page-container">
		<form action="/sys_edu/user/entInfo-save" method="post"
			class="form form-horizontal" id="form-bill-add">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">行业：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select name="ind_id" id="indSelect">
						<c:forEach items="${info}" var="c" varStatus="st">
							<option value="${c.ind_id}">${c.ind_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="display: none">
				<label class="form-label col-xs-4 col-sm-3">id:</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="id" name="ent_id">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">企业名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="ent_name" name="ent_name">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">工商号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="ent_num" name="ent_num">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">地址：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="ent_add" name="ent_add">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">电话：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="ent_phone" name="ent_phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">企业描述：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea name="ent_text" rows="16" cols="100" id="ent_text"></textarea>
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

	<!--请在下方写此页面业务相关的脚本  -->
	<!-- 用于填空判断是否为空 
	根据规则判断是否发送后台-->
	<!-- 	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script> -->

	<script type="text/javascript">
		$(function() {
			var entInfo = ${entInfo};
			alert(entInfo);
			if (null == entInfo)
				return;
			console.info(entInfo);
			$("indSelect>option").each(function() {
				if ($(this).val() == entInfo.ind_id)
					$(this).selected = "selected";
			});
			$("#id").attr("value", entInfo.ent_id);
			$("#ent_name").attr("value", entInfo.ent_name);
			$("#ent_num").attr("value", entInfo.ent_num);
			$("#ent_add").attr("value", entInfo.ent_add);
			$("#ent_phone").attr("value", entInfo.ent_phone);
			$("#ent_text").html(entInfo.ent_text);
		});

		/* $(function() {
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