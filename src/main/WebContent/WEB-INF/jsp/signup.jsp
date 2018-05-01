<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
</head>
<body>
	<article class="page-container">
		<form  method="post"
			class="form form-horizontal" id="form-bill-add">
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-3">账户：</label>
				<div class="formControls col-xs-8 col-sm-4">
					<input type="text" class="input-text" value="" placeholder=""
						id="account" name="ent_account">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-3">密码：</label>
				<div class="formControls col-xs-8 col-sm-4">
					<input type="text" class="input-text" value="" placeholder=""
						id="password" name="ent_password">
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
	<script type="text/javascript"
		src="/sys_edu/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="/sys_edu/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="/sys_edu/lib/jquery.validation/1.14.0/messages_zh.js"></script>

	<script type="text/javascript">
		$(function() {
			$("#form-bill-add").validate({
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$(form).ajaxSubmit({
						url:"/sys_edu/user/signup",
						success:function(data) {
							if(null!=data&&data=="success"){
								/* alert("data.success"+data); */
								layer.msg('注册成功', {
									icon : 1,
									time : 1000
								});
								setTimeout(function(){window.parent.location.reload();
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index)},2000);
							}
							else{
								/* alert("data.err"+data); */
								layer.msg('用户名重复', {
									icon : 2,
									time : 1000
								});
								/* window.close();  mmp没有用*/
							/* 	window.parent.location.reload();
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index); */
								
								
							}
						},
						error : function(data) {
							/* alert("error"); */
							layer.msg('怪服务器', {
								icon : 2,
								time : 1000
							});
							return;
						}
					});//ajax
					/*  var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);  */
				}//submitHandler
			});//validate
		});//function

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