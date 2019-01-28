<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	
		<title>注册</title>
		<link href="/MicroBlog/bs/css/bootstrap.min.css" rel="stylesheet">
	    
	</head>
  
	<body class="text-center">
	    <h2>注册账号</h2>
	    <hr>
	    <div class = "col-md-2 col-md-offset-5">
	        <form action = '/MicroBlog/RegisterCl' method = 'post'>
	            
	            <!-- 用户名输入框 -->
	            <div class="form-group">
	                <input type="text" class="form-control" placeholder="用户名" name = "username">
	            </div>
	            
	            <!-- 密码输入框 -->
	            <div class="form-group">
	                <input type="password" class="form-control" placeholder="密码" name = "password">
	            </div>
	            
	            <!-- 密码确认框 -->
	            <div class="form-group">
	                <input type="password" class="form-control" placeholder="确认密码" name = "password2">
	            </div>
	            
	            <% 
	                Object err = request.getAttribute("err");
	                if(err != null) {
	            %>
	                    <!-- 错误信息提示 -->
	                    <p style="color:red"> <%=err.toString() %> </p>
	            <%
	                }
	            %>
	            
	            <div class="form-group">
	                <input type="submit" class="btn btn-warning btn-lg btn-block" value = "立即注册">
	            </div>
	        </form>
	              已有账号？<a href = 'Login.jsp'>返回登录</a>
	    </div>
	    
	    <script src="/MicroBlog/bs/js/jquery.min.js"></script>
	    <script src="/MicroBlog/bs/js/bootstrap.min.js"></script>
	</body>
</html>
