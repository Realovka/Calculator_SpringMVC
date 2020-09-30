<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form modelAttribute="regUser" method="post" action="/reg_auth/reg/">
    Name <input type="text" name="name">
    Login <input type="text" name="login">
    Password <input type="password" name="password">
    <button>Registration</button>
</form>
</body>
</html>
