<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	
		<title>登录</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"></script>
		
		<script>
		    $(document).ready(function() {
		        //鼠标选中时移除"用户名"
		        $("#name").focus(function () {
	                $("#name").attr("placeholder", "");
	                $("#prompt").text("");
		        })
		        
		        //验证用户名不为空
		        $("#name").blur(function () {
		            if($("#name").val() === "") {
		                $("#name").attr("placeholder", "用户名");
		                $("#prompt").attr("style", "color:red");
		                $("#prompt").text("用户名不能为空");
		            }
		        })
		        
		        //鼠标选中时移除"密码"
		        $("#password").focus(function () {
                    $("#password").attr("placeholder", "");
                })
                
                //鼠标离开时增加"密码"
                $("#password").blur(function () {
                    $("#password").attr("placeholder", "密码");
                })
		    })
		</script>
	
	</head>

	<body class="text-center">
		<h2>账号登录</h2>
		<hr>
		<div class="col-md-2 col-md-offset-5">
		   	<form action='/MicroBlog/LoginCl' method='post'>
		   	    
		   	    <!-- 用户名输入框 -->
				<div class="form-group">
			        <div class="input-group">
				        <span class="input-group-addon"> <span class="glyphicon glyphicon-user"></span></span>
					    <input id="name" type="text" class="form-control" placeholder="用户名" name="username">
				    </div>
				    <span id="prompt"></span>
				</div>
	           
	            <!-- 密码输入框 -->
				<div class="form-group">
				    <div class="input-group">
				        <span class="input-group-addon"> <span class="glyphicon glyphicon-lock"></span></span>
					    <input id="password" type="password" class="form-control" placeholder="密码" name="password">
				    </div>
				</div>
	
				<%
				    Object err = request.getAttribute("err");
				    if (err != null) {
				%>
				        <!-- 错误信息提示 -->
				        <p style="color:red"><%=err.toString()%></p>
				<%
				    }
				%>
	
				<div class="form-group">
					<input type="submit" class="btn btn-primary btn-lg btn-block" value="登录">
				</div>
			</form>
			还没有微博？<a href='Register.jsp'>立即注册！</a>
		</div>
	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	</body>
</html>
