<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_page_style.css">
</head>
<body>
    <div class="wrapper">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <h1>Welcome to LCS Pantau System</h1>
            <h1>Login</h1>
            <br><br>
                        <div class="input-box">
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="input-box">
                <input type="password" name="password" placeholder="Password" required>
            </div>
            
            <div class="remember-forgot">
                <a href="#">Forgot Password?</a>
                <br>
                <br>
                <label><input type="checkbox"> Remember Me</label>
                <br>
                
            </div>
            <br>
            <button type="submit" class="btn">Login</button>
            <div class="register-link">
                <p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a></p>
            </div>
        </form>
    </div>
</body>
</html>
