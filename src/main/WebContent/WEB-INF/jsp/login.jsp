<%@include file="/WEB-INF/jsp/include/_meta.jsp"%>
<link href="/sys_edu/static/h-ui.admin/css/H-ui.login.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header" style="display: none"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="/sys_edu/user/login"
				method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="account" name="account" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl" style="display: none">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" placeholder="验证码"
							onblur="if(this.value==''){this.value='验证码:'}"
							onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:"
							style="width: 150px;"> <img src=""> <a id="kanbuq"
							href="javascript:;">看不清，换一张</a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online"
							id="online" value=""> 记住密码
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<button name="" id="submit_button" type="button"
							class="btn btn-success radius size-L">&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp</button>
						<input style="display: none" name="" type="reset"
							class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;"> <input
							name="" type="button" class="btn btn-default radius size-L"
							id="signup" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
					</div>
				</div>
			</form>
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-9">
					<label><a href="/sys_edu/user/tourist"> 游客登录</a></label>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">Copyright gdufe by sys_project9</div>

	<%@include file="/WEB-INF/jsp/include/_footer.jsp"%>

	<script type="text/javascript">
		/* $("#online").click(function() {
			//配置一个透明的询问框
			layer.msg('大部分参数都是可以公用的<br>合理搭配，展示不一样的风格', {
				time : 1500, //20s后自动关闭
				btn : [ '明白了', '知道了', '哦' ]
			});
		}) */
		$("#submit_button").click(function(){
			var data=$("form").serialize();
			$.ajax({
				url:"/sys_edu/user/checkAcccount",
				data:data,
				type:"post",
				dataType:"json",
				success:function(data){
					console.info(data.success);
					if(data.success){
						window.location.href="/sys_edu/user/login";
					}else{
						layer.msg("账户/密码错误");
					}
				}
			})
				
		});
		$("#signup").click(function() {
			var index = layer.open({
				type : 2,
				title : "注册",
				content : "/sys_edu/user/signupPage",
				area : [ '500px', '300px' ],
				end : function() { //!!!只要弹窗销毁就会执行
					location.reload();
				}
			});
		});
	</script>
</body>
</html>